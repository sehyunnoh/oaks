> 컴포넌트 스타일링 하는데 획일화된 방식은 없고 다양한 방식으로 가능함
> 가장 기본적인 방식은 CSS 파일을 사용하는 것
> 1. CSS Module : 모듈화된 CSS로 CSS 클래스를 만들면 자동으로 고유한 클래스네임을 생성하여 스코프를 지역적으로 제한하는 방식
> 2. Sass : 자주 사용하는 CSS 전처리기중 하나, 확장된 CSS문법을 사용하여 CSS 코드를 더욱 쉽게 작성
> 3. styled-components : JS 코드 내부에 스타일 정의

# 9.1 CSS Module
> yarn eject > config/webpack.config.js
> CSS 불러오는 과정에서 총 세 가지 로더를 사용함
> 1. style-loader : 스타일을 불러와 웹 페이지에서 활성화하는 역할
> 2. css-loader : css 파일에서 import와 url(...)문을 webpack의 require 기능으로 처리하는 역할
> 3. postcss-loader : 모든 웹 브라우저에서 입력한 css 구문이 제대로 작동할수 있도록 -webkit, -mos, -ms 등 접두사 붙여움.

```js
modules: true,
localIdentName : '[path][name]_ _[local]--[hash:base64:5]'
```
```css
/* App.css */
.box {
  display : inline-block;
  width : 100px;
  height: 100px;
  border: 1px solid black;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%)
}
```
```js
// App.js
import React from 'react';
import styles from './App.css';

console.log(styles);

function App() {
  return (
    <div className={styles.box}>
      
    </div>
  );
}

export default App;
```
```html
<!-- result -->
<div class="src-App_-_box--mjrNr"></div>
```

## 9.1.2.1 클래스가 여러 개 일때
```css
/* App.css */
.box {
  display : inline-block;
  width : 100px;
  height: 100px;
  border: 1px solid black;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%)
}
.blue{
    background: blue;
}
```
```js
// App.js
import React from 'react';
import styles from './App.css';

console.log(styles);

function App() {
  return (
    <div className={[styles.box, styles.blue].join(' ')}>
      
    </div>
  );
}

export default App;
```
```html
<!-- result -->
<div class="src-App_-_box--mjrNr src-App_-_blue--3CWHK"></div>
```
> classnames 라이브러리를 사용하면 더 편함
> ``` console
> yarn add classnames
> ```

```js
import React from 'react';
import classNames from 'classnames/bind';
import styles from './App.css';
const cx = classNames.bind(styles);

console.log(styles);

function App() {
  return (
    <div className={cx('box','blue')}>

    </div>
  );
}

export default App;
```

> classNames의 장점은 여러 형식으로 사용할수 있음.
> ![classnames](./image/classnames.png)

```js
import React, { Component } from "react";
import classNames from "classnames/bind";
import styles from "./App.css";
const cx = classNames.bind(styles);

class App extends Component {
  render() {
    const isBlue = false;

    return (
      <div
        className={cx("box", {
          blue: isBlue
        })}
      />
    );
  }
}

export default App;
```

