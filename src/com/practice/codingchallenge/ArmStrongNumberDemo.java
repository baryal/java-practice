package com.practice.codingchallenge;
// A positive integer is called an Armstrong number of order n if
// abcd... = an + bn + cn + dn + ...
// In case of an Armstrong number of 3 digits, the sum of cubes of each digits is equal to the number itself. For example:

// 153 = 1*1*1 + 5*5*5 + 3*3*3  // 153 is an Armstrong number.

import java.util.Scanner;

public class ArmStrongNumberDemo {

  public static void main(String args[]){

    System.out.println("Please Enter a number : ");
    int armStrongNumber = new Scanner(System.in).nextInt();

    if(isArmStrongNumber(armStrongNumber))
      System.out.println(armStrongNumber + " is an Armstrong number");
    else
      System.out.println(armStrongNumber + " is not an Armstrong number");

  }

  public static boolean isArmStrongNumber(int number) {
    int armStrongNumber = number;
    int temp;
    int total = 0;

    while (armStrongNumber != 0)
    {
      temp = armStrongNumber % 10;
      total = total + temp*temp*temp;
      armStrongNumber = armStrongNumber/10;
    }

    return total == number;
  }
}
