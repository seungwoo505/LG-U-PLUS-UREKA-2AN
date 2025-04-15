import { createBrowserRouter } from "react-router-dom";
import Default from "./layout/Default";
import { lazy } from "react";

const MainPage = lazy(() => import('./pages/MainPage'));
const AboutPage = lazy(() => import('./pages/AboutPage'));
const ShopPage = lazy(() => import('./pages/ShopPage'));
const BlogPage = lazy(() => import('./pages/BlogPAge'));
const CartPage = lazy(() => import('./pages/CartPage'));
const NotFound = lazy(() => import('./pages/NotFound'));

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