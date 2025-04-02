import React from 'react';

const Note = () => {
    return (
        <div>
            {/*
        JSX 문법 
        1. JSX - camelCase 표현식을 사용한다
        background-color --> backgroundColor

        2. 클래스 방식에서 component의 함수를 사용할 때는 this.함수명으로 사용해야 한다.

        3. JSX에서는 style을 DOM요소에 문자열 형태가 아닌 객체 형태로 {} 로 설정해야 한다.
        const style = {
        backgroundColor : "black",
        color : "pink",
        padding : 6,
        }

        4. 주석
        5. 요소 여러 개가 있을 경우 반드시 하나의 부모 요소로 감싸야 한다
        ㄴ

        component
        - 기능 단위, 재사용 단위의 객체
        - react ui component를 만드는 방법
        1. 함수형

        function 함수명(){
          return jsx; // js도 가능
        }

        2. 클래스형
        import {Component} from 'react'
        Class 컴포넌트이름 extends Component{
          render(){ //필수 함수}
          return jsx;
        
        }
        
        react에서 이미지 로딩하기
        1. public 경로에 있는 이미지
        - 경로명으로 바로 접근할 수 있다
        - webpack에 의해 번들링이 되지 않기 때문에 이미지가 많거나 프로젝트가 커질수록 관리가 어려워진다

        2. src/assets 경로에 있는 이미지
        - webpack과 같은 모듈 번들러를 사용하여 이미지를 처리할 수 있으며 이미지를 최적화하고 번들에 포함시킬 수 있다
        - 사용방법
          2.1 import를 통해 상수로 사용하기
          import 상수명 from '경로'
          <img src={상수명} alt="My image"/>
          ex)
          import myImage from "../assets/images/my-image.jpg"
          < img src={myImage} alt="My Image"

          2.2 require() 함수를 이용하여 module import하기
          require(이미지경로)

          state
          - 컴포넌트 내부에서 사용하는 상태 값
          - 변경할 때는 Component가 제공하는 setState()함수를 통해서만 변경된다.
          - setState()함수를 통해 변경됐을 때 re-rendering 된다

          Component 에서 사용하는 Variable과 Props와 State의 차이점
          Variable
          - Component 내에서 const, let을 통해 선언한 변수
          - 값이 변경되도 react가 인지하지 못하므로 re-rendering이 되지 않는다

          props
          - 부모 Component가 자식 컴포넌트를 사용할 때 값을 전달하는 수단
          - 부모 Component가 rendering될때 자식 Component도 rendering 된다
             */}
        </div>
    );
};

export default Note;