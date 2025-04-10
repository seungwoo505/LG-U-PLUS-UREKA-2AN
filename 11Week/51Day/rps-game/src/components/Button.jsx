import React from 'react'
import style from '../css/Button.module.css';

const Button = ({winner, setChoice, reset}) => {
    const rsp = ["rock", "scissors", "paper"];
    const choice = (e) => {
        if(winner === "?"){
            setChoice(e.target.alt);
        }else{
            alert("다시하기 버튼을 눌러주세요");
        }
    }
  return (
    <div className={style.button}>
        {rsp.map((e) => {
            <button onClick={choice}>
                <img src={`./${e}.png`} alt={e}/>
                <p>{e === "rock" ? "바위" : e === "scissors" ? "" : ""}</p>
            </button>
        })}
        <button onClick={choice}>
            <img src="./scissors.png" alt="scissors" />
            <p>가위</p>
        </button>
        <button onClick={choice}>
            <img src="./rock.png" alt="rock" />
            <p>바위</p>
        </button>
        <button onClick={choice}>
            <img src="./paper.png" alt="paper" />
            <p>보</p>
        </button>
        <div>
            <p>{winner}</p>
        </div>
        {
            winner !== "?" &&
            <button onClick={reset}>
                <p>다시하기</p>
            </button>
        }
    </div>
  )
}

export default Button