package com.practice.designpatterns.creational.abstractfactory;

import com.practice.designpatterns.creational.factory.Computer;

public class ComputerFactory {

  public static Computer getComputer(ComputerAbstractFactory factory){
    return factory.createComputer();
  }

}
