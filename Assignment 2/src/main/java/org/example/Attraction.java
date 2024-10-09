package org.example;

class Attraction {
    private String name;
    private String description;
    private double price = 10;
    private int ID;
    private boolean available;
    private int ticketed;

    static int animalidcount = 0;

    public Attraction(String name, String description) {
        this.name = name;
        this.ID = ++animalidcount;
        this.description = description;
        this.ticketed = 0;
        this.available = true;
    }

    public void addTicketed(int q){
        this.ticketed = this.ticketed + q;
    }

    public int getTicketed(){
        return this.ticketed;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public void setPrice(int p) {
        this.price = p;
    }

    public void setAvail(boolean val) {
        this.available = val;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean getAvail() {
        return this.available;
    }

    public int getID() {
        return this.ID;
    }

    public String notifier() {
        if (this.getAvail()) {
            return "Open";
        } else {
            return "Closed";
        }
    }
}
