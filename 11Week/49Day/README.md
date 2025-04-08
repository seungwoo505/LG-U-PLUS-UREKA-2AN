# React 복습

<details>
<summary>

## jsx와 js는 왜 구별해서 사용하는가.

</summary>

1. 명확한 의도 전달

   - .jsx 파일은 React 컴포넌트와 UI 요소 포함
   - .js 파일은 일반 JS 로직, 유틸리티 함수, 서비스 등을 담당

2. 도구 및 편집기 최적화

   - 편집기가 확장자(파일 유형)에 맞춰 문법 강조와 자동 완성 기능을 제공
   - .jsx 파일에는 React 관련 스니펫과 자동 완성이 활성화된다.

3. 빌드 시스템 최적화

   - 웹팩이나 Babel 같은 빌드 도구가 파일 유형에 따라 다른 처리를 할 수 있다.
   - jsx 파일만 React 변환 과정을 거치도록 설정할 수 있어 빌드 성능이 향상된다.

4. 코드베이스 구성의 명확성

   - 팀원들이 파일의 역할을 즉시 이해할 수 있다.
   - 대규모 프로젝트에서 파일의 목적을 쉽게 파악할 수 있다.

5. 관심사 분리
   - UI 로직(jsx)과 비즈니스 로직(js)을 분리하여 코드 유지보수성 향상
   - 각 파일이 단일 책임을 갖도록 유도

- React에서 두 확장자 모두 사용이 가능하며 기술적으로는 동일하게 작동을 한다.
  다만, 대규모로 갈 수록 공유를 해야하는 대상이 많고 봐야할 대상이 많아지므로
  구분이 되어있지않다면 파일을 일일이 들어가 확인을 해야하는 불편함이 있기 때문에 구분을 하는 것이
  관리나 일의 능률에서 훨씬 뛰어나다.

</details>

<details>
<summary>

## jsx문법 요약

</summary>

jsx는 javaScript XML의 약자로, React에서 UI를 구성하기 위해 사용하는 문법.

HTML과 유사하게 생겼지만 javaScript의 강력한 기능을 함께 사용할 수 있다.

```

// JSX는 HTML처럼 태그를 사용
const element = <h1>안녕하세요, React!</h1>;

/* ---------------------------------------------- */

// 중괄호 {} 를 사용하여 JavaScript 표현식을 넣을 수 있다.
const name = '홍길동';
const element = <h1>안녕하세요, {name}님!</h1>;

/* ---------------------------------------------- */

/**

HTML 속성과 유사하게 사용하지만 camelCas로 작성.

*/

// className (class 대신)
const element = <div className="container">내용</div>;

// style 객체로 지정
const style = { color: 'blue', fontSize: '16px' };
const element = <p style={style}>스타일 적용 텍스트</p>;

/* ---------------------------------------------- */

// 여러 자식 요소를 포함할 수 있다.
const element = (
  <div>
    <h1>제목</h1>
    <p>내용 설명</p>
  </div>
);

/* ---------------------------------------------- */

/*
모든 태그는 닫아야한다.
자식이 없는 태그는 self-closing 태그를 사용
(
    jsx는 기본적으로 js의 문법 규칙을 따르기 때문에
    HTML처럼 느슨하게 처리하지않고 엄격하게 태그를 닫아야한다.
)
*/
const input = <input type="text" />;
const img = <img src="image.jpg" alt="이미지" />;

/* ---------------------------------------------- */

/*
jsx 내에서 조건에 따라 다른 내용을 렌더링할 수 있다.
*/
// 삼항 연산자 사용
const element = <div>{isLoggedIn ? <UserGreeting /> : <GuestGreeting />}</div>;

// AND 연산자 사용 (조건이 참일 때만 렌더링)
const element = <div>{unreadMessages.length > 0 && <MessageAlert />}</div>;

// 배열을 map 함수로 순회하여 리스트를 렌더링할 수 있다.
const numbers = [1, 2, 3, 4, 5];
const listItems = (
  <ul>
    {numbers.map((number) => (
      <li key={number}>{number}</li>
    ))}
  </ul>
);

/* ---------------------------------------------- */

/*
불필요한 div 없이 여러 요소를 그룹화할 수 있다.
아래와 같이 사용을 할 경우
기존처럼
<div>
</div>
로 감싸지는 것이 아닌
상위 태그에 감싸지게된다.

ex) App.jsx에서 React.Fragment나 <>로 감싼다면
    최상위인 id가 root를 갖는 태그 아래에 위치하게 될것이다.
    (div로 감싸는 것이였으면 root 아래에 div가 있고 그 아래에 위치하게 된다.)
*/
// <React.Fragment> 사용
const element = (
  <React.Fragment>
    <h1>제목</h1>
    <p>내용</p>
  </React.Fragment>
);

// 축약형 사용
const element = (
  <>
    <h1>제목</h1>
    <p>내용</p>
  </>
);

/* ---------------------------------------------- */

/*
이벤트 핸들러는 camelCase로 작성합니다.
function 또는 Arrow 함수로 작성 가능
*/
function handleClick() {
  alert('버튼이 클릭되었습니다!');
}

const button = <button onClick={handleClick}>클릭하세요</button>;


```

