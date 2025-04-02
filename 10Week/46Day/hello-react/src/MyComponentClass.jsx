import React, { PureComponent } from 'react'

class MyComponentClass extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            
        }
    }

    static  defaultProps = {
        name : "기본 이름"
    };

    render() {
        const {name} = this.props;
        return (
            <div>
                {name}입니다.
            </div>
            
        )
    }
}

export default MyComponentClass;