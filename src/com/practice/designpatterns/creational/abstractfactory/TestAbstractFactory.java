package com.practice.designpatterns.creational.abstractfactory;

import com.practice.designpatterns.creational.factory.Computer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
In the Abstract Factory pattern, we get rid of if-else block of factory pattern and have a factory class for each sub-class.
Then an Abstract Factory class that will return the sub-class based on the input factory class.

-First of all we need to create a Abstract Factory interface or abstract class.
- factory classes will implement this interface and return their respective sub-class.
-create a consumer class that will provide the entry point for the client classes to create sub-classes.

Abstract Factory Design Pattern Benefits
-Abstract Factory design pattern provides approach to code for interface rather than implementation.
-Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products,
 for example we can add another sub-class Laptop and a factory LaptopFactory.
-Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.

Abstract Factory Design Pattern Examples in JDK
-javax.xml.parsers.DocumentBuilderFactory#newInstance()
-javax.xml.transform.TransformerFactory#newInstance()
-javax.xml.xpath.XPathFactory#newInstance()
 */
public class TestAbstractFactory {

  public static void main(String[] args) throws IOException {
    testAbstractFactory();
  }

  private static void testAbstractFactory() throws IOException{
    Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
    Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
    System.out.println("AbstractFactory PC Config::"+pc);
    System.out.println("AbstractFactory Server Config::"+server);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter loan type: ");
    String loanType = br.readLine();

    System.out.println("Enter loan amount: ");
    double loanAmount=Double.parseDouble(br.readLine());

    System.out.println("Enter pay back period in years: ");
    int years=Integer.parseInt(br.readLine());
    LoanFactory.getLoan(LoanFactory.getLoanAbstractFactory(loanType))
    .calculateLoanPayment(loanAmount, years);
  }
}
