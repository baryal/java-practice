package com.practice.designpatterns.behavioral.chainofresponsibility;

import java.util.Scanner;

public class TestChainOfResponsibility {

  public static void main(String[] args) {
    ATMDispenseChain atmDispenser = new ATMDispenseChain();
    while (true) {
      int amount = 0;
      System.out.println("Enter amount to dispense");
      Scanner input = new Scanner(System.in);
      amount = input.nextInt();
      if (amount % 10 != 0) {
        System.out.println("Amount should be in multiple of 10s.");
        return;
      }
      // process the request
      atmDispenser.getFirstDispenseChain().dispense(new Currency(amount));
    }

  }
}
