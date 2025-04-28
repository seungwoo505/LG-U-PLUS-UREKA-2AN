import {createBrowserRouter} from 'react-router-dom';
import MainLauout from '../layout/MainLauout';
import WeatherPage from '../weather/WeatherPage';

export const router = createBrowserRouter([
    {
        path : '/',
        element : <MainLauout />,
        errorElement : <div>에러</div>,
        children : [
            {
                index : true,
                element : <WeatherPage />
            }
        ]
    }
]);