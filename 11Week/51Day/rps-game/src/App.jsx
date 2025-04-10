import { useEffect, useState } from "react";
import style from './css/App.module.css';
import Card from "./components/card"
import Button from "./components/Button";

function App() {
  const [winner, setWinner] = useState("?");
  const [choice, setChoice] = useState("questionmark");
  const [computer, setComputer] = useState("questionmark");

  const reset = () => {
    setWinner("?");
    setChoice("questionmark");
    setComputer("questionmark");
  }

  useEffect(() => {
    if(choice === "questionmark") return;
    const computerChoice = ['scissors', 'rock', 'paper'];
    const randomIndex = Math.floor(Math.random() * 3);

    const randomChoice = computerChoice[randomIndex];

    setComputer(randomChoice);

    if(choice === randomChoice){
      setWinner("비겼다")
    }else if(
      (choice === "scissors" && randomChoice === "paper") ||
      (choice === "rock" && randomChoice === "scissors") ||
      (choice === "paper" && randomChoice === "rock")
    ){
      setWinner("이겼다")
    }else {
      setWinner("졌다")
    }

  }, [choice])

  return (
    <div className={style.container}>
      <header>
        <h1>가위바위보 게임</h1>
      </header>
      <main className={style.main}>
        <Card player={true} winner={winner} choice={choice}/>
        <Button winner={winner} setChoice={setChoice} reset={reset}/>
        <Card player={false} winner={winner} choice={computer}/>
      </main>
      <footer className={style.footer}>
        <p>버튼을 클릭하여 가위, 바위, 보 중 하나를 선택하세요.</p>
        <p>
          컴퓨터는 랜덤으로 선택합니다.
        </p>
      </footer>
    </div>
  )
}

export default App
