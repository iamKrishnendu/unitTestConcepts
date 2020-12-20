var calculator = require("../src/Calculator");
var calObject = new calculator();
var chai = require("chai");
var sinon = require("sinon");
var expect = chai.expect;

describe ("Spies on Calculator", function(){
    var spyCalculator = sinon.spy(calObject, "add");

    it("Test returned result of add", function(){
        calObject.add(2,3);
        expect(spyCalculator.returned(5)).to.be.true;
        
    })
    it("Test add method never called with specified arguments", function(){
        calObject.add(2,3);
        expect(spyCalculator.neverCalledWith(5,6)).to.be.true;
    })
    it("Test add method called with specified arguments", function(){
        calObject.add(6,3);
        expect(spyCalculator.calledWith(6,3)).to.be.true;
        
    })
    it("Test number of times add is called", function(){
        calObject.add(3,3);
        expect(spyCalculator.withArgs(3,3).calledOnce).to.be.true;
        
    })
    it("Test number of times add is called with specific arguments", function(){
        calObject.add(4,3);
        expect(spyCalculator.withArgs(4,3).calledOnce).to.be.true;
        
    })
    it("Test add method throw exception", function(){
        calObject.add(6,6);
        expect(spyCalculator.threw()).to.be.false;
     })
    
})

