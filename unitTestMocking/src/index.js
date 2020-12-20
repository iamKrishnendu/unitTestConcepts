function add(arg1, arg2){
    printNumbers(arg1, arg2);
    console.log (arg1 + arg2);
} 

function printNumbers(number1, number2){
    console.log(`Given numbers are ${number1} and ${number2}`);
}

add(10, 20);