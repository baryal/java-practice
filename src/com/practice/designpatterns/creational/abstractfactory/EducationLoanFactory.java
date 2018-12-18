package com.practice.designpatterns.creational.abstractfactory;

public class EducationLoanFactory implements LoanAbstractFactory {
  @Override
  public Loan getLoan() {
    return new EducationLoan();
  }
}
