package com.giftexchange;

import java.util.ArrayList;

/**
 * This class of name Child creates a Child object, with a default no-arg constructor, a custom
 * constructor, a toString method, and getters and setters for the locally initialized variables. -
 * Written by Garhett
 */
public class Child extends Person {
  // Create local list variable called itemsTheyLike - Written by Garhett
  ArrayList<String> itemsTheyLike = new ArrayList<>();

  /** No-arg constructor for the Child class - Written by Garhett */
  public Child() {
    super();
    itemsTheyLike.add("");
  }

  /**
   * Custom constructor for the Child class to define items for the custom child object. - Written
   * by Garhett
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
   * The local class toString method - Written by Garhett
   *
   * @return
   */
  public String toString() {
    return ""; // TODO Placeholder, create actual toString code in final program build.
  }

  /**
   * The getter for the local itemsTheyLike variable - Written by Garhett
   *
   * @return
   */
  public ArrayList<String> getItemsTheyLike() {
    return itemsTheyLike;
  }

  /**
   * The setter for the local itemsTheyLike variable - Written by Garhett
   *
   * @param itemsTheyLike
   */
  public void setItemsTheyLike(ArrayList<String> itemsTheyLike) {
    this.itemsTheyLike = itemsTheyLike;
  }
}
