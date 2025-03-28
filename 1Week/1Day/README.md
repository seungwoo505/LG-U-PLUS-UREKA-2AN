Web의 역사

IT 기술은 개발자가 편하기위해서 발전하기 됨

1950년대 절차중심적 기법 - 순서대로 명령이 수행됨 ex) COBOL 포트란 등

1960 ~ 70년대 정보공학 기법 - 정보 제공( DB )과 사용하는( client ) 부분을 분리 ex) C, 파스칼, DBMS 등장

1980~90년대 객체지향 기법 - 변화에 유연하고 재사용성이 높은 코드를 작성 ex) C++(1970), java(1980 / 웹 중심 언어)

2000년대 CBD 기법 - 객체 단위를 넘어 컴포넌트 단위(코드만 재사용했던 것을 더 크게 확장)로 재사용성과 모듈화 극대화 ex) c#

2005년 Framework 기법 - 복잡한 작업을 효율적으로 개발하기 위해 프레임워크가 확산 ex) spring 등

2010년 Functional 기법 - ? ex) javaScrpit 등

----------------------------------------------------------------------------------------------------------------------

Framework와 Library의 차이

Library : 시멘트, 물 같은 개별 재료 / 필요한 기능을 선택하여 사용

Framework : 조립식 하우스와 같이 이미 구조가 만들어져있다. / 개발자는 정의된 틀에서 필요한 부분만 구현

-----------------------------------------------------------------------------------------------------------------------

java - 자바의 등장으로 플랫폼 마다 작성해야했던 것을 java를 통해 독립성을 가지게 됨(Write Once, Run Anywhere)
        ( 동일한 코드로 서비스를 제공할 수 있다. )

        -> 이전까지는 process 단위로 처리를 해서 비효율적으로 처리(Thread로 처리하면 되었으나 상당히 까다롭다 / 

        Java는 Thread 기반으로 동작)를 하며 os나 환경에 종속(Java는 JVM이라는 것만 있으면 어디든 동작가능)되어 각각에 맞춰서 전부 개발을 했어야했는데

        Java의 등장으로 자바만으로 모든 Web개발이 가능하게 되었다

---------------------------------------------------------------------------------------------------------------------------------------------

URL : {SCHEME}://{HOST}:{PORT}/{APP 이름 또는 경로}

SCHEME는 해당하는 프로토콜 이름 ex) http, https, ssh, smb, telnet 등등

:은 약속된 규약이며 구분자라고 보면된다.

//는 사실 필요없으나 www를 만드신 분에 의하면 멋있어보여서 사용했다고한다...( 최근 인터뷰에선 후회한다고)

HOST는 전송할 장소의 IP 주소 
-> IP 주소를 입력해야하지만 도메인을 입력해도된다. 그러면 DNS에서 도메인에서 IP로 변환을 하여 그 IP 주소로 전송을해준다.

: 역시 IP 주소 옆에 포트를 구별하기위한 규약이다.

PORT는 해당 주소를 들어가기위한 통로 번호이다.
외부에서 접속하기위해 포트포워딩 작업을 해야 외부에서 접근이 가능하다.
HTTP는 80번 포트가 HTTPS는 443 포트가 기본포트이다.
그래서 기본 포트 사용 시 생략할 수 있다.

APP 이름 또는 경로는 
해당 주소와 포트에서 제공하는 파일이나 폴더이름이다.
/를 통해 구별을 하며 기본 값이 index.html이기 때문에 파일 명이 index.html이면 생략할 수 있다.

클라이언트 요청( Request ) - 구성은 URL(전송 대상), Header(브라우저 정보, 지원 가능 형식 등등), Body(GET 방식은 비어있다 / 전송할 데이터를 담는다 예시로 로그인이라면 아이디와 비밀번호를 전송한다.)

서버 응답( Response ) - 구성은 Status(Http 상태코드(200 OK, 404 Not Found 등등)), Header(서버 정보, 메타 데이터), Body(응답 데이터(HTML, JSON))

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------