package com.practice.designpatterns.behavioral.chainofresponsibility;

public class ATMDispenseChain {

  public DispenseChain getFirstDispenseChain() {
    return firstDispenseChain;
  }

  private DispenseChain firstDispenseChain;

  public ATMDispenseChain() {
    // initialize the chain
    this.firstDispenseChain = new Dollar50Dispenser();
    DispenseChain c2 = new Dollar20Dispenser();
    DispenseChain c3 = new Dollar10Dispenser();

    // set the chain of responsibility
    firstDispenseChain.setNextChain(c2);
    c2.setNextChain(c3);
  }

}
