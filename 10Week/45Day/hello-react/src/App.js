import './App.css';

function App() {
  const name = "리액트";
  const noName = undefined;

  const style = {
    backgroundColor : "black",
    color : "aqua"
  };

  return (
    // 여기까지 // 사용 가능 <> 안에서 부터 {}를 사용해야 주석 사용 가능
    <div className="App">
      {/* cmd + / -> 주석으로 만들어준다. */}
      {/* 요소 여러 개가 부모 요소 안에 감싸져있어야한다. */}
      <h1>리액트입니다.</h1>
      <h2>안녕 리액트</h2>

      {
      /* 
        자바스크립트 표현
        자바스크립트의 문법 또는 변수를 사용하기 위해 {}를 사용해야한다.
      */
      }
      <h1>{name} 안녕</h1>

      {/* if 문 대신 조건부 연산자 */}
      {name === "리액트" ? (
        <h1>리액트 맞습니다.</h1> 
      )
        :
      (
        <h1>리액트가 아닙니다.</h1>
      )}

      {/* AND 연산자를 사용한 조건부 렌더링 */}
      {name === "리액트" ? (
       <h1>리액트가 맞습니다</h1> 
      ) : null
      }

      {/* undifined를 렌더링하지 않기 */}
      {noName || "리액트 undefined"}

      {/* 이미 선언하여 스타일 넣는 방법 */}
      <div style = {style}>
        {name}
      </div>

      {/* 인라인 스타일 - 미리 선언하지않고 쓰는 방법 */}
      <div
        style = {{
          backgroundColor : "black",
          color : "aqua"
        }}
      >
        {name}
      </div>

      {/* 위에 인라인 스타일은 권장하지않음 class나 id를 선언하여 스타일 지정 */}
      <div className="react">
        {name}
      </div>

      {/* 셀프 클로징 태그 */}
      <input/>
    </div>
  );
}

export default App;
