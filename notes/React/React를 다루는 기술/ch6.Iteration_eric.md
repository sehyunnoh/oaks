# 6.1 자바스크립트 배열의 map() 함수
```js
var numbers = [1,2,3,4,5];

var processed = numbers.map(function(num){ return num * num});
var result = numbers.map(num => num * num);
```

# 6.2 데이터 배열을 컴포넌트 배열로 map 하기
```js
import React, { Component } from "react";

class IterationSample extends Component {
  render() {
    const names = ["눈사람", "얼음", "눈", "바람"];
    const nameList = names.map(name => <li>{name}</li>);

    return <ul>{nameList}</ul>;
  }
}

export default IterationSample;
```
```js
import React, { Component } from "react";
import IterationSample from "./IterationSample";

class App extends Component {
  render() {
    return <IterationSample />;
  }
}

export default App;
```

# 6.3 key
```js
import React, { Component } from "react";

class IterationSample extends Component {
  render() {
    const names = ["눈사람", "얼음", "눈", "바람"];
    const nameList = names.map((name, index) => <li key={index}>{name}</li>);

    return <ul>{nameList}</ul>;
  }
}

export default IterationSample;
```

# 6.4 응용
> Question
> ```js
>  onDoubleClick={() => this.handleRemove(index)}
>   // onDoubleClick={this.handleRemove(index)} -> error
> ```


```js
import React, { Component } from "react";

class IterationSample extends Component {
  state = {
    names: ["눈사람", "얼음", "눈", "바람"],
    name: ""
  };

  handleChange = e => {
    this.setState({
      name: e.target.value
    });
  };

  handleInsert = () => {
    this.setState({
      names: this.state.names.concat(this.state.name),
      name: ""
    });
  };

  handleRemove = index => {
    const { names } = this.state;
    this.setState({
    //   names: [...names.slice(0, index), ...names.slice(index + 1, names.length)]
      names: names.filter((item,i) => i !== index)
    });
  };

  render() {
    const nameList = this.state.names.map((name, index) => (
      <li key={index} onDoubleClick={() => this.handleRemove(index)}>
        {name}
      </li>
    ));

    return (
      <div>
        <input onChange={this.handleChange} value={this.state.name} />
        <button onClick={this.handleInsert}>추가</button>
        <ul>{nameList}</ul>
      </div>
    );
  }
}

export default IterationSample;
```

# 6.5 정리
> - 컴포넌트 배열을 렌더링 할때는 key 값 설정에 주의 해야 함.
> - key 값은 언제나 유일해야 하며 중복 된다면 렌더링 과정에서 오류가 발생함.
> - 상태 안에서 배열을 변형 할 때는 배열에 직접 접근하여 수정하는 것이 아니라 concat, slice, 전개 연산자, filter 함수 등을 이용하여 새로운 배열을 만든 후, setState 메서드로 적용 

 