package com.practice.codingchallenge;

import java.util.Scanner;

// Factorial of n is the product of all positive descending integers. Factorial of n is denoted by n!. For example:
// 4! = 4*3*2*1 = 24
// 5! = 5*4*3*2*1 = 120
// Here, 4! is pronounced as "4 factorial", it is also called "4 bang" or "4 shriek".
public class FactorialDemo {

  static int factorial(int n){
    if (n == 0)
      return 1;
    else
      return(n * factorial(n-1));
  }

  public static void main(String args[]){
    int i,fact=1;
    System.out.println("Please Enter a number : ");
    int number = new Scanner(System.in).nextInt(); // It is the number to calculate factorial

    for(i=1;i<=number;i++){
      fact=fact*i;
    }
    System.out.println("Factorial of "+number+" is: "+fact);

    fact = factorial(number);
    System.out.println("Factorial of "+number+" using recursion is: "+fact);
  }
}
