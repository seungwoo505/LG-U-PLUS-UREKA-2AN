'use client'
import Navbar from '../components/Navbar'; // 네비게이션 바 컴포넌트 가져오기
import { useState, useEffect } from 'react';
const TodoPage = () => {
    const [inputValue, setInputValue] = useState<string>(''); // 입력값을 관리하기 위한 상태를 생성합니다.
    const [todos, setTodos] = useState<string[]>([]); // 할 일 목록을 관리하기 위한 상태를 생성합니다.

    // 할 일을 추가하는 함수
    const addTodo = () => {
        if (inputValue.trim() === '') return; // 빈 항목 추가 방지
    
        const xhr = new XMLHttpRequest();
        xhr.open("GET", `http://localhost:8080/addTodo?todo=${inputValue}`, false); // false로 설정하여 동기 요청
           
        // 요청 전송
        xhr.send();
    
        // 요청이 성공적으로 완료된 후 처리
        if (xhr.status === 200) {
          console.log("Todo 항목이 성공적으로 추가되었습니다.");
          console.log("서버 응답:", xhr.responseText); // 서버에서 받은 데이터 출력
          setTodos(JSON.parse(xhr.responseText));
          setInputValue(''); // 입력 필드 초기화
        } else {
          console.error("오류 발생:", xhr.statusText);
        }
      };

    // 할 일을 삭제하는 함수
  const deleteTodo = async (index:number) => {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", `http://localhost:8080/deleteTodo?index=${index}`, false); // false로 설정하여 동기 요청
           
    // 요청 전송
    xhr.send();

    if(xhr.status === 200){
      console.log(`${index} Todo 항목이 성공적으로 삭제되었습니다.`);
      console.log("서버 응답 : ", xhr.responseText);
      setTodos(JSON.parse(xhr.responseText));
    } else {
      console.error("오류 발생 : ", xhr.statusText);
    }
  };

  useEffect(()=> {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", 'http://localhost:8080/getTodo', false); // false로 설정하여 동기 요청

    // 요청 전송
    xhr.send();

    if(xhr.status === 200){
      console.log("성공적으로 불러왔습니다.");
      console.log("서버 응답 : ", xhr.responseText);
      setTodos(JSON.parse(xhr.responseText));
    } else {
      console.error("오류 발생 : ", xhr.statusText);
    }
  }, []);

    return (
        <div>
            <Navbar /> {/* 네비게이션 바 추가 */}
            <div className="container">
                <h1>Todo List</h1> {/* 제목을 표시합니다. */}
                <div className="input-container">
                    <input
                        type="text"
                        value={inputValue} // 입력값 상태와 연결
                        onChange={(e) => setInputValue(e.target.value)} // 입력값이 변경될 때 상태 업데이트
                        placeholder="할 일을 입력하세요" // 입력 필드에 안내 문구
                    />
                    <button onClick={addTodo}>추가</button> {/* 버튼 클릭 시 addTodo 함수 호출 */}
                </div>

                <ul>
                    {todos.map((todo, index) => ( // 할 일 목록을 순회하여 리스트를 생성
                        <li key={index}>
                            {todo}
                            <button onClick={() => deleteTodo(index)}>삭제</button> {/* 삭제 버튼 클릭 시 해당 할 일 삭제 */}
                        </li>
                    ))}
                </ul>

                <style >{`
        body {
          font-family: Arial, sans-serif; /* 기본 폰트 설정 */
          background-color: #f4f4f4; /* 배경색 설정 */
          color: #333; /* 기본 글자색 설정 */
          margin: 0; /* 기본 마진 제거 */
          padding: 20px; /* 전체 패딩 설정 */
        }

        h1 {
          text-align: center; /* 제목 중앙 정렬 */
          color: #4CAF50; /* 제목 색상 설정 */
        }

        .container {
          max-width: 500px; /* 최대 너비 설정 */
          margin: 0 auto; /* 중앙 정렬 */
          background: #fff; /* 배경색 설정 */
          padding: 20px; /* 패딩 설정 */
          border-radius: 8px; /* 모서리 둥글게 */
          box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 추가 */
        }

        .input-container {
          display: flex; /* 입력 필드와 버튼을 flexbox로 설정 */
          justify-content: space-between; /* 공간을 고르게 나누기 */
          margin-bottom: 20px; /* 입력 영역과 리스트 간 간격 설정 */
        }

        input {
          flex: 1; /* 입력 필드가 가능한 최대 너비를 차지하도록 설정 */
          padding: 10px; /* 패딩 설정 */
          border: 1px solid #ccc; /* 테두리 설정 */
          border-radius: 4px; /* 모서리 둥글게 */
          margin-right: 10px; /* 입력 필드와 버튼 간격 설정 */
        }

        button {
          padding: 10px 15px; /* 버튼 패딩 설정 */
          background-color: #4CAF50; /* 버튼 배경색 설정 */
          color: white; /* 버튼 글자색 설정 */
          border: none; /* 테두리 제거 */
          border-radius: 4px; /* 모서리 둥글게 */
          cursor: pointer; /* 마우스 커서 손가락으로 변경 */
          transition: background-color 0.3s; /* 배경색 전환 효과 설정 */
        }

        button:hover {
          background-color: #45a049; /* 버튼 호버 시 배경색 변경 */
        }

        ul {
          list-style-type: none; /* 기본 리스트 스타일 제거 */
          padding: 0; /* 패딩 제거 */
        }

        li {
          display: flex; /* 리스트 아이템을 flexbox로 설정 */
          justify-content: space-between; /* 아이템 간 간격 조정 */
          align-items: center; /* 세로 중앙 정렬 */
          padding: 10px 0; /* 리스트 아이템 간 패딩 설정 */
          border-bottom: 1px solid #eee; /* 하단 테두리 추가 */
        }

        li:last-child {
          border-bottom: none; /* 마지막 아이템은 하단 테두리 제거 */
        }

        li button {
          background-color: #f44336; /* 삭제 버튼 배경색 설정 */
        }

        li button:hover {
          background-color: #d32f2f; /* 삭제 버튼 호버 시 배경색 변경 */
        }
      `}</style>
            </div>
        </div>
    );
};

export default TodoPage;
