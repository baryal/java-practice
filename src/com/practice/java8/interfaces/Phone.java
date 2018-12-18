package com.practice.java8.interfaces;
// A functional interface is an interface that contains only one abstract method
public interface Phone {
  // An abstract function
  void abstractFun(int x);
  // If you want to define a method in interface, you have to use default keyword.
  default void sendMessage(String message) {
    System.out.println(message);
  }

  static boolean isNull(String str) {
    System.out.println("Interface Null Check");
    return str == null ? true : "".equals(str) ? true : false;
  }
}
