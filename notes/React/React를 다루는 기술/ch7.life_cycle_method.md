# 7.1 이해
> 라이플 사이클 메서드의 종류는 총 열가지
> Will 접두사가 붙은 메서드는 어떤 작업을 작동하기 전에 실행되는 메서드
> Did 접두사가 붙은 메서드는 어떤 작업을 작동한 후에 실행되는 메서드
> 세가지 카테고리로 나뉨 : 마운트, 업데이트, 언마운트

## 마운트
> DOM 이 생성되고 웹 브라우저상에 나타나는 것을 마운트라고 한다.   

![Mount](./image/mount.png)
> - constructor : 컴포넌트를 새로 만들 때마다 호출되는 클래스 생성자 메서드 입니다.
> - getDerivedStateFromProps : props에 있는 값을 state에 동기화 하는 메서드 입니다.
> - render : 우리가 준비한 UI를 렌더링 하는 메서드
> - ComponentDidMount : 컴포넌트가 웹 브라우저상에 나타난 후 호출하는 메서드

## 업데이트
> 컴포넌트를 업데이트 할 때는 다음 총 네가지 경우
> 1. props가 바뀔때
> 2. state가 바뀔때
> 3. 부모 컴포넌트가 리렌더링 될때
> 4. this.forceUpdate로 강제로 렌더링을 트리거 할때

![updateMethod](./image/updateMethod.png)
> - getDerivedStateFromProps : 마운트 과정에서도 호출하며, props가 바뀌어서 업데이트 할때도 호출한다.
> - shouldComponentUpdate : 컴포넌트가 리렌더링을 해야 할지 결정하는 메서드, false 반환시 아래 메서드들 호출하지 않음
> - render : 컴포넌트를 리렌더링
> - getSnapshotBeforeUpdate : 컴포넌트 변화를 DOM에 반영하기 바로 직전에 호출하는 메서드
> - componentDidUpdate : 컴포넌트의 업데이트 작업이 끝난후 호출하는 메서드

## 언마운트
> 컴포넌트를 DOM에서 제거

![unmount](./image/unmount.png)
> - componentWillUnmount : 컴포넌트가 웹 브라우저상에서 사라지기 전에 호출하는 메서드

## 살펴보기 
>  # render()
> - 컴포넌트 모양새를 정의함
> - 이 메서드 안에서 this.props, this.state에 접근할수 있으며 리액트 요소를 반환함.
> - 라이플 사이클 메서드 중 유일한 필수 메서드
> - 아무것도 보여주고 싶지 않으면 null, false 값 반환
> - 이 메서드 안에서는 절대로 state를 변형해서는 안되고 웹 브라우저에 접근해서도 안됨.
> - DOM 정보를 가져오거나 변화를 줄때는 componentDidMount에서 처리 하도록 한다.    
> #  constructor()
> - 컴포넌트 생성자 메서드
> - 컴포넌트 최초 생성시 실행 됨.
> - 초기 state를 정할수 있음.
> # getDerivedStateFromProps()
> - props로 받아온 값을 state에 동기화 시키는 용도로 사용
> - 컴포넌트를 마운트 하거나 props를 변경할 때 호출함
> # componentDidMount()
> - 컴포넌트를 만들고, 첫 렌더링을 마친후 실행 함
> - 다른 자바스크립트 라이브러리, 프레임워크 함수 호출, 이벤트 등록, setTimeout, setInterval, 네트워크 요청 같은 비동기 작업 처리
> # shouldComponentUpdate()
> - props 또는 state 변경 했을때, 리렌더링 시작할지 여부를 지정하는 메서드
> - boolean 값을 리턴 함.
> - 이 메서드를 따로 설정하지 않으면 default로 true 반환 함
> - 현재 : this.props, this.state / 새로 설정 : nextProps, nextState
> # getSnapshotBeforeUpdate()
> - render 메서드 호출 한 후 DOM에 변화를 반영하기 바로 직전에 호출하는 메서드
> # componentDidUpdate()
> - 리렌더링 완료 후 실행
> - 업데이트가 끝난 직후이므로 DOM 관련 처리해도 괜찮음
> # componentWillUnmount()
> - 컴포넌트를 DOM에서 제거할 때 실행
> - componentDidMount에서 등록한 이벤트, 타이머, 직접 생성한 DOM이 있다면 여기서 제거

# 7.3 사용
```js
import React, { Component } from "react";

class LifeCycleSample extends Component {
  state = {
    number: 0,
    color: null
  };

  myRef = null;

  constructor(props) {
    super(props);
    console.log("constructor");
  }

  static getDerivedStateFromProps(nextProps, prevState) {
    if (nextProps.color !== prevState.color) {
      return { color: nextProps.color };
    }
    return null;
  }

  componentDidMount() {
    console.log("componentDidMount");
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate", nextProps, nextState);
    return nextState.number % 10 !== 4;
  }

  componentWillUnmount() {
    console.log("componentWillUnmount");
  }

  handleClick = () => {
    this.setState({
      number: this.state.number + 1
    });
  };

  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnaptshotBeforeUpdate");
    if (prevProps.color !== this.props.color) {
      return this.myRef.style.color;
    }
    return null;
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("componentDidUpdate", prevProps, prevState);
    if (snapshot) {
      console.log("업데이트 되기 직전 색상: ", snapshot);
    }
  }

  render() {
    console.log("render");

    const style = {
      color: this.props.color
    };

    return (
      <div>
        <h1 style={style} ref={ref => (this.myRef = ref)}>
          {this.state.number}
        </h1>
        <p>color: {this.state.color}</p>
        <button onClick={this.handleClick}>더하기</button>
      </div>
    );
  }
}

export default LifeCycleSample;
```
```js
import React, { Component } from "react";
import LifeCycleSample from "./LifeCycleSample";

function getRandomColor() {
  return "#" + Math.floor(Math.random() * 16777215).toString(16);
}

class App extends Component {
  
  state = {
    color: "#000000"
  };

  handleClick = () => {
    this.setState({
      color: getRandomColor()
    });
  };

  render() {
    return (
      <div>
        <button onClick={this.handleClick}>랜덤 색상</button>
        <LifeCycleSample color={this.state.color} />
      </div>
    );
  }
}
export default App;
```

# 7.4 정리
![lifecycle](./image/lifecycle.png)
> - 라이프 사이클 메서드는 컴포넌트 상태에 변화가 있을때마다 실행하는 메서드
> - 이 메서드들은 third party 라이브러리를 사용하거나 DOM을 직접 건드려야 하는 상황에서 유용함
> - 컴포넌트 업데이트 성능 개선 할때는 shouldComponentUpdate가 중요하게 사용됨.
