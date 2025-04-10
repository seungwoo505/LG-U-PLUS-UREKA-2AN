import Card from "./components/Card";
import Button from "./components/Button";
import css from "./css/App.module.css";
import { useState } from "react";

const App = () => {
  // 게임 상태 관리
  const [userChoice, setUserChoice] = useState(null);
  const [computerChoice, setComputerChoice] = useState(null);
  const [result, setResult] = useState(null);
  const [isPlaying, setIsPlaying] = useState(false);

  // 선택지 정의
  const choices = ["가위", "바위", "보", "?"];

  const determineWinner = (user, computer) => {
    if(user === computer) return "무승부";
    if(
    (user === "가위" && computer === "보") ||
    (user === "바위" && computer === "가위") ||
    (user === "보" && computer === "바위")){
       return "이겼다";
    }
    return "졌다";
  }

  const generateRandomChoice = () => {
      const index = Math.floor(Math.random() * 3);
      return choices[index];
  }
  const handleUserChoice = (choice) => {
    console.log("버튼 클릭", choice);
    if(isPlaying) return;
    setIsPlaying(true);

    setTimeout(() => {
      // srp 게임 로직
      // 1. 유저의 선택을 설정
      setUserChoice(choice);
      // 2. 컴퓨터의 선택을 랜덤으로 설정
      const randomChoice = generateRandomChoice();
      setComputerChoice(randomChoice);
      // 3. 결과를 판단
      setResult(determineWinner(choice, randomChoice));
      // 4. 결과를 설정 
      //setIsPlaying(false);
    }, 300);
  };

  const resetGame = () => {
    setUserChoice(null);
    setComputerChoice(null);
    setResult(null);
    setIsPlaying(null)
  }
  return (
    <div className={css.container}>
      <h1>가위바위보 게임</h1>

      {/* 게임 영역 */}
      <section>
        {/* 플레이어 영역 */}
        <Card userTitle="너님" choice={userChoice} result={result} type="user" />
        <Card
          userTitle="상대선수"
          choice={computerChoice}
          result={result === "이겼다" ? "졌다" : result === "졌다" ? "이겼다" : "무승부"}
          type="computer"
        />

        {/* 버튼 영역 */}
        <div className={css.buttonGroup}>
          {choices.slice(0, 3).map((choice) => (
            <Button
              key={choice}
              choice={choice}
              onClick={() => handleUserChoice(choice)}
              disabled={isPlaying}
            />
          ))}

          {/* 결과 표시 */}
          <div className={css.resultDisplay}>{result}</div>

          {/* 리셋 버튼 */}
          <button className={css.resetButton} onClick={resetGame}>다시하기</button>
        </div>
      </section>

      <div>
        <p>버튼을 클릭하여 가위, 바위, 보 중 하나를 선택하세요.</p>
        <p>컴퓨터는 랜덤으로 선택합니다.</p>
      </div>
    </div>
  );
};

export default App;
