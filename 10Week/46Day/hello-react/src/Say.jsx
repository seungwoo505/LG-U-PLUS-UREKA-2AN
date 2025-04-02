import React, { useState } from 'react';
/*
    배열 비구조화 할당

    const array = [1, 2];

    const one = array[0];
    const two = array[1];

    --------------------------------

    const [one, two] = array;(비구조화 할당)
 */

const Say = () => {
    const [message, setMessage] = useState("하이");
    const [color, setColor] = useState("blue");

    const onClickEnter = () => {
        setMessage("안녕하세요!");
    };

    const onClickLeave = () => {
        setMessage("안녕히가세요!");
    }
    return (
        <div>
            <h1 style={{color}}>{message}</h1>
            <button onClick={onClickEnter}>입장</button>
            <button onClick={onClickLeave}>퇴장</button>
            <button style={{color : "red"}} onClick={() => setColor("red")}>빨간색</button>
            <button style={{color : "blue"}} onClick={() => setColor("blue")}>파란색</button>
            <button style={{color : "green"}} onClick={() => setColor("green")}>초록색</button>
        </div>
    );
};

export default Say;