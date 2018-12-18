package com.practice.designpatterns.creational.abstractfactory;

public class LoanFactory {

  public static LoanAbstractFactory getLoanAbstractFactory(String loanType) {
    LoanAbstractFactory loanAbstractFactory = null;
    if("education".equalsIgnoreCase(loanType)) {
      loanAbstractFactory = new EducationLoanFactory();
    }
    else if("business".equalsIgnoreCase(loanType)) {
      loanAbstractFactory = new BusinessLoanFactory();
    }
    else {
      loanAbstractFactory = new HomeLoanFactory();
    }
    return loanAbstractFactory;
  }
  public static Loan getLoan(LoanAbstractFactory factory) {
    return factory.getLoan();
  }
}
