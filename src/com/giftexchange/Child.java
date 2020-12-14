package com.giftexchange;

/**
 * This class of name Child creates a Child object, with a default no-arg constructor, a custom
 * constructor, a toString method, and getters and setters for the locally initialized variables. -
 * Written by Garhett
 */
public class Child extends Person {
  // Create local String variable - Written by Garhett
  String presentTheyWant = "";

  /** No-arg constructor for the Child class - Written by Garhett */
  public Child() {
    super();
    presentTheyWant = "Gee, I don't know.";
  }

  /**
   * Custom constructor for the Child class to define items for the custom child object. - Written
   * by Garhett
   *
   * @param name
   * @param gender
   * @param age
   * @param presentTheyWant
   */
  public Child(String name, String gender, int age, String presentTheyWant) {
    super(name, gender, age);
    this.presentTheyWant = presentTheyWant;
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
  public String getPresentTheyWant() {
    return presentTheyWant;
  }

  /**
   * The setter for the local itemsTheyLike variable - Written by Garhett
   *
   * @param presentTheyWant
   */
  public void setPresentTheyWant(String presentTheyWant) {
    this.presentTheyWant = presentTheyWant;
  }
}
