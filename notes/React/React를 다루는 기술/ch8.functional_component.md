> 컴포넌트를 만들때 Life cycle과 state를 사용할 필요가 없고 props를 전달받아 뷰를 렌더링 하는 역할만 한다면 함수형 컴포넌트로 선언하면 더 간단 함

# 8.1 함수형 컴포넌트 사용법
```js
import React from 'react'

function Hello(props){
    return (
        <div>Hello {props.name}</div>
    )
}

export default Hello;
```
```js
import React from 'react'

const Hello = ({name} => {
    return (
        <div>Hello {name}</div>
    )
})

export default Hello;
```
```js
import React from 'react'

const Hello = ({name} => (
    <div>Hello {name}</div>
))

export default Hello;
```

# 8.2 언제 함수형 컴포넌트를 사용해야 할까?
> 함수형 컴포넌트는 라이프사이클, state등의 기능을 제거한 상태라서 메모리 소모가 적고, 빠름
> 컴포넌트를 만들때는 대부분 함수형으로 하며 state나 라이프사이클 API를 써야하는 경우에만 클래스 형태로 컴포넌트 생성 함.
