import React from 'react';

const Note = () => {
    return (
        <div>
            {/*
                var
                - 변수 선언
                - 단점 : 동일한 변수 명을 중복으로 선언 가능( => 프로그램에 버그 가능성 다분)
                        상수 선언 불가
                
                let
                - es6에 추가된 변수 선언
                - 동일한 이름으로 중복해서 선언 불가
                - 동적인 값을 변수로 선언할 때 쓰임

                const
                - es6에 추가된 변수 선언
                - 값을 변경할 수 없다.(상수)
                - 동일한 이름으로 중복해서 선언 불가

                기존함수
                - 인자에 값이 전달되지않으면 error는 발생되지않으나 인자의 값은 undefined

                default parameter
                - 함수의 인자 값을 기본 값으로 설정합니다.
                  인자가 전달되지않으면 기본 값을 사용한다.
                - 선언 방식
                    function 함수명(인자 = 값)

                react 객체 생성 함수
                React Dom에 렌더링할 ReactDOM 객체를 생성하는 함수
                ReactDOM.createRoot(root)

                <StrictMode>를 통해 개발 중에 컴포넌트에서 발생하는 버그를 빠르게 찾을 수 있다.

                JSX javaScript를 확장한 문법으로 react에서 "엘리먼트(element)"를 생성한다.

                형식) <태그 명>내용 {자바스크립트} </태그 명>
                {} : 자바스크립트 표현 식(변수, 함수 등)을 넣는다.

                JSX 표현식이 정규 JavaScript 함수 호출이 되고 JavaScrpit객체로 인식된다.
                즉, JSX를 if 구문 및 for loop 안에 사용하고,
                변수에 할당하고, 인자로서 받아들이고, 함수로부터 반환할 수 있다.
             */}
        </div>
    );
};

export default Note;