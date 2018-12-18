package com.practice.designpatterns.behavioral.strategy;

public class CreditCardStrategy implements PaymentStrategy {

  private String name;
  private String cardNumber;
  private String cvv;
  private String dateOfExpiry;

  public CreditCardStrategy(String name, String cardNum, String cvv, String expiryDate){
    this.name = name;
    this.cardNumber = cardNum;
    this.cvv = cvv;
    this.dateOfExpiry = expiryDate;
  }

  @Override
  public void pay(int amount) {
    System.out.println(amount +" paid with credit/debit card");
  }
}
