package com.giftexchange;

import java.util.ArrayList;
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
    // import scanner and list for Person
    Scanner keyboard = new Scanner(System.in);
    ArrayList<Person> g = new ArrayList<>();
    //tell the user what the program does
    System.out.println("Family gift exchanges are a holiday tradition in many families.\n" +
            "The user will have the ability to generate a random report if they need to create a new gift exchange list for this year");
    //get user input for adult list. Name, gender, and age. Also who they want to black list,
    //If they do not want to blacklist anyone have them enter 'none'.

    //get user input for child list. Name, gender, and age. Also what they like.
    //if they do not have a preference they can enter 'none'.

    //menu style: user enter 1 to show adult list
    //            user enter 2 to edit adult list. Add more people.
    //            user enter 3 to show child list
    //            user enter 4 to edit child list Add more people.

    System.out.println("Enter 1 to show adult list. \n" +
                       "Enter 2 to edit adult list, add more people. \n" +
                       "Enter 3 to show child list. \n" +
                       "Enter 4 to edit child list, add more people. \n" +
                       "Enter 5 if finished with listsL");



    // Create each of the local variables for the person's characteristics. - Written by Garhett

    String name = "";
    String gender = "";
    int age = 0;

    // Create each local list to be used and assigned for various uses. - Written by Garhett
    ArrayList<String> dislikedPeople = new ArrayList<>();
    ArrayList<String> likedItems = new ArrayList<>();
    ArrayList<Person> personList = new ArrayList<>();
  }
}
