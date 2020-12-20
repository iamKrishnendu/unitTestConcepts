class Calculator{
    constructor(){
        console.log("Let's calculate");
    }

    add(number1, number2){
        try{
            if(isNaN(number1) || isNaN(number2)){
                throw 'Parameter is not valid!';
             }else{
                return number1 + number2;
            }
        }catch(e){
            console.error(e);
            
        }
    }
}

module.exports = Calculator