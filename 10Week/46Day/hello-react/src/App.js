import './App.css';
import Counter from './Counter';
import MyComponent from './MyComponent';
import MyComponentClass from './MyComponentClass';
import Say from './Say';
import EventPractice from './EventPractice';
import CounterFunction from './CounterFunction';

function App() {
  return (
    <div className="App">
      <MyComponent />
      <MyComponent name={42}>칠드런</MyComponent>
      <MyComponentClass/>
      <Counter/>
      <Say/>
      <EventPractice/>
      <CounterFunction/>
    </div>
  );
}

export default App;