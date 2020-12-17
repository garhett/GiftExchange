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

  // Create child lists
  static ArrayList<Child> childList = new ArrayList<>();
  static ArrayList<Child> childList2 = new ArrayList<>();

  // Create adult lists
  static ArrayList<Adult> adultList = new ArrayList<>();
  static ArrayList<Adult> adultList2 = new ArrayList<>();

  // Create variable for file save location.
  static String adultListLocalFile = "Adult_List.txt";
  static String childListLocalFile = "Child_List.txt";

  /**
   * Driver method - main
   *
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {

    /* TEST METHODS */
    // Uncomment these methods below and answer "0" to family member total input to start testing.
    //    createAdultTestObjects();
    //    createChildTestObjects();

    // everything that we need to have for our program. Then look at assignment requirement so we
    // don't miss anything there either.
    // import scanners
    Scanner in = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    File adultFile = new File(adultListLocalFile);
    File childFile = new File(childListLocalFile);

    // system out print the program and what it does
    boolean isListDeletedAndNewListCreated = false;

    // Welcome user to program.
    System.out.println("\nWELCOME TO THE GIFT EXCHANGE BUILDER!\n");

    if (adultFile.exists() && childFile.exists()) {

      // read text to file
      System.out.println("Adult_List.txt and Child_List.txt files detected!");
      System.out.print(
          // menu style with file. Either create report or delete file
          "Do you want to create a gift exchange report of the current lists,\nor delete the lists and start over? (a = create report. b = delete lists): ");
      String response = in.nextLine();

      // Catch if the user isn't entering an 'a' or 'b' for the response - Written by Garhett
      while (!response.equalsIgnoreCase("a") && !response.equalsIgnoreCase("b")) {
        System.out.println(
            "Error: Please enter 'a' to create a report, or 'b' to delete saved lists.");
        response = in.nextLine();
      }
      if (response.equalsIgnoreCase("a")) {

        // Read in Adult data and create new child objects to create gift exchange report
        // use a scanner to fine Childfile on computer and out print it - Written by Garhett
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
        // use a scanner to fine Adultfile on computer and out print it - Written by Garhett
        try (Scanner inFromAdultFile = new Scanner(adultFile)) {
          while (inFromAdultFile.hasNextLine()) {
            String name = inFromAdultFile.next().trim();
            String gender = inFromAdultFile.next().trim();
            int age = inFromAdultFile.nextInt();
            String blacklistedPerson = inFromAdultFile.nextLine().trim();
            adultList.add(new Adult(name, gender, age, blacklistedPerson));
          }
        }
        // if user enters b program will delete file from computer - Written by Garhett
        createExchangeReportAndSaveToFile();
        System.exit(0);
      } else if (response.equalsIgnoreCase("b")) {
        isListDeletedAndNewListCreated = true;
        adultFile.delete();
        childFile.delete();
      }
    }

    // Avoid introducing program to user again if we are coming from deleting the old list.
    if (!isListDeletedAndNewListCreated) {
      System.out.println(
          "Family gift exchanges are a holiday tradition in many families.\nThe user will have the ability to generate a random report if they need to \ncreate a new gift exchange list for this year.\n");
    }
    // Create new line for formatting purposes.
    if (isListDeletedAndNewListCreated) {
      System.out.println();
    }

    // Get the amount of family members from user
    System.out.print("How many family members would you like to add to a gift exchange report?: ");
    int familyMemberCount = in.nextInt();
    // Make sure family member amount is between 4 and 50 - Written by Alissa
    while (familyMemberCount > 50 || familyMemberCount < 4) {
      System.out.print(
          "Invalid Input: Group total must be 4 - 50 people. Please enter a new number: ");
      familyMemberCount = in.nextInt();
    }

    // User input for familyMemberCount
    // Goes through for loop as many times as there are family members as specified above.
    // Limit names 4-50
    for (int i = 0; i < familyMemberCount; i++) {

      // Flush buffer
      in.nextLine();

      // Better UX
      int y = i + 1;
      System.out.println("\nFamily member #" + y + "\n_______________");

      // Get user input for first name only. give error if last name is also entered.
      System.out.print("Enter First name only: ");
      String name = in.nextLine();
      // while loop for name- Written by Alissa */
      while (name.contains(" ")) {
        System.out.print(
            "Invalid Input: Last names are not allowed. Please enter First name only: ");
        name = in.nextLine();
      }

      // get user input of gener. Give error message if genders 'Male' or 'female' are not written
      System.out.print("Enter " + name + "'s gender: ");
      String gender = in.nextLine();
      // while loop for only male and female input - Written by Alissa
      while (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
        System.out.print("Invalid Input: Please enter either 'Male' or 'Female': ");
        gender = in.nextLine();
      }

      // get user input for age.
      // try and catch if letter is entered instead of int
      int age = 0;
      boolean isAgeProblem = false;
      // do while loop for gender- Written by Alissa
      do {
        isAgeProblem = false;
        System.out.print("Enter " + name + "'s age: ");
        // try and catch exception for age Written by- Alissa
        try {
          age = in.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("Error: Please enter a number");
          isAgeProblem = true;
          in.nextLine();
        }
      } while (isAgeProblem);

      // filter adult and child class by age
      // adults can black list
      // children can ask what they want for christmas - Written by Garhett
      if (age < 18) {
        System.out.print("Enter a present " + name + " wants for Christmas: ");
        String presentTheyWant = scanner.nextLine();
        // Create child object based upon variables
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
        // Create adult object based upon variables
        adultList.add(new Adult(name, gender, age, blacklistedPerson));
      }
    }
    // Fire method that takes care of creating the randomized report and saving each report to the
    // file location
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

  // TODO finish javadoc and comments.
  public static void createExchangeReportAndSaveToFile() throws FileNotFoundException {
    // Import scanner for user later in the method
    Scanner in = new Scanner(System.in);

    // Clones one list and assigns it to the other to be shuffled, thus creating a "random" report.
    childList2 = (ArrayList<Child>) childList.clone();
    Collections.shuffle(childList);
    Collections.shuffle(childList2);
    // Introduce the list name
    System.out.println("\n***CHILDREN'S GIFT EXCHANGE***");
    // Go through the for loop of both lists at the same index, and then make sure someone isn't
    // getting themselves for the gift exchange. If they do, then the object is deleted from the
    // index spot, moved to the last index of the list, and the list continues on.
    for (int i = 0; i < childList.toArray().length; i++) {
      String child1 = childList.get(i).getName();
      String child2 = childList2.get(i).getName();
      if (child1.equalsIgnoreCase(child2)) {
        Child item = childList2.get(i);
        childList2.remove(i);
        childList2.add(item);
      }
      // Print out an easy-to-read report for the user.
      System.out.printf("%-50s %-10s %s%n", childList.get(i), "GIVES TO", childList2.get(i));
    }
    System.out.println("***END OF CHILDREN'S GIFT EXCHANGE***\n");

    // Clones one list and assigns it to the other to be shuffled, thus creating a "random" report.
    adultList2 = (ArrayList<Adult>) adultList.clone();
    Collections.shuffle(adultList);
    Collections.shuffle(adultList2);
    // Introduce the list name
    System.out.println("***ADULT'S GIFT EXCHANGE***");
    // Go through the for loop of both lists at the same index, and then make sure someone isn't
    // getting themselves or their blacklisted person for the gift exchange. If they do, then the
    // object is deleted from the index spot, moved to the last index of the list, and the list
    // continues on.
    for (int i = 0; i < adultList.toArray().length; i++) {
      String adultsBlacklistedPerson = adultList.get(i).getBlacklistedPerson();
      String adultsName = adultList2.get(i).getName();
      if (adultsBlacklistedPerson.equalsIgnoreCase(adultsName)
          || adultList.get(i).getName().equalsIgnoreCase(adultList2.get(i).getName())) {
        Adult item = adultList2.get(i);
        adultList2.remove(i);
        adultList2.add(item);
      }
      // Print out an easy-to-read report for the user.
      System.out.printf("%-50s %-10s %s%n", adultList.get(i), "GIVES TO", adultList2.get(i));
    }
    System.out.println("***END OF ADULT'S GIFT EXCHANGE***");

    // Create PrintWriter object to be used to assign all characteristics of the object to one line
    // of a txt file. This text file will be used later on for loading the report back into the
    // program.
    try (PrintWriter fileInput = new PrintWriter(childListLocalFile)) {
      for (int i = 0; i < childList.toArray().length; i++) {
        fileInput.print(childList.get(i).getName() + " ");
        fileInput.print(childList.get(i).getGender() + " ");
        fileInput.print(childList.get(i).getAge() + " ");
        fileInput.println(childList.get(i).getPresentTheyWant());
      }
    }
    // Create PrintWriter object to be used to assign all characteristics of the object to one line
    // of a txt file. This text file will be used later on for loading the report back into the
    // program.
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

    // Give option to redo the list
    System.out.print("\nDo you like how the list turned out? (yes or no): ");
    String wantToRedoList = in.nextLine();
    // Catch bad input from the user - Written by Garhett
    while (!wantToRedoList.equalsIgnoreCase("yes") && !wantToRedoList.equalsIgnoreCase("no")) {
      System.out.print("Error: invalid input, please enter 'yes' or 'no': ");
      wantToRedoList = in.nextLine();
    }
    // Generated new list if they don't like the old list.
    if (wantToRedoList.equalsIgnoreCase("no")) {
      System.out.println("\n-GENERATING NEW LIST-");
      createExchangeReportAndSaveToFile();
      // If they are satisfied with the list, then end the program.
    } else {
      System.out.println("\nMERRY CHRISTMAS!");
    }
  }
}
