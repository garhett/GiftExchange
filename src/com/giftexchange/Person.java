package com.giftexchange;

/**
 * This is the Parent class for the Adult and Child class, it is called Person.
 * This class contains:
 * Private nameString, genderString, and int age.
 * Public nameString, genderString, and int age.
 * toString method
 * And all the getters and setters for Name, Gender, Age.
 */

/**
 * This is the private name, gender, and age class
 */
public class Person {
  private String name = "";
  private String gender = "";
  private int age = 0;

  public Person() {}

  /**
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
   * This is the toString method for persons
   * @return
   */
  public String toString() {
    return "";
  }

  /**\
   * This is the getter and setter for name, gender, and age
   * @return
   */

  /**
   * Gettig for name
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for name
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for gender
   * @return
   */
  public String getGender() {
    return gender;
  }

  /**
   * Setter for gender
   * @param gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * Getter for age
   * @return
   */
  public int getAge() {
    return age;
  }

  /**
   * setter for age
   * @param age
   */
  public void setAge(int age) {
    this.age = age;
  }
}
