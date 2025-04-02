import React, { Component } from 'react';

class EventPractice extends Component {
    state = {
        message : ""
    };

    //미리 임의의 함수를 선언해서 사용하는 방법
    //bind는 html로 마크업되는 과정에서 임의 메서드가 this와 연결이 끊어진다.
    // 그래서 끊어지지않고 컴포넌트 스스로를 가르키기위해 바인딩해주는 작업.
    /*
    constructor(props){
        super(props);

        this.handleChange = this.handleChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    handleChange(e) {
        this.setState({message : e.target.value});
    }

    handleClick() {
        alert(this.state.message);

        this.setState({
            message : ""
        });
    }
    */

    handleChange = (e) => {
        this.setState({message : e.target.value});
    }

    handleClick = () => {
        alert(this.state.message);

        this.setState({
            message : ""
        });
    }


    render() {
        return (
            <div>
                <h1>이벤트 연습</h1>
                <input
                    type='text'
                    name='message'
                    placeholder='아무거나 입력해 보세요'
                    value={this.state.message}
                    onChange={(e) => {
                        this.setState({
                            message : e.target.value
                        });
                    }}
                />
                <button onClick={this.handleClick}>확인</button>
                {/* 인라인으로도 함수를 만들어서도 이벤트를 생성할 수 있다. */}
            </div>
        );
    }
}

export default EventPractice;