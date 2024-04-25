const input = [10,50,10,5,10,15,20,50,100];

const uniqueValuesSet = new Set(input);

const uniqueValuesArray = Array.from(uniqueValuesSet);

console.log("a");

setTimeout(function() {
    console.log("b")
}, 0);

(async function(){
    await console.log("c")
})()

console.log("d")

console.log(uniqueValuesArray);
