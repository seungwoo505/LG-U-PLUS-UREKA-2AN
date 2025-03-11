Spring(back 서버)와 프론트 서버가 분리되어있을 때

로그인 기능을 구현하고자한다.

그러면 Spring에서 HttpServletRequest를 통해

http 통신 중 해더 부분에 자동으로 session을 함께 보낸다.

그러면 프론트(웹 브라우저)에서 세션과 Spring 서버에서의 세션이 동일하다는 것을 확인할 수 있다.

그리고나서 프론트에서 로그인이 유지된 상태에서 로그인이 살아있냐고 백엔드 서버에 요청을 하면

HttpServletRequest에서 해더 부분에 Session이 존재하지않다고(null) 나온다.

그 이유는 프론트에서 해더부분에 Session을 넣어 보내지않았기 때문이다.

[26일차](https://github.com/seungwoo505/LG-U-PLUS-UREKA-2AN/tree/main/6Week/26Day/project1)와
 [cafe](https://github.com/seungwoo505/cafe)를 보면 알 수 있듯이 백엔드 서버에서는 CORS를 처리했으나 프론트에서는 CORS처리를 하지않았다.

그렇기에 백엔드에서는 처리를 해주어 정상적으로 프론트에 넘겨 Session을 확인할 수 있었으나
프론트에서는 처리하지않아 백엔드로 넘길 때 해더에 Session이 없어 null로 나온다.

이것을 해결할 수 있는 방법이 2가지가 존재한다.

1. 하나로 통합하기
    - 백엔드와 프론트엔드를 하나로 통합을 하는 것이다.
    - 이러면 CORS 정책에 위배될 일이 없기 때문에 양쪽에서 정상적으로 처리가 될 것이다.
    - [통합된 서버](https://github.com/seungwoo505/cafe/tree/feat/login)에서 자세히 확인할 수 있다.
    - 쉽게 말하자면 프론트에 있는 것을 백서버에 함께 등록하면되는 것이다.

2. JWT와 같이 토큰으로 관리하기
    - 프론트에서 백엔드로 보내는게 정책 상 금지되어있어 직접 담아 보내야한다.
    - 그래서 토큰을 따로 만들어 관리를 해야한다.
    - 자세한 것은 [프론트 처리](https://github.com/seungwoo505/project2)에서 확인할 수 있다.
