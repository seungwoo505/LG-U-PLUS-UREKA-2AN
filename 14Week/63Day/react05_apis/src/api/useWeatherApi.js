import axios from 'axios';

const BASE_URL = 'https://api.openweathermap.org/data/2.5/weather';
const API_KEY = import.meta.env.VITE_WEATHER_API_KEY;
//https://api.openweathermap.org/data/2.5/weather?lat=44&lon=10&appid=c00b7848860b31ff6376c684f3e5ef9a&lang=kr&units=metric

//좌표로 날씨 정보 가져오기
export const getWeatherByCurrentLocation = async (lat, lon) => {
    try {
        const res = await axios.get(`${BASE_URL}?lat=${lat}&lon=${lon}&appid=${API_KEY}&lang=kr&units=metric`);

        return res.data;
    } catch (error) {
        console.error('err --- ', error);
    }
}

// 현재 좌표로 날씨 정보 가져오기
export const getCurrentData = async () => {
    return new Promise((resolve, reject) => {
        navigator.geolocation.getCurrentPosition(async (position) => {
            const { latitude, longitude } = position.coords;
            const res = await getWeatherByCurrentLocation(latitude, longitude);

            resolve(res);
        }, err => {
            console.log('err--', err);
            reject(err);
        });
    })
}

//도시명으로 날씨 정보 가져오기
export const getCountryData = async city => {
    try {
        const res = await axios.get(`${BASE_URL}?q=${city}&appid=${API_KEY}&lang=kr&units=metric`);
        return res.data;
    } catch (error) {
        console.log('좌표 정보 실패', error);
    }
}