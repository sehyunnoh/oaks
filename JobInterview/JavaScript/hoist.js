// variable hoisting
console.log(test);
var test = "test";
console.log(test);

// ---------------------------------

var test2;
console.log(test2);
test2 = "test";
console.log(test2);

// function hoisting
hoistTest();

function hoistTest() {
  console.log("hoistTest");
}

// ---------------------------------

function hoistTest2() {
  console.log("hoistTest2");
}

hoistTest2();

// ---------------------------------
var hoistTest3 = function() {
    console.log("hoistTest3");
};

hoistTest3();

// ---------------------------------
hoistTest4();

var hoistTest4 = function() {
    console.log("hoistTest4");
};
