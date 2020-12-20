var calculator = require("../src/Calculator");
var calObject = new calculator();
var chai = require("chai");
var sinon = require("sinon");
var expect = chai.expect;
const chaiPromies = require("chai-as-promised");
chai.use(chaiPromies);

describe.skip("Test suite for Calculator", function(){
    it("To test add", function(){
        expect(calObject.add(2,3)).to.be.equal(5)
    })
    
    it("Spy add function", function(){
        var spyAdd = sinon.spy(calObject, "add");
        calObject.add(2,3);
        expect(spyAdd.calledOnce).to.be.true;
    })

    it("Spy callback function", function(){
       var spyCallBack = sinon.spy();
       calObject.displayer(spyCallBack);
       expect(spyCallBack.calledOnce).to.be.true;
    })

    
    it("Mock add function", function(){
        var mock = sinon.mock(calObject);
        var expectation = mock.expects("printNumbers");
        expectation.exactly(1);
        calObject.add(10,20);
        mock.verify();
     })

     it("Stub multiplier function", function(){
        var stub = sinon.stub(calObject, "multiplier");
        stub.withArgs(5,2).returns(1000);
        expect(calObject.multiplier(5,2)).to.be.equal(1000);
     })

     it("Test promise", function(){
         this.timeout(0);
         return expect(calObject.testPromise()).to.eventually.equal(4);
     })
})