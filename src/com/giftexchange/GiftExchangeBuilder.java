package com.giftexchange;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
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
  static ArrayList<Child> childList = new ArrayList<>();
  static ArrayList<Child> childList2 = new ArrayList<>();

  static ArrayList<Adult> adultList = new ArrayList<>();
  static ArrayList<Adult> adultList2 = new ArrayList<>();

  static String adultListLocalFile = "Adult_List.txt";
  static String childListLocalFile = "Child_List.txt";

  public static void main(String[] args) throws FileNotFoundException {
    // TODO make sure to look at instructors feedback on last week's assignment to know of
    // everything that we need to have for our program. Then look at assignment requirement so we
    // don't miss anything there either.

    Scanner in = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);

    File adultFile = new File(adultListLocalFile);
    File childFile = new File(childListLocalFile);

    boolean isListDeletedAndNewListCreated = false;

    System.out.println("\nWELCOME TO THE GIFT EXCHANGE BUILDER!\n");

    if (adultFile.exists() && childFile.exists()) {
      System.out.println("Adult_List.txt and Child_List.txt files detected!");
      System.out.print(
          "Do you want to create a gift exchange report of the current lists,\nor delete the lists and start over? (a = create report. b = delete lists): ");
      String response = in.nextLine();
      if (response.equalsIgnoreCase("a")) {
        // Read in Adult data and create new child objects to create gift exchange report
        try (Scanner inFromChildFile = new Scanner(childFile)) {
          while (inFromChildFile.hasNextLine()) {
            String name = inFromChildFile.next().trim();
            String gender = inFromChildFile.next().trim();
            int age = inFromChildFile.nextInt();
            String presentTheyWant = inFromChildFile.nextLine().trim();
            childList.add(new Child(name, gender, age, presentTheyWant));
          }
        }
        // Read in Adult data and create new child objects to create gift exchange report
        try (Scanner inFromAdultFile = new Scanner(adultFile)) {
          while (inFromAdultFile.hasNextLine()) {
            String name = inFromAdultFile.next().trim();
            String gender = inFromAdultFile.next().trim();
            int age = inFromAdultFile.nextInt();
            String blacklistedPerson = inFromAdultFile.nextLine().trim();
            adultList.add(new Adult(name, gender, age, blacklistedPerson));
          }
        }
        createExchangeReportAndSaveToFile();
        System.exit(0);
      } else if (response.equalsIgnoreCase("b")) {
        isListDeletedAndNewListCreated = true;
        adultFile.delete();
        childFile.delete();
      }
    }

    /* Below methods are used for test purposes ONLY.
    Uncomment these methods and answer "0" to family member total input to start testing. */
    //    createAdultTestObjects();
    //    createChildTestObjects();
    /* End test case methods */

    // TODO don't allow a gift exchange less than 2 people.
    if (!isListDeletedAndNewListCreated) {
      System.out.println(
          "Family gift exchanges are a holiday tradition in many families.\nThe user will have the ability to generate a random report if they need to \ncreate a new gift exchange list for this year.\n");
    }
    if (isListDeletedAndNewListCreated) {
      System.out.println();
    }
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
      int age = 0;
      boolean isAgeProblem = false;
      do {
        isAgeProblem = false;
        System.out.print("Enter " + name + "'s age: ");
        try {
          age = in.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("Error: Please enter a number");
          isAgeProblem = true;
          in.nextLine();
        }
      } while (isAgeProblem);
      if (age < 18) {
        System.out.print("Enter a present " + name + " wants for Christmas: ");
        String presentTheyWant = scanner.nextLine();
        childList.add(new Child(name, gender, age, presentTheyWant));
      } else {
        System.out.print("Does " + name + " dislike anyone in the family? (yes or no): ");
        String doTheyDislikeAnyone = scanner.nextLine();
        String blacklistedPerson = "Nobody";
        if (doTheyDislikeAnyone.equalsIgnoreCase("Yes")) {
          System.out.print(
              "Enter name of disliked adult. (This person will NOT receive a gift from "
                  + name
                  + ".): ");
          blacklistedPerson = scanner.nextLine();
        }
        adultList.add(new Adult(name, gender, age, blacklistedPerson));
      }
    }
    createExchangeReportAndSaveToFile();
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
    adultList.add(new Adult("Sally", "female", 34, "nobody"));
    adultList.add(new Adult("Jill", "female", 65, "nobody"));
    adultList.add(new Adult("Sam", "male", 61, "Ivy"));
    adultList.add(new Adult("Bob", "male", 43, "nobody"));
    adultList.add(new Adult("Ivy", "female", 21, "Sally"));
    adultList.add(new Adult("Oscar", "male", 65, "nobody"));
    adultList.add(new Adult("Susan", "female", 34, "nobody"));
    adultList.add(new Adult("Oliver", "male", 76, "Oscar"));
    adultList.add(new Adult("Rosanne", "female", 18, "Susan"));
    adultList.add(new Adult("Lucy", "female", 50, "nobody"));
  }

  public static void createExchangeReportAndSaveToFile() throws FileNotFoundException {
    childList2 = (ArrayList<Child>) childList.clone();
    Collections.shuffle(childList);
    Collections.shuffle(childList2);
    System.out.println("\n***CHILDREN'S GIFT EXCHANGE***");
    for (int i = 0; i < childList.toArray().length; i++) {
      String child1 = childList.get(i).getName();
      String child2 = childList2.get(i).getName();
      if (child1.equalsIgnoreCase(child2)) {
        Child item = childList2.get(i);
        childList2.remove(i);
        childList2.add(item);
      }
      System.out.printf("%-50s %-10s %s%n", childList.get(i), "GIVES TO", childList2.get(i));
    }

    // New line for better formatting
    System.out.println("***END OF CHILDREN'S GIFT EXCHANGE***\n");

    adultList2 = (ArrayList<Adult>) adultList.clone();
    Collections.shuffle(adultList);
    Collections.shuffle(adultList2);
    System.out.println("***ADULT'S GIFT EXCHANGE***");
    for (int i = 0; i < adultList.toArray().length; i++) {
      String adultsBlacklistedPerson = adultList.get(i).getBlacklistedPerson();
      String adultsName = adultList2.get(i).getName();
      // If person gets blacklisted person, or if they get themselves, send the second list item to
      // the end of the list
      if (adultsBlacklistedPerson.equalsIgnoreCase(adultsName)
          || adultList.get(i).getName().equalsIgnoreCase(adultList2.get(i).getName())) {
        Adult item = adultList2.get(i);
        adultList2.remove(i);
        adultList2.add(item);
      }
      System.out.printf("%-50s %-10s %s%n", adultList.get(i), "GIVES TO", adultList2.get(i));
    }
    System.out.println("***END OF ADULT'S GIFT EXCHANGE***");

    try (PrintWriter fileInput = new PrintWriter(childListLocalFile)) {
      for (int i = 0; i < childList.toArray().length; i++) {
        fileInput.print(childList.get(i).getName() + " ");
        fileInput.print(childList.get(i).getGender() + " ");
        fileInput.print(childList.get(i).getAge() + " ");
        fileInput.println(childList.get(i).getPresentTheyWant());
      }
    }
    try (PrintWriter fileInput = new PrintWriter(adultListLocalFile)) {
      for (int i = 0; i < adultList.toArray().length; i++) {
        fileInput.print(adultList.get(i).getName() + " ");
        fileInput.print(adultList.get(i).getGender() + " ");
        fileInput.print(adultList.get(i).getAge() + " ");
        fileInput.println(adultList.get(i).getBlacklistedPerson());
      }
    }
    // Allow for better UX to signify the file writing process was successful
    System.out.println("\nSaving list of children to Child_List.txt... COMPLETE");
    System.out.println("Saving list of adults to Adult_List.txt... COMPLETE");
    System.out.println("\nMERRY CHRISTMAS!");
  }
}
