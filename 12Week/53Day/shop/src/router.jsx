import { createBrowserRouter } from "react-router-dom";
import Default from "./layout/Default";
import MainPage from "./pages/MainPage";
import AboutPage from "./pages/AboutPage";
import NotFound from "./pages/NotFound";
import ShopPage from './pages/ShopPage';
import BlogPage from './pages/BlogPage';
import CartPage from './pages/CartPage';

const router = createBrowserRouter([
    {
        path : '/',
        element : <Default />,
        errorElement : <NotFound />,

        children : [
            {
                path : '',
                element : <MainPage />
            },

            {
                path : '/about',
                element : <AboutPage />
            },

            {
                path : '/shop',
                element : <ShopPage />
            },

            {
                path : '/blog',
                element : <BlogPage />
            },

            {
                path : '/cart',
                element : <CartPage />
            }
        ]
    },
    {
        path : '*',
        element : <NotFound />
    }
]);

export default router;