- JSX는 React의 핵심 문법으로,
  HTML과 javaScript를 자연스럽게 결합하여 UI 작성을 직관적으로 만들어준다.

</details>

<details>
<summary>

## JavaScript 표현식

</summary>

- javaScript 표현식은 값을 만들어내는 코드 조각이다.
  표현식은 계산되어 하나의 값을 반환한다.

```

// 변수 참조
let name = '홍길동';
console.log(name); // 변수 name은 표현식

//산술 표현식
let sum = 10 + 5; // 10 + 5는 15라는 값을 만드는 표현식
let product = 4 * 3;

//문자열 표현식
let greeting = 'Hello ' + 'World'; // 문자열 연결
let name = `User: ${firstName}`; // 템플릿 리터럴

//논리 표현식
let isValid = age > 18 && hasPermission; // 논리 연산
let canAccess = isAdmin || isManager; // true/false 값 생성

//함수 호출
Math.random(); // 함수 호출 자체가 표현식
console.log('Hello'); // 표현식

//객체 / 배열 리터널
const person = { name: '김철수', age: 30 }; // 객체 리터럴
const numbers = [1, 2, 3, 4]; // 배열 리터럴

//삼항 연산자
let status = age >= 18 ? '성인' : '미성년자';

//화살표 함수
const double = x => x * 2;

/*
JSX에서의 JavaScript 표현식
- JSX에서는 중괄호 {} 를 사용하여 JavaScript 표현식을 삽입할 수 있다.
*/
const name = '홍길동';
const age = 25;
const isAdmin = true;

// JSX 내 표현식 사용 예시
const element = (
  <div>
    <h1>{name}의 프로필</h1>
    <p>나이: {age}세</p>
    <p>직업: {age >= 18 ? '개발자' : '학생'}</p>
    <p>{isAdmin && '관리자 권한이 있습니다'}</p>
    <p>1년 후 나이: {age + 1}세</p>
    <p>랜덤 ID: {Math.floor(Math.random() * 100)}</p>
  </div>
);

```

- JSX 중괄호 안에는 하나의 값으로 평가되는 모든 JavaScript 표현식을 넣을 수 있다.
  단, if문이나 for 루프와 같은 문장은 표현식을 넣을 수 없다.
  (그래서 삼항연산식이나 map, forEach 와 같이 대신 할 수 있는 것을 이용하여 사용)

</details>

<details>
<summary>

## css 적용 방법

</summary>

<details>
<summary>
전역 css 적용방법
</summary>

```

// main.js 또는 App.js에서
import './styles.css';

function App() {
    return <div className="app">전역 스타일 적용됨</div>;
}

```

</details>

<details>
<summary>
컴포넌트에만 css 적용방법
</summary>

<details>
<summary>
css Modules 사용
</summary>

파일명을 [컴포넌트 이름].module.css 형식으로 저장하고 사용

```

/* Button.module.css */
.button {
    padding: 8px 16px;
    background-color: blue;
    color: white;
}

```

```

// Button.jsx
import styles from './Button.module.css';

function Button() {
    return <button className={styles.button}>클릭</button>;
}

```

