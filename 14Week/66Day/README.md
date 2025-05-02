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

## secure

`secure: true` 옵션은 브라우저가 HTTPS(SSL/TLS) 연결을 통해서만 해당 쿠키를 전송하도록 지시

- 역할
  - HTTPS 프로토콜에서만 쿠키를 포함시켜 요청
  - 중간자 공격(Man-in-the-Middle)으로부터 쿠키 탈취 위험 감소
- 주의 사항
  - 개발 환경에서는 `secure: true` 설정 시 쿠키가 전송되지않으므로(로컬에서 http:// 를 사용하므로 전송 불가능),
    `process.env.NODE_ENV === 'production'`으로 설정한다.(NODE_ENV가 기본적인 값이 production 이여서 NODE_ENV가 항상 production 이므로 상시 동작되게하겠다는 의미)
  - SameSite=None과 같이 크로스 사이트에서 쿠키를 보내야 할 때도, 보안 요구사항 때문에 secure: true가 필수

## sameSite

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

## Cookie-Parser

1. Cookie-Parser 란
   Node.js와 Express 애플리케이션에서 HTTP 요청의 쿠키를 쉽게 처리할 수 있게 해주는 미들웨어이다.
   쿠키 문자열을 파싱하여 JavaScript 객체로 반환해주어 서버에서 쿠키를 간편하게 읽고 설정하고 관리할 수 있게 해준다.
   사용자 인증, 세션 관리, 개인화된 설정 저장 등 다양한 기능을 구현할 수 있다.

2. 왜 사용하는가?
3. 쿠키 처리의 어려움
   쿠키는 웹 개발에서 중요한 정보 저장 메커니즘이지만, 원시 형태의 쿠키 데이터는 다루기 까다롭다.

   ```

   // 쿠키 헤더 예시
   Cookie: name=value; name2=value2; name3=value3

   ```

   이런 문자열에서 특정 쿠키 값을 추출하려면 직접 문자열 처리를 해야한다.

4. Cookie-Parser의 장점
5. 간편한 접근 : 요청 객체(`req.cookies`)를 통해 모든 쿠키에 바로 접근 가능
6. 자동 파싱 : 쿠키 문자열을 JavaScript 객체로 자동 변환
7. 서명된 쿠키 지원 : 보안이 강화된 서명 쿠키(Signed Cookies) 생성 및 검증 가능
8. 옵션 설정 용이 : 쿠키 생성 시 만료 시간, 경로, 도메인 등의 옵션 쉽게 설정

9. Cookie-Parser 기본 사용법
10. 미들웨어 설정

    ```

    const express = require('express');
    const cookieParser = require('cookie-parser');

    const app = express();

    // 기본 설정으로 Cookie-Parser 사용
    app.use(cookieParser());

    // 암호화된 쿠키를 위한 비밀키 설정// app.use(cookieParser('your-secret-key'));// 라우트 및 서버 설정...
    app.listen(3000);

    ```

11. 쿠키 읽기

    ```

    app.get('/read-cookie', (req, res) => {
      // 쿠키 값에 접근하기
      const username = req.cookies.username;

      if (username) {
        res.send(`안녕하세요, ${username}님!`);
      } else {
        res.send('로그인 정보가 없습니다.');
      }
    });

    ```

12. 쿠키 설정하기

    ```

    app.get('/set-cookie', (req, res) => {
      // 기본 쿠키 설정
      res.cookie('username', 'john_doe');

      // 옵션이 있는 쿠키 설정
      res.cookie('preferences', 'dark-mode', {
        maxAge: 86400000,// 유효시간: 24시간 (밀리초 단위)
        httpOnly: true,// JavaScript에서 접근 불가능 (XSS 방어)
        secure: true,// HTTPS 연결에서만 전송
        sameSite: 'strict'// CSRF 공격 방어
      });

      res.send('쿠키가 설정되었습니다!');
    });

    ```

13. 쿠키 삭제하기

    ```

    app.get('/logout', (req, res) => {
    // 쿠키 삭제
      res.clearCookie('username');

      res.send('로그아웃 되었습니다.');
    });

    ```

14. 서명된 쿠키 사용하기

    ```

    // 미들웨어 설정 (비밀키 사용)
    app.use(cookieParser('my-secret-key'));

    // 서명된 쿠키 설정
    app.get('/set-signed-cookie', (req, res) => {
      res.cookie('user_id', '12345', { signed: true });
      res.send('서명된 쿠키가 설정되었습니다.');
    });

    // 서명된 쿠키 읽기
    app.get('/read-signed-cookie', (req, res) => {
    // 서명된 쿠키는 req.signedCookies 객체에서 접근
      const userId = req.signedCookies.user_id;

      if (userId) {
        res.send(`인증된 사용자 ID: ${userId}`);
      } else {
        res.send('인증된 사용자 정보가 없습니다.');
      }
    });

    ```

15. 쿠키 관련 보안 고려사항

16. XSS(Cross-Site-Scripting) 공격 방지

    - `httpOnly` 옵션을 사용하여 JavaScript에서 쿠키 접근 차단

      ```

      res.cookie('token', 'value', { httpOnly: true });

      ```

17. CSRF(Cross-Site Request Forgery) 공격 방지

    - `sameSite` 옵션을 사용하여 외부 사이트에서의 쿠키 전송 제한

      ```

      res.cookie('token', 'value', { sameSite: 'strict' });

      ```

18. 정보 유출 방지

    - 민감한 정보는 암호화하거나 서명된 쿠키 사용

      ```

      res.cookie('user_id', id, { signed: true });

      ```
