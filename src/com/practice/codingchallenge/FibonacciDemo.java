package com.practice.codingchallenge;

import java.util.Scanner;

// Fibonacci series is series of natural number where next number is equivalent to the sum of previous two number
// e.g. fn = fn-1 + fn-2. The first two numbers of Fibonacci series is always 1, 1.
// https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
public class FibonacciDemo {

  public static void main(String args[]) {

    //input to print Fibonacci series upto how many numbers
    System.out.println("Enter number upto which Fibonacci series to print: ");
    int number = new Scanner(System.in).nextInt();
    System.out.println("Fibonacci series upto " + number + " numbers : ");
    //printing Fibonacci series upto number
    for (int i = 1; i <= number; i++) {
      System.out.print(fibonacci2(i) + " ");
    }
  }

  public static int fibonacci(int number){
      if(number == 1 || number == 2){
        return 1;
      }

    return fibonacci(number-1) + fibonacci(number -2); //tail recursion
  }

  /* * Java program to calculate Fibonacci number using loop or Iteration. * @return Fibonacci number */
  public static int fibonacci2(int number){
    if(number == 1 || number == 2){ return 1; }
    int fibo1=1, fibo2=1, fibonacci=1;
    for(int i= 3; i<= number; i++){
      //Fibonacci number is sum of previous two Fibonacci number
      fibonacci = fibo1 + fibo2; fibo1 = fibo2; fibo2 = fibonacci;
    }
    return fibonacci; //Fibonacci number
  }

}
