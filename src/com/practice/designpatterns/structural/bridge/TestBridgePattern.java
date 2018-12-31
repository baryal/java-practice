package com.practice.designpatterns.structural.bridge;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
“Decouple an abstraction from its implementation so that the two can vary independently” is the intent for bridge design pattern as stated by GoF.
Bridge design pattern is a modified version of the notion of “prefer composition over inheritance”
 */
public class TestBridgePattern {

  public static void main(String[] args) {
    Vehicle vehicle1 = new Car(new Produce(), new Assemble());
    vehicle1.manufacture();
    Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
    vehicle2.manufacture();

    int x = 3 & 5;
    int y = 3 | 5;

    //System.out.println(x);
    //System.out.println(y);
    int k = 9;
    //doIt(6, 4, k);
    //System.out.println(k);

    int[] A = {1, 3, 2, 1, 6, 4};

    int missing = solution(A);

    int arr[] = {1, 3, 2, 1, 6, 4};
    int arr_size = arr.length;
    //int missing = findMissing(arr, arr_size);
    /*System.out.println("The smallest positive missing number is " +
                               missing);*/
    int B[] = {1, 2, 5, 9, 9};
    System.out.println(solution2(B, 5));
  }

  public static void doIt(int x, int y, int m) {
    if (x == 5) {
      m = y;
    } else {
      m = x;
    }
  }

  public static int solution(int[] A) {
    int smallInt = 1;
    SortedSet<Integer> sortedUniqueNumbers = new TreeSet<>();
    for (int value : A) {
      sortedUniqueNumbers.add(value);
    }

    //sortedUniqueNumbers.stream().forEach((n) -> System.out.println(n));

    while (sortedUniqueNumbers.contains(smallInt)) {
      smallInt++;
    }

    //int sumOfNaturalNumbers = sortedUniqueNumbers.last()* (sortedUniqueNumbers.last() + 1)/2;
    //System.out.println(sumOfNaturalNumbers);
    //int sum = sortedUniqueNumbers.stream().mapToInt((i)->i.intValue()).sum();
    //System.out.println(sum);
    //System.out.println(smallInt);

    return smallInt;
  }

  private static int solution2(int[] arr, int x) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
      int m = l + (r - l) / 2;

      // If x greater, ignore left half
      if (arr[m] < x)
        l = m + 1;

        // If x is smaller, ignore right half
      else
        r = m - 1;
    }

    // Check if x is present at mid
    if (arr[l] == x)
      return l;

    return -1;
  }
}
