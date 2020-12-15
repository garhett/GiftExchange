package com.giftexchange;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Name: Garhett Anderson & Alissa Corona. Course: CIT-260. File(s): GiftExchangeBuilder.java,
 * Child.java, Adult.java, Person.java. Date: 12/9/2020. About: This program enables the user to
 * input each of their family members to get a back a randomized report of a gift exchange among
 * each of the members of the list to then pass out to all family members prior to having the
 * Christmas party. This program also saves the list of family members so it can be used again in
 * the future when the program is reopened. Status: IN-PROGRESS. - Written by Garhett
 */
public class GiftExchangeBuilder {

  /**
   * Main method, driver method. - Written by Garhett
   *
   * @param args
   */
  public static void main(String[] args) {
    //        // import scanner and list for Person
    //        Scanner keyboard = new Scanner(System.in);
    //        ArrayList<Person> g = new ArrayList<>();
//            //get user input for adult list. Name, gender, and age. Also who they want to black
//     list,
//            //If they do not want to blacklist anyone have them enter 'none'.
//         System.out.println("Please enter adult name, gender, and age you want to include in the
//     gift
//         exchange. " +
//                          "Also add one name they want to blacklist, enter 'none' if not want to
//         blacklist a name.");
//
//            //get user input for child list. Name, gender, and age. Also what they like.
//            //if they do not have a preference they can enter 'none'.
//
//            System.out.println("Please enter child name, gender, and age you want to include in
//     the
//         gift exchange." +
//                              "Also add one item they like, enter 'none' if they are not picky.");
//
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

    /* ALISSA CODE ABOVE. GARHETT CODE BELOW */

    Scanner in = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);

    // Create each local list to be used and assigned for various uses. - Written by Garhett
    ArrayList<Person> familyList = new ArrayList<>();

    System.out.println("Welcome to Gift Exchange Builder!\n");
    System.out.println("Family gift exchanges are a holiday tradition in many families.\nThe user will have the ability to generate a random report if they need to \ncreate a new gift exchange list for this year.\n");
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
        familyList.add(new Child(name, gender, age, presentTheyWant));
      } else {
        System.out.print("Does " + name + " dislike anyone in the family? (yes or no): ");
        String doTheyDislikeAnyone = in.nextLine();
        String blacklistedPerson = "None";
        if (doTheyDislikeAnyone.equalsIgnoreCase("Yes")) {
          System.out.print(
              "Enter name of disliked family member. (This person WILL NOT exchange gifts with "
                  + name
                  + ".: ");
          blacklistedPerson = in.nextLine();
        }
        familyList.add(new Adult(name, gender, age, blacklistedPerson));
      }
    }
  }
}
