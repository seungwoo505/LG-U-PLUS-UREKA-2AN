# URL, URLSearchParams

1. URL 객체의 개념
   URL 객체는 웹 주소(URL)를 파싱하고 조작하기 위한 JavaScript의 내장 API이다.
   URL 객체를 사용하면 URL의 각 구성 요소(프로토콜, 호스트, 경로, 쿼리 매개변수 등)에 쉽게 접근하고 수정할 수 있다.

```

https://www.example.com:8080/path/to/page?name=value&search=test#section
└─┬─┘   └─────┬─────┘ └─┬──┘└─────┬─────┘└───────┬─────────────┘└──┬──┘
프로토콜     호스트     포트      경로        쿼리 매개변수    해시(프래그먼트)

```

2. URLSearchParams 객체의 개념

URLSearchParams 객체는 URL의 쿼리 문자열(query string)을 쉽게 처리하기 위한 API입니다.
URL의 ? 뒤에 오는 부분(ex) ?name=value&search=test)을 파싱하여 각 매개변수에 접근하고 조작할 수 있게 해준다.

3. URL 객체 사용 방법

- 기본 사용법

```

// URL 객체 생성
const url = new URL('https://www.example.com:8080/path/to/page?name=value&search=test#section');

// URL 구성 요소에 접근
console.log(url.protocol);// 'https:'
console.log(url.hostname);// 'www.example.com'
console.log(url.host);// 'www.example.com:8080'
console.log(url.port);// '8080'
console.log(url.pathname);// '/path/to/page'
console.log(url.search);// '?name=value&search=test'
console.log(url.hash);// '#section'
console.log(url.origin);// 'https://www.example.com:8080'

```

- URL 객체 수정하기

```

const url = new URL('https://www.example.com/cart');

// 경로 변경
url.pathname = '/products';

// 포트 추가
url.port = '3000';

// 쿼리 매개변수 추가
url.searchParams.append('category', 'books');

// 결과 확인
console.log(url.href);// 'https://www.example.com:3000/products?category=books'

```

- 상대 URL 처리

```

// 기본 URL을 기준으로 상대 URL 처리
const baseURL = new URL('https://www.example.com/products/');
const relativeURL = new URL('electronics', baseURL);

console.log(relativeURL.href);// 'https://www.example.com/products/electronics'

```

4. URLSearchParams 객체 사용 방법

- 기본 사용법

```

// 문자열로 URLSearchParams 생성
const params1 = new URLSearchParams('name=value&search=test');

// 객체로 URLSearchParams 생성
const params2 = new URLSearchParams({
  category: 'books',
  author: 'John Doe'
});

// URL 객체의 searchParams 속성을 통해 접근
const url = new URL('https://www.example.com/?page=1&limit=10');
const params3 = url.searchParams;

```

- 매개변수 다루기

```

// 문자열로 URLSearchParams 생성
const params1 = new URLSearchParams('name=value&search=test');

// 객체로 URLSearchParams 생성
const params2 = new URLSearchParams({
  category: 'books',
  author: 'John Doe'
});

// URL 객체의 searchParams 속성을 통해 접근
const url = new URL('https://www.example.com/?page=1&limit=10');
const params3 = url.searchParams;

```

5. 브라우저 지원

- Chrome 32+
- Firefox 26+
- Safari 10+
- Edge 12+

구형 브라우저에서는 폴리필(polyfill)을 사용해야 할 수 있다.

6. useSearchParams와 URLSearchParams의 차이

- 접근 방식 비교

  1. navigate + URLSearchParams

  ```

  const params = new URLSearchParams(searchParams)
  params.set('_page', 1)
  params.set('_per_page', per_page)
  navigate(`/shop/?${params}`)

  ```

  2. setSearchParams

  ```

  setSearchParams({ _page: 1, _per_page: per_page })

  ```

- 주요 차이점

  1. 새로운 항목 처리

  - `setSearchParams({_page : 1})`는 다른 모든 쿼리 파라미터를 제거합니다.
  - `params.set('_page', 1)` 후 `navigate`를 사용하면 기존의 다른 파라미터를 유지한다.

  2. 상세한 제어

  - navigate + URLSearchParams : 쿼리 파라미터 조작에 더 세밀한 제어가 가능하다.
  - setSearchParams : 더 간결하고 리액트 스타일

  3. 다른 파라미터 유지하기

  - setSearchParams를 사용하면서 기존 파라미터를 유지하려면

    ```

    setSearchParams(prevParams => {
    // 현재 파라미터를 객체로 변환
      const newParams = {};
      for (const [key, value] of prevParams.entries()) {
        newParams[key] = value;
      }
    // 새 값 추가/업데이트
      newParams._page = 1;
      newParams._per_page = per_page;
      return newParams;
    });

    ```

  4. 히스토리 처리

  - `navigate`는 새 히스토리 항목을 생성
  - `setSearchParams`도 기본적으로 새 히스토리 항목을 생성하지만, 옵션을 통해 조정할 수 있다.

    ```

    setSearchParams({ _page: 1 }, { replace: true })// 히스토리 항목 대체

    ```

- 어떤 것을 사용해야하는가?

  1. 간단한 케이스 : `setSearchParams`를 사용하면 코드가 더 간결해진다.

  ```

  setSearchParams({ _page: 1, _per_page: per_page, category })

  ```

  2. 복잡한 조작이 필요한 경우 : URLSearchParams + navigate 방식이 더 유연하고 명확하다.

  ```

  const params = new URLSearchParams(searchParams)
  params.set('_page', 1)
  category ? params.set('category', category) : params.delete('category')
  navigate(`/shop/?${params}`)

  ```

  두 방식 모두 유효하므로, 프로젝트의 일관성과 요구사항에 맞게 선택하면된다.
