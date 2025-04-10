import React from 'react'
import style from '../css/Card.module.css';

const Card = ({player, winner, choice}) => {
  return (
    <div className={style.card}>
        <h2>{player ? "너님" : "상대선수"}</h2>
        <img src={`./${choice}.png`} alt='choice'></img>
        <p>{winner === "?" ? "선택하세요" : player ? winner: winner === "이겼다" ? "졌다" : winner === "졌다" ? "이겼다" : "비겼다"}</p>
    </div>
  )
}

export default Card