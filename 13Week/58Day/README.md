# React Memo

setState가 변경이 되면 또는 route의 경로가 바뀌는 경우 모든 컴포넌트가 리렌더링이 된다.

route의 경우는 대부분 변경이 되기 때문에 전체 리렌더링이 되는게 당연하다고 생각한다.

하지만 1개만 변경될 경우 변경되지않은 다른 state는 변경될 이유는 없지만 전체 리렌더링이 되어버린다.

이럴 때 무의미한 리렌더링을 방지하기위해 React.memo()를 사용하면 좋다.

## React.memo()의 개념

React.memo는 리액트에서 컴포넌트 성능을 최적화하기 위한 고차 컴포넌트(High Order Component)이다.

주 목적은 불필요한 리렌더링을 방지하여 애플리케이션의 성능을 향상시키는 것

### 기본 개념

- React.memo()는 Props가 변경되지않으면 컴포넌트의 리렌더링을 방지
- 컴포넌트를 메모이제이션(memoization)하여 이전 렌더링 결과를 재사용합니다.
- 함수형 컴포넌트에서만 사용 가능(클래스 컴포넌트는 pureComponent 사용)

## React.memo() 사용방법

기본 사용법

```

import React from 'react';

const MemoizedComponent = (props) => {
    return (
        <div>
            <h2>{props.name}</h2>
            <p>{props.description}</p>
        </div>
    )
}

//React.memo()로 감싸서 메모이제이션된 컴포넌트 생성
export default MemoizedComponent;

```

커스텀 비교 함수 사용 - 필요한 경우 두 번째 인자로 커스텀 비교 함수를 전달할 수 있다.

```

import React from 'react';

function MyComponent(props){
    return <div>{props.data.text}</div>;
}

function arePropsEqual(prevProps, nextProps){
    return prevProps.data.text === nextProps.data.text;
}

export default React.memo(MyComponent, arePropsEqual);

```

### 작동방식

1. 기본적으로 props의 얕은 비교(shallow comparison)를 수행
2. 이전 props와 현 props가 동일하다면 리렌더링을 건너뛴다.
3. 커스텀 비교 함수를 제공하여 비교 로직을 직접 제어할 수 있다.

### 사용하면 좋은 경우

1. 렌더링 비용이 높은 컴포넌트

   - 복잡한 계산이나 많은 하위 요소를 렌더링하는 무거운 컴포넌트

2. 자주 리렌더링되는 부모 컴포넌트의 자식

   - 부모가 자주 리렌더링되지만 자식 컴포넌트의 props는 자주 변경되지 않는 경우

3. 동일한 props로 동일한 결과를 렌더링하는 순수 컴포넌트

   - 내부 상태나 컨텍스트에 의존하지않는 순수 함수형 컴포넌트

4. 큰 리스트의 아이템 컴포넌트
   - 특히 리스트가 자주 리렌더링되지만 개별 아이템은 변경되지 않는 경우

### 주의 사항과 사용 시점

1. 모든 컴포넌트에 사용하지 않기

   - 모든 컴포넌트를 React.memo()로 감싸는 것은 오히려 성능을 저하시킨다.
   - 메모이제이션 자체도 비용이 있다.

2. 효과적인 사용 상황

   - 동일한 props로 자주 렌더링되는 컴포넌트
   - 렌더링 비용이 큰 컴포넌트
   - 자식 컴포넌트의 props가 자주 변경되지 않는 경우

3. 참고사항
   - React.memo()는 props의 얕은 비교(shallow comparison)만 수행합니다.
   - 객체나 배열 같은 참조 타입 props는 내용이 같더라도 참조가 다르면 다시 렌더링된다.

## React 19에서의 변화

이전과 기본 동작은 크게 변경되지 않았지만, React의 새로운 자동 메모이제이션 기능과 함께 사용할 때 효율적으로 동작할 수 있다.

React 19에서 도입된 리액트의 컴파일러 최적화 기능은 필요한 경우 자동으로 메모이제이션을 적용할 수 있게 되었다.

React.memo()는 여전히 수동으로 명시적인 최적화가 필요한 경우 유효하며

특히 복잡한 컴포넌트나 특정 최적화 요구사항이 있는 경우에 활용할 수 있다.
