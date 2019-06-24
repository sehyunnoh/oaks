> 1. DOM 의 특정 요소에 id를 달면 해당 요소를 찾아가 작업을 할수 있음
> 2. 리액트에서는 컴포넌트를 여러번 사용할수 있기 때문에 권장하지 않음
> 3. id와 같은 역할을 하는 것이 ref
> 4. ref는 전역적으로 사용하지 않고 컴퍼넌트 내부에서만 작동함.

# 5.1 ref는 어떤 상황에서 사용해야 할까?
> DOM을 꼭 직접적으로 건드려야 할때
> state 변경 만으로 해결할수 없는 기능들이 있음.
> - 특정 input에 포커스 주기
> - 스크롤 박스 조작하기
> - Canvas 요소에 그림 그리기 등
```js
// id로 구현한 부분을 state 사용하여 대체하기
import React, { Component } from "react";
import "./ValidationSample.css";

class ValidationSample extends Component {
  state = {
    password: " ",
    clicked: false,
    validated: false
  };
  handleChange = e => {
    this.setState({
      password: e.target.value
    });
  };

  handleButtonClick = () => {
    this.setState({
      clicked: true,
      validated: this.state.password === "0000"
    });
  };

  render() {
    return (
      <div>
        <input
          type="password"
          value={this.state.password}
          onChange={this.handleChange}
          className={
            this.state.clicked
              ? this.state.validated
                ? "success"
                : "failure"
              : ""
          }
        />
        <button onClick={this.handleButtonClick}>검증하기</button>
      </div>
    );
  }
}

export default ValidationSample;
```
# 5.2 ref 사용
```js
// input 클릭 했을때 focus 주기
<input ref={(ref) => this.input=ref} />

handleButtonClick = () => {
    this.setState({
        clicked: true,
        validated: this.state.password === "0000"
    });
    this.input.focus();
};
```
# 5.3 컴포넌트에 ref 달기
```js
import React, { Component } from "react";

class ScrollBox extends Component {
  scrollToBottom = () => {
    const { scrollHeight, clientHeight } = this.box; // 비구조화 할당 문법
    this.box.scrollTop = scrollHeight - clientHeight;
  };

  render() {
    const style = {
      border: "1px solid black",
      height: "300px",
      width: "300px",
      overflow: "auto",
      position: "relative"
    };

    const innerStyle = {
      width: "100%",
      height: "650px",
      background: "linear-gradient(white, black)"
    };

    return (
      <div style={style} ref={ref => (this.box = ref)}>
        <div style={innerStyle} />
      </div>
    );
  }
}

export default ScrollBox;
```
```js
import React, { Component } from "react";
import ScrollBox from "./ScrollBox";

class App extends Component {
  render() {
    return (
      <div>
        <ScrollBox ref={ref => (this.scrollBox = ref)} />
        <button onClick={() => this.scrollBox.scrollToBottom()}>
          맨 밑으로
        </button>
      </div>
    );
  }
}

export default App;
```
# 5.4 정리
> - 컴포넌트 내부에서 DOM에 직접 접근을 해야 할때 ref를 사용함.
> - 컴포넌트끼리 데이터를 교류 할때는 언제나 데이터를 부모 <-> 자식 흐름으로 교류하기 (ref를 무분별하게 사용하지 말기)