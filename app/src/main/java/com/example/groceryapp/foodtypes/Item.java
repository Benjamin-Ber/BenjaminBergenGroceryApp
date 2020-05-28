package com.example.groceryapp.foodtypes;

public class Item {
    public String name;
    public int id;
    public double price;
    public int arrLoc;

    public Item(){
        name = "";
        id = 0;
        price = 0.0;
        arrLoc=0;
    }
    public Item(String itemName, int idNumber) {
        name = itemName;
        id = idNumber;
    }
    public Item(String itemName, double p){
        name = itemName;
        price = p;
    }
    public Item(String itemName, int itid, double p){
        name = itemName;
        id = itid;
        price = p;
    }

    public double getPrice() {
        return price;
    }

    public void setArrLoc(int arrLoc) {
        this.arrLoc = arrLoc;
    }

    public int getArrLoc() {
        return arrLoc;
    }
}