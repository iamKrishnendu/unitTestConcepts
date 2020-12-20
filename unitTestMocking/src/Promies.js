function testPromise(){
    return new Promise((resolve, reject)=>{
        setTimeout(resolve(2), 2000);
    }).then(function (result) {
        return result * 2;
    })
}

function testCallBack(){
    
}
module.exports = testPromise;