package com.giftexchange;

import java.util.ArrayList;

public class Child extends Person {
ArrayList<String> itemsTheyLike = new ArrayList<>();

public Child () {
    super();
    itemsTheyLike.set(0, "");
}
 public Child (String name, String gender, int age, ArrayList<String> itemsTheyLike) {
    super (name, gender, age);
    this.itemsTheyLike = itemsTheyLike;

 }
 public String toString(){
    return "";

 }
    public ArrayList<String> getItemsTheyLike() {
        return itemsTheyLike;
    }

    public void setItemsTheyLike(ArrayList<String> itemsTheyLike) {
        this.itemsTheyLike = itemsTheyLike;
    }
}
