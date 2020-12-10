package com.giftexchange;

import java.util.ArrayList;

/**
 * This class of name Child creates a Child object, with a default no-arg constructor, a custom
 * constructor, a toString method, and getters and setters for the locally initialized variables.
 */
public class Child extends Person {
  ArrayList<String> itemsTheyLike = new ArrayList<>();

  /** No-arg constructor for the Child class */
  public Child() {
    super();
    itemsTheyLike.set(0, "");
  }

  /**
   * Custom constructor for the Child class to define items for the custom child object.
   *
   * @param name
   * @param gender
   * @param age
   * @param itemsTheyLike
   */
  public Child(String name, String gender, int age, ArrayList<String> itemsTheyLike) {
    super(name, gender, age);
    this.itemsTheyLike = itemsTheyLike;
  }

 /**
   * The local class toString method
   *
   * @return
   */
  public String toString() {
    return "";
  }

  /**
   * The getter for the local itemsTheyLike variable
   *
   * @return
   */
  public ArrayList<String> getItemsTheyLike() {
    return itemsTheyLike;
  }

  /**
   * The setter for the local itemsTheyLike variable
   *
   * @param itemsTheyLike
   */
  public void setItemsTheyLike(ArrayList<String> itemsTheyLike) {
    this.itemsTheyLike = itemsTheyLike;
  }
}
