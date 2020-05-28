package com.example.groceryapp.foodtypes;

public class Organics extends Item {
    private double weight;

    public Organics(){
        super();
        weight = 0.0;
    }
    public Organics(String itemName, int id, double p, double weigh){
        super(itemName, id, p);
        weight = weigh;
    }

    @Override
    public double getPrice() {
        double dolRound = ((Math.round(super.getPrice()*weight*100)))/100.0;
        return dolRound;
    }
}
