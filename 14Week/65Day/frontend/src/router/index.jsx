import { createBrowserRouter } from "react-router-dom";
import DefaultLayout from "../common/DefaultLayout";
import RegisterPage from "../pages/RegisterPage";

export const router = createBrowserRouter([
    {
        path : '/',
        element : <DefaultLayout />,
        errorElement : <div>에러</div>,
        children : [
            {
                index : true,
                element : <div>홈</div>
            },
            {
                path : '/register',
                element : <RegisterPage />
            }
        ]
    }
]);