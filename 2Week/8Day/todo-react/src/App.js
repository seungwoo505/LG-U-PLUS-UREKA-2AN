import React, { useState } from 'react'; // React와 useState를 임포트합니다.
import './App.css'

function App() {
  const [todos, setTodos] = useState([]); // 할 일 목록을 관리하기 위한 상태를 생성합니다.
  const [inputValue, setInputValue] = useState(''); // 입력값을 관리하기 위한 상태를 생성합니다.

  // 할 일을 추가하는 함수
  const addTodo = () => {
    if (inputValue) { // 입력값이 비어있지 않으면
      setTodos([...todos, inputValue]); // 기존 할 일 목록에 새로운 할 일을 추가합니다.
      setInputValue(''); // 입력값 초기화
    }
  };

  // 할 일을 삭제하는 함수
  const deleteTodo = (index) => {
    const newTodos = todos.filter((_, i) => i !== index); // 선택한 인덱스를 제외한 새로운 배열 생성
    setTodos(newTodos); // 상태 업데이트
  };

  return (
    <div>
      <h1>Todo List</h1> {/* 제목을 표시합니다. */}
      <input
        type="text"
        value={inputValue} // 입력값 상태와 연결
        onChange={(e) => setInputValue(e.target.value)} // 입력값이 변경될 때 상태 업데이트
        placeholder="할 일을 입력하세요" // 입력 필드에 안내 문구
      />
      <button onClick={addTodo}>추가</button> {/* 버튼 클릭 시 addTodo 함수 호출 */}

      <ul>
        {todos.map((todo, index) => ( // 할 일 목록을 순회하여 리스트를 생성
          <li key={index}>
            {todo}
            <button onClick={() => deleteTodo(index)}>삭제</button> {/* 삭제 버튼 클릭 시 해당 할 일 삭제 */}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App; // App 컴포넌트를 내보냅니다.
