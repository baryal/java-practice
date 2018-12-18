package com.practice.designpatterns.structural.composite;
/*
Composite pattern is a partitioning design pattern and describes a group of objects that is treated the same way as a single instance of the same type of object.
The intent of a composite is to “compose” objects into tree structures to represent part-whole hierarchies. It allows you to have a tree structure and ask each node in the tree structure to perform a task.

As described by Gof, “Compose objects into tree structure to represent part-whole hierarchies. Composite lets client treat individual objects and compositions of objects uniformly”.
When dealing with Tree-structured data, programmers often have to discriminate between a leaf-node and a branch. This makes code more complex, and therefore, error prone.
The solution is an interface that allows treating complex and primitive objects uniformly.
In object-oriented programming, a composite is an object designed as a composition of one-or-more similar objects, all exhibiting similar functionality. This is known as a “has-a” relationship between objects.
The key concept is that you can manipulate a single instance of the object just as you would manipulate a group of them. The operations you can perform on all the composite objects often have a least common denominator relationship.
The Composite Pattern has four participants:

Component – Component declares the interface for objects in the composition and for accessing and managing its child components. It also implements default behavior for the interface common to all classes as appropriate.
Leaf – Leaf defines behavior for primitive objects in the composition. It represents leaf objects in the composition.
Composite – Composite stores child components and implements child related operations in the component interface.
Client – Client manipulates the objects in the composition through the component interface.
Client use the component class interface to interact with objects in the composition structure. If recipient is a leaf then request is handled directly. If recipient is a composite, then it usually forwards request to its child components, possibly performing additional operations before and after forwarding.

Real Life example

In an organization, It has general managers and under general managers, there can be managers and under managers there can be developers.
Now you can set a tree structure and ask each node to perform common operation like getSalary().
Composite design pattern treats each node in two ways:
1) Composite(Node) – Composite means it can have other objects below it.
2) leaf – leaf means it has no objects below it.
 */
public class TestCompositePattern {

  public static void main (String[] args)
  {
    Developer dev1 = new Developer(100, "Lokesh Sharma", "Pro Developer");
    Developer dev2 = new Developer(101, "Vinay Sharma", "Developer");
    CompanyDirectory engDirectory = new CompanyDirectory();
    engDirectory.addEmployee(dev1);
    engDirectory.addEmployee(dev2);

    Manager man1 = new Manager(200, "Kushagra Garg", "SEO Manager");
    Manager man2 = new Manager(201, "Vikram Sharma ", "Kushagra's Manager");

    CompanyDirectory accDirectory = new CompanyDirectory();
    accDirectory.addEmployee(man1);
    accDirectory.addEmployee(man2);

    CompanyDirectory directory = new CompanyDirectory();
    directory.addEmployee(engDirectory);
    directory.addEmployee(accDirectory);
    directory.showEmployeeDetails();
  }
}
