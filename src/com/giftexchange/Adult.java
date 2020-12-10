package com.giftexchange;

import java.util.ArrayList;


/**
 * This is the adult class. It is here to create an adult
 * object. This class contains a no-arg con and a custom con. And a toString method
 * and the getter and setters for people they dislike.
 */
public class Adult extends Person {
    // Created the local list of the people they dislike
    ArrayList<String> peopleTheyDislike = new ArrayList<>();

    /**
     * This is the no arg con for the adult class
     */
    public Adult() {
        super();
        peopleTheyDislike.set(0, "");
    }

    /**
     * This is the custom con for the Adult class
     * @param name
     * @param gender
     * @param age
     * @param peopleTheyDislike
     */
    public Adult(String name, String gender, int age, ArrayList<String> peopleTheyDislike) {
        super(name, gender, age);
        this.peopleTheyDislike = peopleTheyDislike;
    }

    /**
     * This is the ToString method for the Adult class.
     * @return
     */
    public String toString() {
        return "";
    }

    /**
     * This is the getter for people the dislike for the adult class.
     * @return
     */
    public ArrayList<String> getPeopleTheyDislike() {
        return peopleTheyDislike;
    }

    /**
     * This is the setter for people they dislike for the Adult class.
     * @param peopleTheyDislike
     */
    public void setPeopleTheyDislike(ArrayList<String> peopleTheyDislike) {
        this.peopleTheyDislike = peopleTheyDislike;
    }
}