</details>

<details>
<summary>
Styled-Components 사용
</summary>

CSS-in-JS 방식으로, 컴포넌트와 스타일을 한 파일에 작성

```

import styled from 'styled-components';

const StyledButton = styled.button`
    padding: 8px 16px;
    background-color: blue;
    color: white;
    &:hover {
        background-color: darkblue;
    }
`;

function Button() {
    return <StyledButton>클릭</StyledButton>;
}

```

</details>

<details>
<summary>
어떤 방법을 선택해야한가?
</summary>

- 전역 CSS : 리셋, 기본 포트, 색상 변수 등 애플리케이션 전체에 적용할 스타일
- CSS Modules : 컴포넌트 별 스타일링이 필요하지만 별도 라이브러리 없이 사용하고 싶을 때
- Styled-Components : 동적 스타일링이 많거나 컴포넌트와 스타일을 밀접하게 연결하고 싶을 때

</details>

</details>

<details>
<summary>
style 속성을 요소에 직접 적용하는 인라인 스타일 적용하기
</summary>

```

// 기본 스타일
function MyComponent() {
    return (
        <div style={{ color: 'blue', fontSize: '16px', marginTop: '20px' }}>
        스타일이 적용된 텍스트입니다
        </div>
    );
}

// 조건부 스타일
/*
활용 방법 :
    예를 들어 숨겨진 블럭이 클릭을 하면 나타나게 해야할 경우
    평상 시엔 false로 두다가 버튼 클릭 시 true로 바뀌어 표시가 되게 하는 등으로 활용이 가능할거같다.
*/
function Button({ isPrimary }) {
    // 변수로 스타일 지정
    const buttonStyle = {
        padding: '10px 15px',
        border: 'none',
        borderRadius: '4px',
        cursor: 'pointer',
        backgroundColor: isPrimary ? '#007bff' : '#6c757d',
        color: 'white'
    };

    return (
        <button style={buttonStyle}>
        {isPrimary ? '확인' : '취소'}
        </button>
    );
}

// 스타일 병합 -> 딱히 쓸일은 많아보이지는 않지만 JSON 형식이다보니 합하는 것이 가능
// 활용 방법은 아마 같은 스타일을 적용해야하지만 일부가 다를 경우 두개 만들고 하나는 합하는 형식? <- 이런 상황이 많지는않을거같다...
function Card({ customStyle }) {
    const baseStyle = {
        padding: '20px',
        margin: '10px',
        borderRadius: '5px',
        boxShadow: '0 2px 5px rgba(0,0,0,0.1)'
    };

    // 기본 스타일과 사용자 정의 스타일 병합
    const combinedStyle = { ...baseStyle, ...customStyle };

    return (
        <div style={combinedStyle}>
        <h2>카드 제목</h2>
        <p>카드 내용</p>
        </div>
    );
}

// 동적 스타일 계산
// 활용 방법 : 지속적으로 바뀌어야하는 경우(반응형)에 변수를 스타일에 넣어 즉각적으로 변화되게 한다. --> 즉 반응형을 위해
function ProgressBar({ percent }) {
    const containerStyle = {
        height: '20px',
        width: '100%',
        backgroundColor: '#e0e0e0',
        borderRadius: '10px',
        overflow: 'hidden'
    };

    const fillerStyle = {
        height: '100%',
        width: `${percent}%`,
        backgroundColor: percent < 30 ? 'red' : percent < 70 ? 'yellow' : 'green',
        transition: 'width 0.5s ease-in-out'
    };

    return (
        <div style={containerStyle}>
        <div style={fillerStyle}></div>
        </div>
    );
}

```

React에서 인라인 스타일을 사용하면 스타일링이 간편하지만, 대규모에서는 CSS Modules나 Styled-Components와 같은 접근 방식이
유지보수 측면에서 더 좋을 수 있다.

</details>

</details>

<details>
<summary>

## component 생성 방법 및 호출 방법

</summary>

```

// snippets : rafce

import React from 'react'

const NewComponenet = () => {
  return (
    <div>NewComponenet</div>
  )
}

export default NewComponenet

```

</details>

<details>
<summary>

