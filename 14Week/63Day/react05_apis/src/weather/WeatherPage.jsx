import React, { useEffect, useState } from 'react'
import style from './WeatherPage.module.css';
import { getCountryData, getCurrentData } from '../api/useWeatherApi';
import { useSearchParams} from 'react-router-dom';
import Button from './Button';

const WeatherPage = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const city = searchParams.get('city');
    const [weatherData, setWeatherData] = useState(null);

    const cityButton = [
        {id : 'current', label : '현재위치'},
        {id : 'seoul', label : '서울'},
        {id : 'hongkong', label : '홍콩'},
        {id : 'new york', label : '뉴욕'},
        {id : 'paris', label : '파리'}
    ];

    const handleChangeCity = city => {
        setSearchParams(city === 'current' ? {} : { city });
    }
    useEffect(() => {
        const fetchWeatherData = async () => {
            try {
                const data = city ? await getCountryData(city) : await getCurrentData();
                console.log('날씨', data);
                setWeatherData(data);
            } catch (error) {
                console.error('err---', error);
            }
        }

        fetchWeatherData();
    }, [city]);

  return (
    <main className={style.main}>
        <h2>WeatherPage</h2>
        <div className={style.weatherInfo}>
            <p className={style.location}>{weatherData?.sys.country} | {weatherData?.name}</p>
            <div className={style.tamperature}>
                <p>{weatherData?.main.temp} &#8451;</p>
                <p>
                    <img src={`http://openweathermap.org/img/wn/${weatherData?.weather[0].icon}.png`} alt='' />
                </p>
            </div>
        </div>
        <div className={style.btnList}>
            {cityButton.map(button => (
                <Button key={button.id}
                city={button.id}
                label={button.label}
                onClick={handleChangeCity} />
            ))}
        </div>
    </main>
  )
}

export default WeatherPage;