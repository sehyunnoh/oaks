var http = require("http");

const capacityOfropes = [10, 15];

console.log("——start—— ");

const calurateWeight = capacityOfropes => {
  let weightOfthing = 0;
  let numberOfrope = capacityOfropes.length;
  let minCapcity = Math.min(…capacityOfropes);
  weightOfthing = minCapcity * numberOfrope;
  return weightOfthing;
};

console.log("Output : ", calurateWeight(capacityOfropes));
//create a server object:
http
  .createServer(function(req, res) {
    res.write("Hello World!"); //write a response to the client
    res.end(); //end the response
  })
  .listen(8080);