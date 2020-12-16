package com.giftexchange;

/**
 * This is the adult class. It is here to create an adult object. This class contains a no-arg con
 * and a custom con. And a toString method and the getter and setters for people they dislike. -
 * Written by Alissa
 */
public class Adult extends Person {
  // Created the local list of the people they dislike - Written by Alissa
 private String blacklistedPerson = "";

  /** This is the no arg con for the adult class - Written by Alissa */
  public Adult() {
    super();
    blacklistedPerson = "Well, I love my whole family equally.";
  }

  /**
   * This is the custom con for the Adult class - Written by Alissa
   *
   * @param name
   * @param gender
   * @param age
   * @param blacklistedPerson
   */
  public Adult(String name, String gender, int age, String blacklistedPerson) {
    super(name, gender, age);
    this.blacklistedPerson = blacklistedPerson;
  }

  /**
   * This is the ToString method for the Adult class. - Written by Alissa
   *
   * @return
   */
  public String toString() {
    return ""; // TODO Placeholder, create actual toString code in final program build.
  }

  /**
   * This is the getter for people the dislike for the adult class. - Written by Alissa
   *
   * @return
   */
  public String getBlacklistedPerson() {
    return blacklistedPerson;
  }

  /**
   * This is the setter for people they dislike for the Adult class. - Written by Alissa
   *
   * @param blacklistedPerson
   */
  public void setBlacklistedPerson(String blacklistedPerson) {
    this.blacklistedPerson = blacklistedPerson;
  }
}
