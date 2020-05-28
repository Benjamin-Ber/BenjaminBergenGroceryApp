package com.example.groceryapp.foodtypes;

public class Toiletries extends Item {
    boolean hasBleach = false;
    public Toiletries(){
        super();
        hasBleach = false;
    }
    public Toiletries(String n, double p, boolean hB){
        super(n, p);
        hasBleach = hB;
    }
}
