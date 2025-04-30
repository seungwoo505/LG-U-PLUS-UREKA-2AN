# MongoDB

문서 기반(Document-Based) NoSQL 데이터베이스이다.
관계형 데이터베이스(RDBMS)와 달리 테이블과 행 대신 컬렉션과 문서 형태로 데이터를 저장

## MongoDB의 주요 특징

- 문서 지향적 : JSON과 유사한BSON(Binary JSON) 형식으로 데이터 저장
- 스키마 자유 : 미리 정의된 스키마 없이 문서마다 다른 구조 가능
- 분산 확장성 : 수평적 확장(Sharding)을 통해 대용량 데이터 처리
- 유연한 쿼리 : 강력한 쿼리 기능과 인덱싱 지원
- 높은 가용성 : 복제(Replication)을 통한 데이터 백업 및 고가용성

# JavaScript 정규표현식

문자열에서 특정 패턴을 찾거나 검증, 대체하는 강력한 도구이다.
JavaScript에서 정규표현식을 마스터하면 문자열처리 작업을 더 효율적으로 수행할 수 있다.

1. 정규표현식 기초

   ## 정규표현식 생성 방법

   - JavaScript에서는 두가지 방법으로 정규표현식을 생성할 수 있다.

   ```

   // 리터럴 방식
   const regex1 = /pattern/flags;

   // 생성자 방식
   const regex2 = new RegExp('pattern', 'flags');

   ```

   ## 기본 사용법

   ```

   // 정규식 테스트 (true/false 반환)
    const isMatch = /hello/.test('hello world');  // true

    // 첫 번째 일치 항목 찾기
    const match = 'hello world'.match(/hello/);  // ["hello", index: 0, input: "hello world", groups: undefined]

    // 모든 일치 항목 찾기
    const allMatches = 'hi hello hi hello'.match(/hello/g);  // ["hello", "hello"]

    // 일치 항목 대체하기
    const replaced = 'hello world'.replace(/hello/, 'hi');  // "hi world"


   ```

2. 메타 문자와 특수 문자

|메타문자|설명|
|`.`|줄바꿈 문자를 제외한 모든 단일 문자와 일치|
|`^`|문자열의 시작을 나타낸다|
|`$`|문자열의 끝을 나타낸다|
|`*`|앞의 표현식이 0회 이상 반복|
|`+`|앞의 표현식이 1회 이상 반복|
|`?`|앞의 표현식이 0회 또는 1회 등장|
|`\`|다음 문자를 이스케이프|
|` ` `|`|
|`()`|그룹화 및 캡처|
|`[]`|문자 클래스 (괄호 안의 문자 중 하나와 일치)|
|`{}`|수량자(앞 표현식의 반복 횟수 지정)|
