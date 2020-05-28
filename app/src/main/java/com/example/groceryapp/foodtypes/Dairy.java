package com.example.groceryapp.foodtypes;

public class Dairy extends Item {
    boolean frozen;

    public Dairy(){
        super();
        frozen = false;
    }
    public Dairy(String nam, int itid, double p, boolean frz){
        super(nam, itid, p);
        frozen = frz;
    }
}
