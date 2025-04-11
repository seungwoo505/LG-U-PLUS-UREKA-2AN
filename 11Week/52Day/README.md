# React Router

개념 : 웹 애플리케이션에서 URL에 따라 다른 콘텐츠를 사용자에게 보여주는 메커니즘이다.
전통적인 웹사이트에서는 각 URL이 서버에 있는 다른 HTML 파일을 요청하는 방식으로 작동했다.

그런데 React와 같은 단일 페이지 애플리케이션(SPA)에서는 클라이언트 사이드 라우팅(CSR)이 사용됩니다.

특정

1. 웹 애플리케이션이 처음 로드될 때 필요한 모든 JavaScript를 다운로드합니다.
2. URL이 변경되면 새로운 페이지를 서버에서 받아오는 대신,
   JavaScript가 브라우저의 히스토리 API를 사용하여 URL을 변경하고 화면에 표시되는 컴포넌트를 변경
3. 페이지 전체를 변경하지않기 때문에 더 빠른 사용자 경험을 제공(변경되는 부분만 리렌더링)

## 라우터 설정

routes/index.jsx

```

import { createBrowserRouter, RouterProvider } from "react-router-dom";

const router = createBrowserRouter([
    {
        element : <Default />,
        children : [
            {
                path : "/",
                element : <MainPage />
            },
            {
                path : "/about",
                element : <AboutPage />
            },
            {
                path : "shop",
                element : <ShopPage />,
                children : [
                    {
                        path : "shopSub1",
                        element : <ShopSubPage1 />
                    }
                ]
            }
        ]
    },
    {
        path : "*",
        element : <NotFoundPage />
    }
]);

export default function Router(){
    return <RouterProvider router={router} />
}

```

main.jsx

```

import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import Router from './routes'

createRoot(document.getElementById('root)).render(
    <StrictMode>
        <Router />
    </StrictMode>
);

```

## 레이아웃 구현

Header.jsx

```

import { Link, NavLink } from 'react-router-dom';

const Header = () => {
    return(
        <header>
            <nav>
                {/*
                    Link와 NavLink는 페이지 전체를 새로고침하지않고 클라이언트 측 라우팅을 구현(부분 리렌더링)
                    NavLink는 현재 경로와 일치할 때 해당 태그에 active 클래스 추가
                */}
                <Link to="/">Home</Link>
                <NavLink to="/about">About</NavLink>
            </nav>
        </header>
    )
};

export default Header;

```

Default.jsx

```

import { Outlet } from 'react-router-dom';
import Header from '@/components/Header';

const Default = () => {
    return(
        <>
            <Header />
            <Outlet />
        </>
    )
};

export default Default;

```

useNavigate 훅

```

import { useNavigate } from 'react-router-dom'

const ErrorPage = () => {
    const navigate = useNavigate();

    const goPage = () => {
        navigate('/');
    }

    const replace = () => {
        navigate('/', { replace : true });
    }

    const go = (n) => {
        navigate(n);
    }

    return(
        <>
            <button onClick={goPage}>페이지 이동</button>
            <button onClick={replace}>페이지 이동</button>
            <button onClick={() => go(1)}>앞으로 이동</button>
            <button onClick={() => go(-1)}>뒤로 이동</button>
        </>
    )

}

```