# 9.2 Sass
> [Sass(Syntactically awesome style sheets)](https://sass-guidelin.es/)
> CSS에서 사용할수 있는 문법을 확장하여 중복되는 코드를 줄여 더욱 보기 좋게 작성
> sass-loader : webpack에서 Sass파일을 읽어옴
> node-sass : Sass로 작성된 코드들을 CSS로 변환
> ```console
> yarn add node-sass sass-loader
> ```

```js
{
    loader: require.resolve('sass-loader'),
    options: {
        
    }
}
```

## 9.2.2.1 현재 선택자 참조 
```css
.box:hover {
    background: red;
}

.box:active {
    background: yellow;
}
```
```cs
.box {
    &:hover {
        background: red;
    }
    &:active {
        background: yellow;
    }
}
```

## 9.2.2.2 감싸인 구조
> Sass를 사용하면 nested 구조로 코드를 보기 좋게 입력할수 있음. 

```js
import React, { Component } from "react";
import classNames from "classnames/bind";
import styles from "./App.scss";
const cx = classNames.bind(styles);

class App extends Component {
  render() {
    const isBlue = true;

    return (
      <div
        className={cx("box", {
          blue: isBlue
        })}
      >
        <div className={cx("box-inside")} />
      </div>
    );
  }
}

export default App;
```
```css
.box {
  display: inline-block;
  width: 100px;
  height: 100px;
  border: 1px solid black;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);

  &.blue {
    backgournd: blue;
  }

  &:hover {
    backgournd: yellow;
  }

  &:active {
    background: red;
  }

  .box-inside {
    background: black;
    width: 50px;
    height: 50px;
  }
}
```

## 9.2.2.3 변수 사용
```css
$size : 100px;

.box {
  display: inline-block;
  width: $size;
  height: $size;
  (...)
```

## 9.2.2.4 믹스인 사용
> 자주 사용하는 구문 믹스인으로 다시 이용 가능

```css
$size : 100px;

@mixin place-at-center(){
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.box {
  display: inline-block;
  width: $size;
  height: $size;
  border: 1px solid black;
  position: fixed;
  
  @include place-at-center();
  (...)
```

## 9.2.3 변수와 믹스인을 전역적으로 사용
> 전역적으로 사용할수 있도록 코드 분리후 불러오기

```scss
// src/styles/utils.scss
$size : 100px;

@mixin place-at-center(){
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
```
```js
// config/paths.js
module.exports = {
    (...),
    styles: resolveApp('src/styles')
}
```
```js
// config/webpack.config.js
{
    loader: require.resolve('sass-loader'),
    options: {
        includePaths: [paths.styles]
    }
}
```
```js
// src/App.scss
@import 'utils';

.box {
    (...)
}
```

## 9.2.4 Sass 라이브러리
> include-media : 반응형 디자인을 도와줌
> open-color : 여러가지 색상이 들어 있는 색상을 쉽게 고를수 있음
> ```console
>   yarn add include-media open-color
> ```

```css
/* src/styles/utils.scss */
@import "~open-color/open-color";
@import "~include-media/dist/include-media";

$breakpoints: (
  small: 375px,
  medium: 768px,
  large: 1024px,
  huge: 1200px
);

$size: 100px;

@mixin place-at-center() {
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
```

## 9.2.5 버튼 생성
```js
// src/components/Button/Button.js
import React from 'react';
import styles from './Button.scss'
import classNames from 'classnames/bind';

const cx = classNames.bind(styles);
const Button = ({children, ...rest}) => {
    return (
        <div className={cx('button')} {...rest}>
            {children}
        </div>
    )
}

export default Button;
```
```scss
// src/components/Button/Button.scss
@import '../../styles/utils.scss';

.button {
    background: $oc-green-7;
    transition: all .2s ease-in;
    display: inline-block;
    padding-top: 2rem;
    padding-bottom: 2rem;
    text-align: center;
    color: white;
    position: fixed;
    font-size: 2rem;
    font-weight: 500;
    border-radius: 4px;
    cursor: pointer;

    @include place-at-center();

    width: 1200px;

    //반응형 디자인
    @include media("<huge"){
        width: 1024px;
    }

    @include media("<large"){
        width: 768px;
    }

    @include media("<medium"){
        width: 90%;
    }

    &:hover{
        background: $oc-green-6;
    }
    &:active{
        margin-top: 3px;
        background: $oc-green-8;
    }
}
```
```js
// src/components/Button/index.js
// index.js를 만들면 컴포넌트를 불러온 후 바로 내보낼수 있음. 
// index.js 안 만들면 ./components/Button/Button으로 불러야 함
export { default } from './Button';
```

# 9.3 styled-components
> CSS in JS : javascript 파일 안에 스타일을 선언하는 방식
> ```console
> yarn add styled-components
> ```

```js
import React from 'react';
import styled from 'styled-components';

const Wrapper = styled.div`
    border: 1px solid black;
    display: inline-block;
    padding: 1rem;
    border-radius: 3px;
    font-size: ${(props) => props.fontSize};
    ${props => props.big && `
        font-size: 2rem;
        padding: 2rem;
    `}
    &:hover {
        background: black;
        color: white;
    }
`;

const StyledButton = ({children, big, ...rest}) => {
    return(
        <Wrapper fontSize="1.25rem" {...rest} big={big}>
            {children}
        </Wrapper>
    )
}

export default StyledButton;
```
```js
import React, { Component } from "react";
import StyledButton from './components/StyledButton';

class App extends Component {
  render() {
    return (
      <div>
        <StyledButton>버튼</StyledButton>
      </div>
    );
  }
}

export default App;
```
> 장점 : 자바스크립트 내부에서 스타일을 정의하기 때문에 자바스크립트와 스타일 사이의 벽이 허물어져 동적 스타일링이 더욱 편해 짐
> 변수 선언 및 믹스인 처럼 함수를 따로 만들수도 있고 감싸인 구조로도 작성할수 있음

# 9.4 정리
> 1. 일반 CSS : 이미 CSS가 익숙한 개발자들에게는 친숙할 것
> 2. CSS Module : 스코프 관련 문제 해결
> 3. Sass : 확장된 CSS 문법으로 깔끔하고 편안하게 코드를 작성
> 4. styled-components : 자바스크립트와 CSS 사이의 벽을 허물어줘서 동적 스타일링 편하고 한 파일에서 스타일과 자바스크립트 코드를 모두 관리 할수 있지만 기존 CSS와 다른 흐름으로 관리하는 단점과 협업시 디자이너가 일일이 따로 포팅해야 하는 단점이 있음.
> 어떤 방법이 가장 좋은지는 정답이 없음. 본인이 가장 편하게 느끼는 방법이 좋은 것
