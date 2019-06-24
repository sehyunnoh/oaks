# 이벤트 핸들링
이벤트란 ? 마운스 클릭, 키보드 타이핑 ....   dom요소들과 상호작용 하는것들.

* 사용시 주의 사항
  1. HTML : onclick   React: onClick  => camelCase
  2. 이벤트 실행시 함수 형태 전달. HTML onclick ="clickMethod" , React onClick={() => console.log()}
  3. <input .... onclick="clcikMethod">커스텀 컴포넌트에서는 <MyComponent onClick={doSomething}> 함수를 실행하는게 아나라 그냥 이름이 onclick 인 props를 전달 받습니다.
   하지만  <div onClick={this.props.onClick}> <=이렇게는 사용가능

```js
onChange={(e) => console.log(e.target.value)}
```
* function and () => {} 다른점

책 4.2.3.1. 기본방식 과 비교
```js
handleChange = (e) => {
  this.setState({
    message: e.tart.value
  })
}
```
*  input 다중처리
```js
handleChange = (e) => {
  this.setState({
    [e.target.name] = e.target.value
  })
}
```
