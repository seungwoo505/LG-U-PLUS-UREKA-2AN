import React from 'react';
//import propTypes from 'prop-types';

//props는 properties의 약자이다. 컴포넌트 속성을 설정할 때 사용하는 요소
//const MyComponent = (props) => {
    //const {name, children} = props;
const MyComponent = ({name = "리액트", children}) => {
    return (
        <div>
            <h1>나의 새롭고 멋진 {name} 컴퍼넌트</h1>
            <h2>children 값 : {children}</h2>
        </div>
    );
};

// 교재의 예전 방식의 defaultProps는 함수방식에서 더 이상 쓰이지 않음. (지원 X)

// <div> 나의 멋지고 새로운 {props.name || "하이"}</div> 방법 1
// const MyComponent = ({name = "하이", children}) => 비구조화 할당 방법

/*
MyComponent.defaultProps = {
    name : "기본 이름"
};
*/

// 3년 전에 업데이트 이후 업데이트가 없어서 최신 버전은 지원하지않음
// 이유 : TypeScript 가 있어 그 것을 이용을 대부분 하기 때문에 라이브러리 이용할 이유 없음.
/*
MyComponent.propTypes = {
    name : propTypes.string
};
*/

export default MyComponent;