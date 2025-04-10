import React from "react";
import css from "../css/Card.module.css";

// 이미지 import
import paperImg from "../assets/paper.png";
import questionImg from "../assets/questionmark.png";
import rockImg from "../assets/rock.png";
import scissorsImg from "../assets/scissors.png";

const Card = ({ userTitle, choice, result, type }) => {
  // 선택 -> 이미지 매핑
  const choiceToImage = {
    가위: scissorsImg,
    바위: rockImg,
    보: paperImg,
    "?": questionImg,
  };

  // 이미지 선택 로직
  const image = choice ? choiceToImage[choice] : choiceToImage["?"];

  // 결과에 따른 클래스 결정
  const getResultClass = () => {
    if (!result) return "";
    if (result === "이겼다") return css.win;
    if (result === "졌다") return css.lose;
    return css.draw;
  };

  return (
    <article className={`${css.card} ${getResultClass()} ${css[type]}`}>
      <h2 className={css.userTitle}>{userTitle}</h2>
      <div className={css.imageContainer}>
        <img src={image} alt={choice || "?"} className={css.choiceImage} />
      </div>
      <p className={css.resultText}>{result || "선택하세요"}</p>
    </article>
  );
};

export default Card;