## useState()

</summary>

useState는 React의 가장 기본적인 Hook으로, 함수형 컴포넌트에서 상태(State)를 관리할 수 있게 한다.

```

import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>현재 카운트: {count}</p>
      <button onClick={() => setCount(count + 1)}>증가</button>
    </div>
  );
}

```

1. useState(0)은 초기값이 0인 상태 변수 생성
2. count는 현재 상태 값을 저장
3. setState는 count 상태를 업데이트하는 함수

useState의 주요 특징 - 상태 변경 시 자동 리렌더링 : setCount룰 호출하면 컴포넌트가 다시 렌더링됩니다. - 이전 상태 참조 : 이전 상태를 기반으로 업데이트할 때는 함수 형태를 사용합니다

```
setCount(prevCount => prevCount + 1);

```

- 객체 상태 관리 : 객체 형태의 상태를 관리할 때는 전체 객체를 업데이트를 해야한다.

```

const [user, setUser] = useState({ name: '홍길동', age: 30 });setUser({ ...user, age: 31 }); // 기존 객체 속성을 유지하면서 age만 변경

```

useState는 컴포넌트가 사용자 입력, 데이터 로딩, UI 상호작용과 같은 변화에 반응할 수 있게 해주는 핵심 기능

</details>

<details>
<summary>

## array, object state 변경 시 주의 사항

</summary>

React에서 배열과 객체 상태를 변경할 때는 불변성을 지켜야한다.
즉, 원본을 직접 수정하지 않고 새로운 복사본을 만들어 변경해야한다.

1. 배열(Array) 상태 변경하기

```

import React, { useState } from 'react';

function TodoList() {
const [todos, setTodos] = useState(['React 공부하기', '장보기']);

// 1. 배열에 새 항목 추가하기
const addTodo = (newTodo) => {
setTodos([...todos, newTodo]);
// 스프레드 연산자(...)로 기존 배열을 복사하고 새 항목 추가
};

// 2. 배열에서 항목 제거하기
const removeTodo = (index) => {
setTodos(todos.filter((\_, i) => i !== index));
// filter로 해당 인덱스를 제외한 새 배열 생성
};

// 3. 배열의 특정 항목 수정하기
const updateTodo = (index, newText) => {
setTodos(todos.map((todo, i) =>
i === index ? newText : todo
));
// map으로 특정 인덱스의 항목만 새 값으로 변경
};

return (

<div>{/_ UI 코드 _/}</div>

);
}

```

2. 객체(Object) 상태 변경하기

```

import React, { useState } from 'react';

function UserProfile() {
const [user, setUser] = useState({
name: '홍길동',
age: 30,
email: 'hong@example.com'
});

// 1. 객체의 특정 속성 변경하기
const updateEmail = (newEmail) => {
setUser({
...user, // 기존 객체의 모든 속성을 복사
email: newEmail // 변경할 속성만 덮어쓰기
});
};

// 2. 중첩된 객체 속성 변경하기
const [product, setProduct] = useState({
name: '노트북',
specs: {
cpu: 'i7',
ram: '16GB',
storage: '512GB'
}
});

const upgradeRam = (newRam) => {
setProduct({
...product,
specs: {
...product.specs, // 중첩 객체도 복사
ram: newRam // 변경할 속성만 덮어쓰기
}
});
};

return (

<div>{/_ UI 코드 _/}</div>
);
}

```

3. 배열 속 객체 변경하기

```

import React, { useState } from 'react';

function StudentList() {
const [students, setStudents] = useState([
{ id: 1, name: '김철수', grade: 'A' },
{ id: 2, name: '이영희', grade: 'B' },
{ id: 3, name: '박민수', grade: 'C' }
]);

// 특정 학생의 성적 변경하기
const updateGrade = (id, newGrade) => {
setStudents(
students.map(student =>
student.id === id
? { ...student, grade: newGrade }
: student
)
);
};

return (

<div>{/_ UI 코드 _/}</div>
);
}

```

</details>

<details>
<summary>

## Props 전송

</summary>

Props 기본 개념

Props는 부모 컴포넌트에서 자식 컴포넌트로 데이터를 전달하는 방법.

