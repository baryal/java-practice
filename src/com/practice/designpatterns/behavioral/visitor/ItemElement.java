package com.practice.designpatterns.behavioral.visitor;

public interface ItemElement {

  public int accept(ShoppingCartVisitor visitor);
}
