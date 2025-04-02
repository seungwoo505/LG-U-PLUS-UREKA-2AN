import React, { useEffect, useState } from 'react';

const CounterFunction = () => {
    const [count, setCount] = useState(0);

    useEffect(()=> {
        console.log(`${count}으로 바뀌었습니다.`);
    }, [count]);

    const plus = () => {
        setCount(count + 1);
    }

    const minus = () => {
        setCount(count - 1)
    }

    const plus2 = () => {
        setCount((prevState) => prevState + 1);
        setCount((prevState) => prevState + 1);
    }

    const minus2 = () => {
        setCount((prevState) => { return prevState - 1});
        setCount((prevState) => {return prevState - 1});
    }
    return (
        <div>
            <h1>{count}</h1>
            <button onClick={plus}>+1</button>
            <button onClick={minus}>-1</button>
            <button onClick={plus2}>+2</button>
            <button onClick={minus2}>-2</button>
        </div>
    );
};

export default CounterFunction;