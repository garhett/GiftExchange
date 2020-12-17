package com.giftexchange;

/**
 * This is the Parent class for the Adult and Child class, it is called Person. This class contains:
 * Private nameString, genderString, and int age. Public nameString, genderString, and int age.
 * toString method And all the getters and setters for Name, Gender, Age. - Written during pair
 * programming.
 */

/** This is the private name, gender, and age class - Written during pair programming. */
public class Person {
  private String name = "";
  private String gender = "";
  private int age = 0;

  /** No arg-constructor for Person class - Written during pair programming. */
  public Person() {}

  /**
   * Custom constructor for the Person class to define items for the custom persons object. -
   * Written during pair programming.
   *
   * @param name
   * @param gender
   * @param age
   */
  public Person(String name, String gender, int age) {
    this.name = name;
    this.gender = gender;
    this.age = age;
  }

  /**
   * This is the toString method for persons - Written during pair programming.
   *
   * @return
   */
  public String toString() {
    // This returns the name, gender, and age in a simple format, but insures that name and gender
    // are capitalized.
    return name.substring(0, 1).toUpperCase()
        + name.substring(1)
        + ": ("
        + gender.substring(0, 1).toUpperCase()
        + gender.substring(1)
        + ", "
        + age
        + ")";
  }

  /**
   * Getting for name - Written during pair programming.
   *
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for name for person class - Written during pair programming.
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for gender for person class - Written during pair programming.
   *
   * @return
   */
  public String getGender() {
    return gender;
  }

  /**
   * Setter for gender for person class - Written during pair programming.
   *
   * @param gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * Getter for age for person class - Written during pair programming.
   *
   * @return
   */
  public int getAge() {
    return age;
  }

  /**
   * Setter for age for person class - Written during pair programming.
   *
   * @param age
   */
  public void setAge(int age) {
    this.age = age;
  }
}
