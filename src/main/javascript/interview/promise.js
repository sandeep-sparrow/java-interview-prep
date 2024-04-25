// promise in JS
// may resolve, reject, or be pending

// so, What's a Promise in JS
// State 1: Resolve - Constant
// State 2: Reject - Constant
// State 3: Pending - Changing, either to reject, or resolve

function compute(n){
    return new Promise(function(resolve, reject){
        setTimeout(() => {
            if(n >= 0){
                resolve(n*2);
            }else{
                reject("Invalid input");
            }
        }, 2000);
    });
}

compute(-4)
    .then(data => data + 1)
    .catch(error => {
        console.log(`ERROR: ${error}`)
        throw "This is beyond resonable repair";
    })
    .then(data => data * 4)
    .then(data => console.log(data))
    .catch(error => console.log(error));


