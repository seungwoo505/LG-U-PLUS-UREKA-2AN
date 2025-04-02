# CSS Module

Css 사용 시 class 명을 고유한 값으로 자동 생성하는 것

React에서 css module을 사용한다면 component에 적용하는 style 클래스 명이 중첩되는 현상을 방지하는 역할을 한다.

## Css Module 사용 방법

App.js
```

import styles from './App.css

function App() {
    return(
        <div className="App">
            <h1 className={styles.title}>Welcome!</h1>
        </div>
    )
};

export default App;

```

App.css

```

.title {
    font-family : 'Courier New', Courier, monospace;
    font-size : 18px;
}

```