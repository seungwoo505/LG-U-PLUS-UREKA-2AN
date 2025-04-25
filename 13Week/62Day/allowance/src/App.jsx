import './App.css';
import HistoryAllowance from './components/HistoryAllowance';
import InputAllowance from './components/InputAllowance';
import TotalAllowance from './components/TotalAllowance';
import '@fortawesome/fontawesome-free/css/all.min.css';

function App() {

  return (
    <>
      <h1>용돈기입장</h1>

      <div>
        <TotalAllowance />
        <InputAllowance />
        <HistoryAllowance />
      </div>
    </>
  )
}

export default App
