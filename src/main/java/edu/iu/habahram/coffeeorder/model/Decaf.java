package edu.iu.habahram.coffeeorder.model;

public class Decaf extends Beverage{

    @Override
    public float cost() {
        return 1.28F;
    }

    @Override
    public String getDescription() {
        return "Decaf";
    }
    
}
