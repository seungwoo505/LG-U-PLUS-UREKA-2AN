# useLocation

React Router 라이브러리에서 제공하는 훅(hook)이며, 현재 브라우저의 URL 정보를 가져오는데 사용된다.
이 훅은 컴포넌트 내에서 현재 페이지의 경로, 쿼리 매개변수, 해시 등 URL에 관련된 정보에 접근할 수 있게 해준다.

## useLocation이 반환하는 객체의 주요 속성

1. pathname : 현재 URL의 경로 부분 [ex) '/about']
2. search : URL의 쿼리 문자열 부분 [ex) '?id=123']
3. hash : URL의 해시 부분 [ex) '#section1']
4. state : 페이지 이동 시 전달된 상태 객체(props)
5. key : 각 위치에 대한 고유 식별자

## 사용법

```

import { useLocation } from 'react-router-dom';

function MyComponent() {
    const location = useLocation();

    console.log(location.pathname);
    console.log(location.search);
    console.log(location.hash);
    console.log(location.state);

    return (
        <div>
            Current path : {location.pathname}
        </div>
    )
}

```
