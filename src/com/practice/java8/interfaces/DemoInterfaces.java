package com.practice.java8.interfaces;

public class DemoInterfaces {

  public static void main(String[] args) {
    Phone androidPhone = new AndroidPhone();
    androidPhone.sendMessage("Message From Android");
    Phone iPhone = new IPhone();
    iPhone.sendMessage("Message From Android");
    System.out.println("Testing static method " + Phone.isNull("ABC"));
    System.out.println("Testing static method " + Phone.isNull(null));

    Phone phone = (x) -> System.out.println(x*2);// Lambda expression, lambda expressions can be used to represent the instance of a functional interface
    phone.abstractFun(5);
  }
}
