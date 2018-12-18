package com.practice.codingchallenge;
// palindrome number is a number which is equal to reverse of itself.
// For example 121 is a palindrome because reverse of 121 is 121, while 123 is not a palindrome in Java because reverse of 123 is 321 and 121!=321.
// https://medium.com/@randerson112358/palindrome-program-explained-510fd952baa

import java.util.Scanner;

public class PalindromeDemo {

  public static void main(String args[]){

    System.out.println("Please Enter a number : ");
    int palindrome = new Scanner(System.in).nextInt();

    if(isPalindrome(palindrome)){
      System.out.println("Number : " + palindrome + " is a palindrome");
    }else{
      System.out.println("Number : " + palindrome + " is not a palindrome");
    }

  }

  /*
   * Java method to check if number is palindrome or not
   */
  public static boolean isPalindrome(int number) {
    int palindrome = number; // copied number into variable
    int reverse = 0;

    while (palindrome != 0) {
      int remainder = palindrome % 10;
      reverse = reverse * 10 + remainder;
      palindrome = palindrome / 10; // to run the loop
    }

    // if original and reverse of number is equal means
    // number is palindrome in Java
    if (number == reverse) {
      return true;
    }
    return false;
  }
}
