package com.giftexchange;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Name: Garhett Anderson & Alissa Corona. Course: CIT-260. File(s): GiftExchangeBuilder.java,
 * Child.java, Adult.java, Person.java. Date: 12/9/2020. About: This program enables the user to
 * input each of their family members to get a back a randomized report of a gift exchange among
 * each of the members of the list to then pass out to all family members prior to having the
 * Christmas party. This program also saves the list of family members so it can be used again in
 * the future when the program is reopened. Status: IN-PROGRESS. - Javadoc Written by Garhett
 */
public class GiftExchangeBuilder {
  static ArrayList<Person> childList = new ArrayList<>();
  static ArrayList<Person> childList2 = new ArrayList<>();

  static ArrayList<Adult> adultList = new ArrayList<>();
  static ArrayList<Adult> adultList2 = new ArrayList<>();

  public static void main(String[] args) throws FileNotFoundException {

    //            catch exceptions if user enters a letter instead of and number for age.
    //          // Generate random list for adult
    //        Random generate = new Random();
    //        String[] Adult= {};
    //        System.out.println("Adult List:  " +  Adult;[generate.nextInt()];
    //
    //          // Generate random list for child
    //        Random generate = new Random();
    //        String[] Child = {};
    //        System.out.println("Child List:  " +  Child;[generate.nextInt()];

    /* Use above commented out code for help with code below */

    Scanner in = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    String adultListLocalFile = "Adult_List.txt";
    String childListLocalFile = "Child_List.txt";

    /* Below methods is used for testing purposes ONLY.
    Uncomment these methods and answer "0" to family member total input to start testing. */
    createAdultTestObjects();
    createChildTestObjects();

    System.out.println("WELCOME TO THE GIFT EXCHANGE BUILDER!\n");
    System.out.println(
        "Family gift exchanges are a holiday tradition in many families.\nThe user will have the ability to generate a random report if they need to \ncreate a new gift exchange list for this year.\n");
    System.out.print("How many family members would you like to add to a gift exchange report?: ");
    final int FAMILY_MEMBER_COUNT = in.nextInt();
    for (int i = 0; i < FAMILY_MEMBER_COUNT; i++) {
      in.nextLine();
      int y = i + 1;
      System.out.println("\nFamily member #" + y + "\n_______________");
      System.out.print("Enter a name: ");
      String name = in.nextLine();
      System.out.print("Enter " + name + "'s gender: ");
      String gender = in.nextLine();
      System.out.print("Enter " + name + "'s age: ");
      int age = in.nextInt();
      if (age < 18) {
        System.out.print("Enter a present " + name + " wants for Christmas: ");
        String presentTheyWant = scanner.nextLine();
        childList.add(new Child(name, gender, age, presentTheyWant));
      } else {
        System.out.print("Does " + name + " dislike anyone in the family? (yes or no): ");
        String doTheyDislikeAnyone = scanner.nextLine();
        String blacklistedPerson = "None";
        if (doTheyDislikeAnyone.equalsIgnoreCase("Yes")) {
          System.out.print(
              "Enter name of disliked adult that will be on this gift exchange list. (This person will NOT exchange gifts with "
                  + name
                  + ".): ");
          blacklistedPerson = scanner.nextLine();
        }
        adultList.add(new Adult(name, gender, age, blacklistedPerson));
      }
    }

    try (PrintWriter fileInput = new PrintWriter(childListLocalFile)) {
      for (Person j : childList) {
        fileInput.println(j);
      }
    }
    try (PrintWriter fileInput = new PrintWriter(adultListLocalFile)) {
      for (Person j : adultList) {
        fileInput.println(j);
      }
    }
    // Allow for better UX to signify the file writing process was successful
    System.out.println("\nSaving... COMPLETE");

    childList2 = (ArrayList<Person>) childList.clone();
    Collections.shuffle(childList);
    Collections.shuffle(childList2);
    for (int i = 0; i < childList.toArray().length; i++) {
      // TODO add if to make sure a person doesn't give to themselves, then put line below in else
      System.out.println(childList.get(i) + "   GIVES TO    " + childList2.get(i));
    }

    // New line for better formatting
    System.out.println();

    adultList2 = (ArrayList<Adult>) adultList.clone();
    Collections.shuffle(adultList);
    Collections.shuffle(adultList2);
    for (int i = 0; i < adultList.toArray().length; i++) {
      String adultsBlacklistedPerson = adultList.get(i).getBlacklistedPerson();
      String adultsName = adultList2.get(i).getName();
      if (adultsBlacklistedPerson.equalsIgnoreCase(adultsName)) {
        adultList2.subList(i, adultList2.toArray().length - 1);
        // TODO add else/if to make sure a person doesn't give to themselves
      } else {
        System.out.println(adultList.get(i) + "   GIVES TO    " + adultList2.get(i));
      }
    }
  }

  /**
   * Method is used for testing purposes only to bypass the lengthy object-creation process that
   * will take place in the final build of the program. Uncomment method's reference in main to use,
   * and make sure to answer "0" to number of family members to input for most accurate testing.
   */
  public static void createChildTestObjects() {
    childList.add(new Child("Fred", "male", 11, "yoyo"));
    childList.add(new Child("Tim", "male", 10, "cars"));
    childList.add(new Child("Ally", "female", 9, "dolls"));
    childList.add(new Child("Jake", "male", 15, "playdoe"));
    childList.add(new Child("Timmy", "male", 5, "basketball"));
    childList.add(new Child("Lexy", "female", 13, "bike"));
    childList.add(new Child("Darin", "male", 17, "monster truck"));
  }

  /**
   * Method is used for testing purposes only to bypass the lengthy object-creation process that
   * will take place in the final build of the program. Uncomment method's reference in main to use,
   * and make sure to answer "0" to number of family members to input for most accurate testing.
   */
  public static void createAdultTestObjects() {
    adultList.add(new Adult("Sally", "female", 34, "None"));
    adultList.add(new Adult("Jill", "female", 65, "None"));
    adultList.add(new Adult("Sam", "male", 61, "Ivy"));
    adultList.add(new Adult("Bob", "male", 43, "None"));
    adultList.add(new Adult("Ivy", "female", 21, "Sally"));
    adultList.add(new Adult("Oscar", "male", 65, "None"));
    adultList.add(new Adult("Susan", "female", 34, "None"));
    adultList.add(new Adult("Oliver", "male", 76, "Oscar"));
    adultList.add(new Adult("Rosanne", "female", 18, "Susan"));
    adultList.add(new Adult("Lucy", "female", 50, "None"));
  }
}
