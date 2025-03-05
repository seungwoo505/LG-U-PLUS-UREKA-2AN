26일차에 작성했던 코드 이어 작성

그리고 따로 리포지토리를 만들어서 그 곳에 배치를 하였다.

만약 보고 싶다면 [cafe](https://github.com/seungwoo505/cafe)를 보면된다.

DB의 아이디 비번이나 포트 등등의 보안 상의 문제가 발생할거같다면

.gitignore 를 통해 commit 를 하지못하게 막으면된다.

cafe를 예시로 하자면

cafe의 경우 DB의 아이디 비번을 src/main/resources/config/secu.properties

안에 저장을 했다.

```

**/config/*.properties

```

깃허브에 올리면서 공유를 해야하는데 다른 사람들도 볼 수 있어 보안이 걱정된다면

.gitignore 안에 이 문자를 추가하면 된다

