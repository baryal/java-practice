package com.practice.designpatterns.creational.abstractfactory;

public class BusinessLoanFactory implements LoanAbstractFactory {
  @Override
  public Loan getLoan() {
    return new BusinessLoan();
  }
}