마치 함수의 인자처럼 작동하며 읽기 전용이다.

기본 Props 전달 예시

```

// 부모 컴포넌트
function ParentComponent() {
const userName = "홍길동";
const userAge = 30;

return (
<ChildComponent name={userName} age={userAge} />
);
}

// 자식 컴포넌트
function ChildComponent(props) {
return (

<div>
<h2>이름: {props.name}</h2>
<p>나이: {props.age}세</p>
</div>
);
}

```

Props 전송 패턴

```

// 1. 구조 분해 할당으로 Props 받기

// 더 깔끔한 구조 분해 할당 방식
function ProfileCard({ name, age, isVerified = false }) {
return (

<div className="profile-card">
<h2>{name} {isVerified && '✓'}</h2>
<p>나이: {age}세</p>
</div>
);
}

// 2. Children Props 활용하기

function Card({ title, children }) {
return (

<div className="card">
<h2 className="card-title">{title}</h2>
<div className="card-content">
{children}
</div>
</div>
);
}

function App() {
return (
<Card title="회원 정보">

<p>이 카드에는 어떤 내용이든 넣을 수 있습니다.</p>
<button>수정하기</button>
</Card>
);
}

// 3. 객체 형태로 Props 전달하기

function UserProfile() {
const userDetails = {
name: "김철수",
age: 28,
email: "kim@example.com",
role: "개발자"
};

return <ProfileDetails {...userDetails} />;
}

function ProfileDetails({ name, age, email, role }) {
return (

<div className="profile">
<h2>{name}</h2>
<ul>
<li>나이: {age}</li>
<li>이메일: {email}</li>
<li>직업: {role}</li>
</ul>
</div>
);
}

// 4. 컴포넌트 합성으로 Props 드릴링 방지
// -> 자식 컴포넌트를 Props로 전달하여 계층 구조를 평면화할 수 있다.

function App() {
const data = "중요한 데이터";

// E를 직접 생성하여 A에 전달
const componentE = <ComponentE data={data} />;

return <ComponentA componentE={componentE} />;
}

function ComponentA({ componentE }) {
return (

<div>
<h1>컴포넌트 A</h1>
{componentE} {/_ E를 직접 렌더링 _/}
</div>
);
}

function ComponentE({ data }) {
return <div>{data}</div>;
}

```

<details>
<summary>
Props 드릴링이란?
</summary>
Props 드릴링은 상위 컴포넌트에서 깊이 중첩된 하위 컴포넌트로 데이터를 전달하기 위해 중간에 있는 여러 컴포넌트들을 거쳐야 하는 상황

쉽게 말해서, A → B → C → D → E 구조의 컴포넌트에서 A의 데이터를 E에서 사용하려면, B, C, D를 통과해야 한다.

```

function ComponentA() {
const data = "중요한 데이터";
return <ComponentB data={data} />;
}

function ComponentB({ data }) {
// B는 data를 실제로 사용하지 않지만 C에 전달하기 위해 받아야 함
return <ComponentC data={data} />;
}

function ComponentC({ data }) {
// C도 data를 사용하지 않지만 전달만 함
return <ComponentD data={data} />;
}

function ComponentD({ data }) {
// D도 마찬가지로 전달만 함
return <ComponentE data={data} />;
}

function ComponentE({ data }) {
// E가 실제로 data를 사용함
return <div>{data}</div>;
}

```

Props 드릴링 문제점 - 드릴링 같은 경우 코드가 복잡해지며(중간 컴포넌트는 필요 없는데 거쳐가야하는 이유로 받고 넘겨야하는 문제) - 데이터 흐름을 찾아야하기 때문에 유지보수가 어렵다. - 또한 Props가 변경될 경우 A, E만 리렌더링이 되어야하는데 B, C, D도 같이 리렌더링이 된다. - 그리고 구조 변경이 어려워진다.(바뀌면 다 같이 변경이 되야하기 때문에 조금만 바뀌어도 전부 바꿔야하기에 일이 커진다.)

