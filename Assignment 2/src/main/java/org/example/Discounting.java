package org.example;

public abstract class Discounting {
    private int tickets;
    private int percentage;
    abstract public int getPercentage();
    public int applyDiscount(Visitor v){
        return 1;
    };
    public double applyDiscount(double x){
        return 1;
    }

}
