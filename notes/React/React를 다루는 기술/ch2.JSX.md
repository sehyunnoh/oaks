# 1. 코드 이해
> Node.js의 주요 특징은 코드를 모듈화하여 재사용할수 있다는 것.
> ```js
> var fs = require('fs');
> import fs from 'fs'; // ES6 부터 생김 
> ```
> 모듈화 해서 사용하는 것은 Node.js의 기능임
> 웹 브라우저에서 사용하는 자바스크립트는 Node.js 런타임으로 실행하는 것이 아니라서 이 기능 지원 안함.
> 웹 브라우저에서는 번들링 도구를 이용하여 js 파일을 묶음 (webpack, Browserify, RequireJS 등)
> 번들링 도구를 이용하면 require(또는 import)로 모듈을 불러 왔을때 모듈들을 파일 하나로 합쳐줌.
> 이렇게 파일을 불러오는 것은 webpack의 로더(loader)가 담당함.
# 2. JSX란?
> 자바스크립트의 확장 문법으로 XML과 비슷하게 생김
> 나중에 코드가 번들링 되면서 babel-loader를 사용하여 자바스크립트로 변환 됨. 
# 3. JSX 장점
1. 보기 쉽고 익숙하다.
  - HTML 코드를 작성하는 것과 비슷함.
2. 오류 검사
3. 높은 활용도
   - HTML 태그 뿐만 아니라 컴포넌트도 안에다 작성할수 있음
# 4. JSX 문법
1. 감싸인 요소
    - component에 여러 요소가 있다면 부모 요소 하나로 감싸야 함. 
    - virtual dom에서 component 변화를 감지할때 효율적으로 비교할수 있도록 component내부는 dom 트리 구조 하나여야 한다는 규칙이 있음.
    - <fragment> 쓰면 불필요하게 div로 렌더링 하는 것 생략할수 있음.
2. 자바스크립트 표현 
    - JSX 안에 자바스크립트 표현식을 쓸수 있음. 
    - 내부에 코드를 {} 로 감싸면 됨. 
    - var는 scope이 함수 단위 / let, const는 scope이 block 단위 
3. JSX 안에서 if 문은 사용불가. 삼항 연산자는 사용 가능함. 
4. &&를 사용한 조건부 렌더링
```js
const condition = true;
condition ? 'true' : 'false' // true
condition ? 'true' : null    // true
condition&&'true' // true
```
5. 인라인 스타일링
    - 리액트에서 dom 요소에 스타일을 적용할때는 문자열 형태로 적용할수 없음. 그 대신 css 스타일을 객체 형식으로 만들어서 적용
    - 자바스크립트 객체 key에서는 '-'를 사용할수 없으므로 camel case로 변경하여 사용함
6. class 대신 className
    - class 키워드는 이미 자바스크립트에 존재하는 키워드 이기 때문에 className 사용
    - 리액트 컴포넌트 선언할때 class를 사용했었음.
7. 꼭 닫아야 하는 태그
    - JSX에서는 언제나 코드를 닫아 주어야 함 (br, input 등 모두)
8. 주석
    - { /*   */} 이런형식으로 주석 작성함.
    - self-closed 요소에서 /> 안에서는 {} 없이 주석 작성 가능
```js
<div
    // 주석
/>
```

