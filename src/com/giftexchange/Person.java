package com.giftexchange;

/**
 * This is the Parent class for the Adult and Child class, it is called Person. This class contains:
 * Private nameString, genderString, and int age. Public nameString, genderString, and int age.
 * toString method And all the getters and setters for Name, Gender, Age.  - Written by Alissa
 */

/** This is the private name, gender, and age class - Written by Alissa */
public class Person {
  private String name = "";
  private String gender = "";
  private int age = 0;

  /** No arg-constructor for Person class - Written by Alissa */
  public Person() {}

  /**
   * Custom constructor for the Person class to define items for the custom persons object. -
   * Written by Alissa
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
   * This is the toString method for persons - Written by Alissa
   *
   * @return
   */
  public String toString() {
    return ""; // TODO Placeholder, create actual toString code in final program build.
  }

  /**
   * This is the getter and setter for name, gender, and age - Written by Alissa
   *
   * @return
   */

  /**
   * Gettig for name - Written by Alissa
   *
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for name - Written by Alissa
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for gender - Written by Alissa
   *
   * @return
   */
  public String getGender() {
    return gender;
  }

  /**
   * Setter for gender - Written by Alissa
   *
   * @param gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * Getter for age - Written by Alissa
   *
   * @return
   */
  public int getAge() {
    return age;
  }

  /**
   * setter for age - Written by Alissa
   *
   * @param age
   */
  public void setAge(int age) {
    this.age = age;
  }
}
