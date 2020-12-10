package com.giftexchange;

import java.util.ArrayList;

public class Adult extends Person {
  ArrayList<String> peopleTheyDislike = new ArrayList<>();

  public Adult() {
    peopleTheyDislike.set(0, "");
  }

  public Adult(String name, String gender, int age, ArrayList<String> peopleTheyDislike) {
    super(name, gender, age);
    this.peopleTheyDislike = peopleTheyDislike;
  }

  public String toString() {
    return "";
  }

  public ArrayList<String> getPeopleTheyDislike() {
    return peopleTheyDislike;
  }

  public void setPeopleTheyDislike(ArrayList<String> peopleTheyDislike) {
    this.peopleTheyDislike = peopleTheyDislike;
  }
}
