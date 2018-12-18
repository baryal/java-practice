package com.practice.designpatterns.creational.abstractfactory;

public class HomeLoanFactory implements LoanAbstractFactory {
  @Override
  public Loan getLoan() {
    return new HomeLoan();
  }
}
