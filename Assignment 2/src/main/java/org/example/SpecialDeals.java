package org.example;

public class SpecialDeals extends Discounting{
    private int percentage;
    private int tickets;
    public boolean used;

    public SpecialDeals(int tickets, int percentage){
        this.tickets = tickets;
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        double amt = this.tickets * price;
        amt = amt - (this.percentage*amt)/100;
        this.used = true;
        return amt;
    }

    public int getTickets() {
        return this.tickets;
    }

    public int getPercentage(){
        return this.percentage;
    }

    @Override
    public String toString(){
        System.out.println("Special deal used: Buy " + this.tickets + " tickets and get " + this.percentage + "% off.");
        return null;
    }
}
