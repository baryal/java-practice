package com.practice.designpatterns.creational.abstractfactory;

import com.practice.designpatterns.creational.factory.Computer;
import com.practice.designpatterns.creational.factory.PC;

public class PCFactory implements ComputerAbstractFactory{

  private String ram;
  private String hdd;
  private String cpu;

  public PCFactory(String ram, String hdd, String cpu){
    this.ram=ram;
    this.hdd=hdd;
    this.cpu=cpu;
  }
  @Override
  public Computer createComputer() {
    return new PC(ram,hdd,cpu);
  }
}
