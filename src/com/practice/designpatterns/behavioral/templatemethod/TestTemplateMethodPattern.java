package com.practice.designpatterns.behavioral.templatemethod;
/*

Let’s understand this pattern with an example, suppose we want to provide an algorithm to build a house.
The steps need to be performed to build a house are – building foundation, building pillars, building walls and windows.
The important point is that the we can’t change the order of execution because we can’t build windows before building the foundation.
So in this case we can create a template method that will use different methods to build the house.

Now building the foundation for a house is same for all type of houses, whether its a wooden house or a glass house.
So we can provide base implementation for this, if subclasses want to override this method, they can but mostly it’s common for all the types of houses.

To make sure that subclasses don’t override the template method, we should make it final.


 */
public class TestTemplateMethodPattern {

  public static void main(String[] args) {

    HouseTemplate houseType = new WoodenHouse();

    //using template method
    houseType.buildHouse();
    System.out.println("************");

    houseType = new GlassHouse();

    houseType.buildHouse();
  }

}