Props 드릴링 방지법 1. Context API 활용 - 중간 컴포넌트를 거치지않고 데이터 공유 가능 2. 상태 관리 라이브러리 활용 - Redux, Zustand, Recoil, Jotai 등의 상태 관리 라이브러리를 사용하여 전역 상태 관리 3. 컴포넌트 합성 사용 - 자식 컴포넌트를 Props로 전달하여 계층 구조 평면화

</details>

함수 Props 전달하기

```

function TodoApp() {
const [todos, setTodos] = useState(["React 공부하기", "자바스크립트 공부하기"]);

const addTodo = (newTodo) => {
setTodos([...todos, newTodo]);
};

return (

<div>
<h1>할 일 목록</h1>
<TodoList items={todos} />
<AddTodoForm onAddTodo={addTodo} />
</div>
);
}

function AddTodoForm({ onAddTodo }) {
const [input, setInput] = useState("");

const handleSubmit = (e) => {
e.preventDefault();
if (input.trim()) {
onAddTodo(input);
setInput("");
}
};

return (

<form onSubmit={handleSubmit}>
<input
value={input}
onChange={(e) => setInput(e.target.value)}
placeholder="새 할 일 추가"
/>
<button type="submit">추가</button>
</form>
);
}

```

컴포넌트 간의 효율적인 통신을 위해 적절한 Props 전송 방식을 선택하는 것이 좋다.

데이터 흐름이 복잡해지면 전역 상태 관리나 컨텍스트 API를 고려할 수 있다.

PS. 내가 전에 Props 드릴링 때문에 상태 관리가 어려울 것 같아 Redux를 이용했었다.

그때는 Props 드릴링이라는 단어를 몰랐었는데

저러면 관리가 많이 어려워지므로 상태 관리 라이브러리를 사용하면 관리하기 편해진다.

