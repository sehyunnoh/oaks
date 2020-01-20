function greet(greeting){
    return function(name){
        return `${greeting} ${name}`
    }
}
console.log(greet('Hi')('jimin'));

const friends = ['a','b','c','d'];
const friendGreetings = friends.map(greet('Hi'));
console.log(friendGreetings);
