import React, { Component } from 'react';
// state 컴포넌트 내부에서 바뀔 수 있는 값을 의미
// props는 부모요소가 설정한 값을 사용. 읽기만 가능

class Counter extends Component {

    /*
    constructor(props){
        super(props);

        this.state = {
            number : 0,
            fixedNumber : 0
        };
    }
    */

    state = {
        number : 0,
        fixedNumber : 0
    }

    render() {
        const { number, fixedNumber } = this.state;
        return (
            <div>
                <h1>{number}</h1>
                <h2>{fixedNumber}</h2>
                <button onClick={() => {
                    //this.setState를 사용히여 state에 새로운 값을 넣을 수 있다.
                    //this.setState({number : number + 1});
                    //this.setState({number : this.state.number + 1}); // 비동기적으로 처리하기 때문에 원하는대로 동작하지않는다.

                    // 인자를 함수방식으로 넣는 방법
                    //1
                    this.setState((prevState) => {
                        return{
                            number : prevState.number + 1
                        }
                    });

                    //2 (권장 방식)
                    this.setState((prevState) => (
                        {
                            number : prevState.number + 1
                        }
                    ));
                }}>number+1</button>
                <button onClick={() => this.setState({number : number - 1})}>number-1</button>

                <button onClick={() => {
                    //this.setState를 사용히여 state에 새로운 값을 넣을 수 있다.
                    this.setState({fixedNumber : fixedNumber + 1}, () => {
                        console.log("방금 setState가 호출되었습니다.");
                        console.log(this.state);
                    });
                }}>fixedNumber+1</button>
                <button onClick={() => this.setState({fixedNumber : fixedNumber - 1})}>fixedNumber-1</button>
            </div>
        );
    }
}

export default Counter;