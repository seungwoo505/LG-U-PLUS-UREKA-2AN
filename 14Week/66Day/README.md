# 보안

## credentials

`credentials : true` 설정을 하게되면 CORS 미들웨어가 응답 헤더에
`Access-Control-Allow-Credentials: true`를 추가한다.

이 옵션이 활성화가 되면 브라우저는 다음을 허용한다.

- 쿠키 전송
  클라이언트가 fetch의 `credentials: 'include'` 혹은 Axios의 `withCredentials : true`
  등을 사용할 때, 브라우저가 서버로 쿠키를 포함해 요청을 보낸다.

- 인증 헤더 전송
  HTTP 기본 인증(Authorization 헤더)이나 기타 인증 정보를 크로스 도메인 요청에 포함시킬 수 있다.

즉 `credentials : true` 없이 CORS 요청을 보내면 브라우저는 도메인이 다른 서버에 쿠키나 인증 헤더를 포함시켜 보낼 수 없도록 차단한다.
(옵션을 활성화할 경우 서버가 다른 서버의 요청에도 쿠키나 인증 정보를 받아준다는 선언을 한 것)

## HttpOnly

클라이언트 측 자바스크립트에서 해당 쿠키에 접근하지 못하도록 만드는 보안 옵션

- 역할
  - 브라우저가 Set-Cookie 헤더에 HttpOnly 속성을 붙여 저장
  - document.cookie 같은 스크립트 API로 읽거나 수정할 수 없다.
- 장점
  - XSS(크로스 사이트 스크립팅) 공격으로부터 쿠키 탈취 방어
  - 토큰, 세션 ID 같은 민감 정보 보호 강화

즉 HttpOnly 옵션을 키게되면 HTTP 요청에서만 쿠키가 오가고 페이지 내 스크립트에서는 전혀 볼 수 없다.

# secure

`secure: true` 옵션은 브라우저가 HTTPS(SSL/TLS) 연결을 통해서만 해당 쿠키를 전송하도록 지시

- 역할
  - HTTPS 프로토콜에서만 쿠키를 포함시켜 요청
  - 중간자 공격(Man-in-the-Middle)으로부터 쿠키 탈취 위험 감소
- 주의 사항
  - 개발 환경에서는 `secure: true` 설정 시 쿠키가 전송되지않으므로(로컬에서 http:// 를 사용하므로 전송 불가능),
    `process.env.NODE_ENV === 'production'`으로 설정한다.(NODE_ENV가 기본적인 값이 production 이여서 NODE_ENV가 항상 production 이므로 상시 동작되게하겠다는 의미)
  - SameSite=None과 같이 크로스 사이트에서 쿠키를 보내야 할 때도, 보안 요구사항 때문에 secure: true가 필수

# sameSite

쿠키가 어떤 상황에서 브라우저에 포함될지를 제어해서 CSRF(사이트 간 요청 위조) 공격을 방어하는데 도움을 준다.

1. Strict

- 완전 차단 : 사용자가 다른 도메인(a.com)에서 링크를 클릭하여 b.com으로 이동하는 경우, 해당 요청에 쿠키가 포함되지 않는다.
- 장점 : CSRF 위험 최소
- 단점 : 정상적인 크로스 도메인 네비게이션에서도 쿠키가 안 붙어 로그인 상태가 풀릴 수 있다.

2. Lax(기본 값)

- 제한적 허용 : 크로스 도메인 리소스 요청(GET 링크 클릭, 주소창 직접 이동 등)에는 쿠키를 포함하지만, POST, AJAX 같은 상태 변경 요청에는 쿠키 제외
- 장점 : 일반적인 링크 이동 시 로그인을 유지하면서, 중요한 상태 변경 요청은 보호
- 단점 : 일부 POST 기반 폼 전송이 예상대로 동작하지 않을 수 있다.

3. None

- 완전 허용 : 모든 상황에 쿠키를 포함한다.
- 주의 : 이 옵션을 사용하려면 반드시 secure: true(HTTPS 전용)도 함께 설정해야 최신 브라우저에서 허용된다.
- 용도 : iframe 안에서 인증 쿠키를 주고받아야 할 때(서드파티 컨텍스트)
