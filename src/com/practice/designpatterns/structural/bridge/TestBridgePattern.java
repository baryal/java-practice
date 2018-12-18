package com.practice.designpatterns.structural.bridge;
/*
“Decouple an abstraction from its implementation so that the two can vary independently” is the intent for bridge design pattern as stated by GoF.
Bridge design pattern is a modified version of the notion of “prefer composition over inheritance”
 */
public class TestBridgePattern {

  public static void main(String[] args)
  {
    Vehicle vehicle1 = new Car(new Produce(), new Assemble());
    vehicle1.manufacture();
    Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
    vehicle2.manufacture();
  }
}
