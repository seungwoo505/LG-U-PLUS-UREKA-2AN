# 디바운싱(Debouncing)과 스로틀링(Throttling)

두 기법은 웹 애플리케이션에서 이벤트 처리를 최적화하는 방법으로,
특히 연속적으로 발생하는 이벤트(스크롤, 리사이즈, 키보드 입력 등)을 효율적으로 처리할 때 유용.

## 디바운싱(Debouncing)

개념: 디바운싱은 연속적으로 발생하는 이벤트 중 마지막 이벤트만 처리하는 기법.
일정 시간 내에 추가 이벤트가 발생하면 타이머를 재설정하고 더 이상 발생하지 않을 때 최종적으로 함수 실행

사용 사례

- 검색창의 자동완성 기능(사용자가 타이핑을 멈춘 후에만 API 호출)
- 윈도우 리사이즈 이벤트 처리
- 폼 입력값 검증

예시코드

```

function debounce(func, delay) {
  let timeoutId;

  return function(...args) {
// 이전 타이머가 있으면 취소
    if (timeoutId) {
      clearTimeout(timeoutId);
    }

// 새로운 타이머 설정
    timeoutId = setTimeout(() => {
      func.apply(this, args);
    }, delay);
  };
}

// 사용 예시: 검색창 입력 디바운싱
const searchInput = document.getElementById('search');
const handleSearch = (e) => {
  console.log('Searching for:', e.target.value);
// API 호출 등의 작업
};

// 300ms 동안 추가 입력이 없을 때만 검색 수행
searchInput.addEventListener('input', debounce(handleSearch, 300));

```

## 스로틀링

개념 : 일정 시간 간격으로 함수를 최대 한번만 실행하도록 제한하는 기법이다.
디바운싱과 달리 마지막 이벤트를 기다리지 않고, 정해진 주기마다 한번씩 함수를 실행

사용사례

- 스크롤 이벤트 처리(무한 스크롤)
- 게임의 키보드 / 마우스 이벤트 처리
- 빠르게 변화하는 UI 업데이트(차트, 그래프 등)

예시 코드

```

function throttle(func, limit) {
  let inThrottle = false;

  return function(...args) {
    if (!inThrottle) {
      func.apply(this, args);
      inThrottle = true;

// 지정된 시간 후에 플래그 초기화
      setTimeout(() => {
        inThrottle = false;
      }, limit);
    }
  };
}

// 사용 예시: 스크롤 이벤트 스로틀링
const handleScroll = () => {
  console.log('Scroll position:', window.scrollY);
// 스크롤 위치 기반 작업 수행
};

// 200ms마다 최대 한 번씩만 스크롤 이벤트 처리
window.addEventListener('scroll', throttle(handleScroll, 200));

```

## 차이점

- 디바운싱 : 마지막 이벤트 후 일정 시간이 지나면 한번만 실행(ex) 타이핑이 끝난 후)
- 스로틀링 : 일정 시간 간격으로 최대 한번씩 실행(ex) 200ms마다 한번씩)

## 실무

실제 프로젝트에서는 Lodash나 Underscore같은 라이브러리의 구현체를 많이 사용합니다.

```

import _ from 'lodash';

// 디바운싱
const debouncedFunction = _.debounce(originalFunction, 300);

// 스로틀링
const throttledFunction = _.throttle(originalFunction, 200);

```

이 두 기법을 적절히 활용하면 성능을 크게 개선하고 불필요한 API 호출과 계산을 줄일 수 있다.

# HydrateFallback 경고 메시지 처리

웹 사이트가 처음 로딩될 때, 서버에서 만든 HTML과 브라우저에서 실행되는 JavaScript가 서로 연결되는 과정을 "하이드레이션"이라고한다.

활성화시키는 과정이라고 생각하면된다.

이 과정에서 데이터가 아직 준비되지 않았을 때 사용자에게 보여줄 임시화면이 필요한데, 이것이 HydrateFallback 요소라고한다.

위 오류는 '데이터를 기다리는 동안 보여줄 임시화면이 없다.'라는 의미이다.

해결방법은 main.js에서 RouterProvider에게 '로딩 중...' 같은 간단한 대체 화면을 제공하면된다.

fallbackElement는 RouterProvider 컴포넌트의 속성(prop)이다.

```

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} fallbackElement={<div>로딩중...</div>} />
  </StrictMode>
)

```

# 프록시 서버 설정

vite의 서버 프록시 설정은 개발 중에 발생하는 CORS(Cross-Origin Resource Sharing) 문제를 해결하고 API 요청을 더 효율적으로 관리하기위해 사용

주요 목적과 장점

1. CORS 문제 해결 :
   - 브라우저의 동일 출처 정책으로 인해, 프론트엔드에서 다른 도메인이나 다른 포트의 백엔드로 직접 API 요청을 보낼 수 없다.
   - 프록시는 이 요청을 프론트엔드 서버를 통해 우회하여 CORS 오류를 방지할 수 있다.
2. API 경로 단순화 :
   - '/api'와 같은 접두어로 모든 API 요청을 통합하여 관리할 수 있다.
3. 환경 간 일관성 :
   - 개발 환경과 프로덕션 환경에서 동일한 API 경로를 사용할 수 있다.
   - 프로덕션에서는 서버 측 프록시나 웹 서버 설정으로 이를 처리할 수 있다.

예시

```

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:3000',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/api/, ''),
      },
    },
  },
})

```

- '/api'로 시작하는 모든 요청은 'http://localhost:3000'으로 리다이렉트된다.
- 'changeOrigin: true'는 호스트 헤더를 대상 URL의 호스트 이름으로 변경하여 CORS 문제를 방지
- rewrite 함수는 URL에서 '/api' 접두어를 제거한다.
  즉, 클라이언트 : '/api/products' (요청) -> 서버 : 'http://localhost:3000/products' (전달)

이렇게하면 개발자는 API 서버의 실제 주소를 알 필요없이 상대 경로만으로 쉽게 API를 호출할 수 있으며
백엔드 서버의 위치가 변경되더라도 Vite 설정만 수정하면 된다.
