# 4.1 리액트의 이벤트 시스템

## 4.1.1 이벤트 사용시 주의 사항
> 1. 이벤트 이름은 camelCase로 작성한다.
> 2. 이벤트에 실행할 자바스크립트 코드를 전달하는 것이 아니라, 함수 형태의 값을 전달한다.
> 3. DOM 요소에만 이벤트를 설정할 수 있다. 

## 4.1.2 이벤트 종류
> - clipboard
> - composition
> - keyboard
> - Focus 
> - Form
> - Mouse
> - Selection
> - Touch
> - UI
> - Wheel
> - Media
> - Image
> - Animation
> - Transition

## 4.2.2 onChange 이벤트 핸들링
```js
import React, { Component } from "react";

class EventPractice extends Component {
  state = {
    message: ""
  };

  render() {
    return (
      <div>
        <h1>이벤트 연습</h1>
        <input
          type="text"
          name="message"
          plcaeholder="아무거나 입력해보세요"
          value={this.state.message}
          onChange={e => {
            this.setState({
              message: e.target.value
            });
          }}
        />

        <button onClick={() => {
            alert(this.state.message);
            this.setState({
                message: ''
            })
        }}>확인</button>
      </div>
    );
  }
}

export default EventPractice;
```

## 4.2.3.2 Property Initializer Syntax를 사용한 메서드 작성
```js
import React, { Component } from "react";

class EventPractice extends Component {
  state = {
    message: ""
  };

  handleChange = (e) => {
      this.setState({
          message : e.target.value
      })
  }

  handleClick = (e) => {
      alert(this.state.message);
      this.setState({
          message : ''
      })
  }

  render() {
    return (
      <div>
        <h1>이벤트 연습</h1>
        <input
          type="text"
          name="message"
          plcaeholder="아무거나 입력해보세요"
          value={this.state.message}
          onChange={this.handleChange}
        />

        <button onClick={this.handleClick}>확인</button>
      </div>
    );
  }
}

export default EventPractice;
```

## 4.2.4 input 여러 개를 핸들링
> event 객체를 활용
```js
import React, { Component } from "react";

class EventPractice extends Component {
  state = {
    username: "",
    message: ""
  };

  handleChange = e => {
    this.setState({
      [e.target.name]: e.target.value
    });
  };

  handleClick = e => {
    alert(this.state.username + " : " + this.state.message);
    this.setState({
      username: "",
      message: ""
    });
  };

  render() {
    return (
      <div>
        <h1>이벤트 연습</h1>
        <input
          type="text"
          name="username"
          placeholder="유저명"
          value={this.state.username}
          onChange={this.handleChange}
        />
        <input
          type="text"
          name="message"
          placeholder="아무거나 입력해보세요"
          value={this.state.message}
          onChange={this.handleChange}
        />

        <button onClick={this.handleClick}>확인</button>
      </div>
    );
  }
}

export default EventPractice;


export default EventPractice;
```

## 4.2.5 onKeyPress 이벤트 핸들링
```js
import React, { Component } from "react";

class EventPractice extends Component {
  state = {
    username: "",
    message: ""
  };

  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value
    });
  };

  handleClick = () => {
    alert(this.state.username + " : " + this.state.message);
    this.setState({
      username: "",
      message: ""
    });
  };

  handleKeyPress = (e) => {
    if(e.key === 'Enter'){
        this.handleClick();
    }
  }

  render() {
    return (
      <div>
        <h1>이벤트 연습</h1>
        <input
          type="text"
          name="username"
          placeholder="유저명"
          value={this.state.username}
          onChange={this.handleChange}
        />
        <input
          type="text"
          name="message"
          placeholder="아무거나 입력해보세요"
          value={this.state.message}
          onChange={this.handleChange}
          onKeyPress={this.handleKeyPress}
        />

        <button onClick={this.handleClick}>확인</button>
      </div>
    );
  }
}

export default EventPractice;
```

# 4.3 정리
> 1. 리액트에서 이벤트 다루는 것은 순수 javascript, jQuery로 이벤트 다루는 것과 비슷
> 2. 자바스크립트에 익숙하다면 쉽게 활용할수 있음.