상세한 부분은 [해당 프로젝트](https://github.com/seungwoo505/Portfolio)에서 확인이 가능하다.

</details>

<details>
<summary>

## 배열과 함께 사용하는 고차함수

</summary>

고차함수는 다른 함수를 인자로 받거나 함수를 반환하는 함수를 말한다.

```

// 1. map() - 배열의 모든 요소를 변환하여 새 배열 반환

// 숫자 배열의 각 요소를 2배로 만들기
const numbers = [1, 2, 3, 4, 5];
const doubled = numbers.map(num => num \* 2);
console.log(doubled); // [2, 4, 6, 8, 10]

// 객체 배열에서 특정 속성만 추출하기
const users = [
{ id: 1, name: '김철수', age: 25 },
{ id: 2, name: '이영희', age: 30 },
{ id: 3, name: '박민수', age: 28 }
];
const names = users.map(user => user.name);
console.log(names); // ['김철수', '이영희', '박민수']

// 2. filter() - 조건에 맞는 요소만 포함하는 새 배열 반환

// 짝수만 필터링하기
const numbers = [1, 2, 3, 4, 5, 6];
const evens = numbers.filter(num => num % 2 === 0);
console.log(evens); // [2, 4, 6]

// 특정 나이 이상인 사용자만 필터링하기
const users = [
{ name: '김철수', age: 25 },
{ name: '이영희', age: 30 },
{ name: '박민수', age: 18 }
];
const adults = users.filter(user => user.age >= 20);
console.log(adults); // [{ name: '김철수', age: 25 }, { name: '이영희', age: 30 }]

// 3. reduce() - 배열의 요소를 하나의 값으로 줄이기

// 배열 요소의 합계 구하기
const numbers = [1, 2, 3, 4, 5];
const sum = numbers.reduce((accumulator, current) => accumulator + current, 0);
console.log(sum); // 15

// 객체 배열의 특정 속성 합계 구하기
const cart = [
{ item: '노트북', price: 1200000 },
{ item: '마우스', price: 35000 },
{ item: '키보드', price: 45000 }
];
const totalPrice = cart.reduce((total, product) => total + product.price, 0);
console.log(totalPrice); // 1280000

// 4. forEach() - 배열의 각 요소에 대해 함수 실행

// 배열의 각 요소 출력하기
const fruits = ['사과', '바나나', '오렌지'];
fruits.forEach(fruit => console.log(fruit));
// 사과
// 바나나
// 오렌지

// 배열 요소의 합계 계산하기 (부수 효과 사용)
let total = 0;
[1, 2, 3, 4].forEach(num => {
total += num;
});
console.log(total); // 10

// 5. find() - 조건을 만족하는 첫 번째 요소 반환

// 특정 ID를 가진 사용자 찾기
const users = [
{ id: 1, name: '김철수' },
{ id: 2, name: '이영희' },
{ id: 3, name: '박민수' }
];
const user = users.find(user => user.id === 2);
console.log(user); // { id: 2, name: '이영희' }

// 6. some() - 하나라도 조건을 만족하면 true 반환

// 배열에 음수가 있는지 확인
const numbers = [1, 2, 3, -1, 4];
const hasNegative = numbers.some(num => num < 0);
console.log(hasNegative); // true

// 7. every() - 모든 요소가 조건을 만족하면 true 반환

// 모든 사용자가 성인인지 확인
const users = [
{ name: '김철수', age: 25 },
{ name: '이영희', age: 30 },
{ name: '박민수', age: 18 }
];
const allAdults = users.every(user => user.age >= 20);
console.log(allAdults); // false

// 8. flatMap() - map() 후 결과를 1레벨 평탄화

// 문장을 단어 배열로 변환
const sentences = ['Hello world', 'I love JavaScript'];
const words = sentences.flatMap(sentence => sentence.split(' '));
console.log(words); // ['Hello', 'world', 'I', 'love', 'JavaScript']

// 9. sort() - 배열 요소 정렬

const numbers = [3, 1, 4, 1, 5];
numbers.sort((a, b) => a - b);
console.log(numbers); // [1, 1, 3, 4, 5]

// 객체 배열 정렬
const users = [
{ name: '김철수', age: 25 },
{ name: '이영희', age: 30 },
{ name: '박민수', age: 18 }
];
users.sort((a, b) => a.age - b.age);
console.log(users); // 나이순으로 정렬됨

// 10. findIndex() - 조건을 만족하는 첫 번째 요소의 인덱스 반환

const fruits = ['사과', '바나나', '오렌지', '포도'];
const index = fruits.findIndex(fruit => fruit === '오렌지');
console.log(index); // 2

// 11. flat() - 중첩 배열을 평탄화

const nestedArray = [1, [2, 3], [4, [5, 6]]];
const flattened = nestedArray.flat(2); // 깊이 2까지 평탄화
console.log(flattened); // [1, 2, 3, 4, 5, 6]

// 12. reduceRight() - 오른쪽에서 왼쪽으로 reduce 실행

const array = ['a', 'b', 'c', 'd'];
const result = array.reduceRight((acc, curr) => acc + curr);
console.log(result); // 'dcba'

// 13. at() - 양수 또는 음수 인덱스로 요소 접근(ES2022)

const array = [5, 12, 8, 130, 44];
console.log(array.at(2)); // 8
console.log(array.at(-1)); // 44 (마지막 요소)

// 14. Array.from() - 유사 배열 객체나 이터러블을 배열로 반환

// 문자열의 각 문자를 배열로 변환
console.log(Array.from('hello')); // ['h', 'e', 'l', 'l', 'o']

// 매핑 함수 사용 (두 번째 인자)
console.log(Array.from([1, 2, 3], x => x \* 2)); // [2, 4, 6]

// 15. Array.of() - 주어진 인자로 새 배열 생성

console.log(Array.of(1, 2, 3)); // [1, 2, 3]
console.log(Array.of('a', 'b', 'c')); // ['a', 'b', 'c']

// 16. entries(), keys(), values() - 배열의 반복자 메서드

const array = ['a', 'b', 'c'];

// entries() - [인덱스, 값] 쌍의 반복자 반환
for (const [index, element] of array.entries()) {
console.log(index, element);
}

// keys() - 인덱스의 반복자 반환
for (const index of array.keys()) {
console.log(index);
}

// values() - 값의 반복자 반환
for (const element of array.values()) {
console.log(element);
}

```

이 외에도 구현 방식에 따라 다양한 사용자 정의 고차함수를 만들 수 있다.
lodash나 Ramda와 같은 라이브러리들은 추가적인 유용한 고차함수들을 제공

</details>
