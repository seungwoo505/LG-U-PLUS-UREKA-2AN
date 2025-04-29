import { useQuery } from '@tanstack/react-query'
import axios from 'axios'

const API_KEY = import.meta.env.VITE_WEATHER_API_KEY
const BASE_URL = 'https://api.openweathermap.org/data/2.5/weather'
// const testurl =
//   'https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=52a5fc484a17e73885fdc369f65278ab'

// 좌표로 날씨정보 가져오기
export const getWeatherByCurrentLocation = async (lat, lon) => {
  try {
    const res = await axios.get(
      `${BASE_URL}?lat=${lat}&lon=${lon}&appid=${API_KEY}&lang=kr&units=metric`
    )
    return res.data
  } catch (err) {
    console.log('좌표로 날씨정보 가져오기 실패', err)
  }
}

// 현재 위치 날씨 정보 가져오기
// 현재 좌표 가져오기
//getWeatherByCrrentLocation(위도, 경도)
export const getCurrentData = async () => {
  return new Promise((resolve, reject) => {
    navigator.geolocation.getCurrentPosition(
      async position => {
        try {
          const { latitude, longitude } = position.coords
          const res = await getWeatherByCurrentLocation(latitude, longitude)
          resolve(res)
        } catch (err) {
          console.log('좌표로 날씨정보 가져오기 실패', err)
          reject(err)
        }
      },
      err => {
        console.log('좌표 가져오기 실패', err)
        reject(err)
      }
    )
  })
}

// 도시명으로 날씨정보 가져오기
export const getCountryData = async city => {
  try {
    const res = await axios.get(`${BASE_URL}?q=${city}&appid=${API_KEY}&lang=kr&units=metric`)
    return res.data
  } catch (err) {
    console.log('좌표로 날씨정보 가져오기 실패', err)
  }
}

export const useWeather = city => {
  return useQuery({
    queryKey: ['weather', city],
    queryFn: async () => {
      try {
        const data = city ? await getCountryData(city) : await getCurrentData()
        return data
      } catch (err) {
        console.log('', err)
      }
    },
    staleTime: 1000 * 3,
    retry: 1,
  })
}
