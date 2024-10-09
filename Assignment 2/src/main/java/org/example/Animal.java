package org.example;

class Animal {
    private String name;
    private String history;
    private int ID;
    private String sound;

    private static int mammalCount = 0;
    private static int amphibianCount = 0;
    private static int reptileCount = 0;
    private static int totalAnimalCount = 0;
    static int animalidcount = 0;

    public Animal(String n, String h) {
        this.name = n;
        this.history = h;
        this.ID = ++animalidcount;
        totalAnimalCount++;

        if (this instanceof Mammal) {
            mammalCount++;
        } else if (this instanceof Amphibian) {
            amphibianCount++;
        } else if (this instanceof Reptile) {
            reptileCount++;
        }
    }

    public void lessenCount() {
        totalAnimalCount--;
        if (this instanceof Mammal) {
            mammalCount--;
        }
        if (this instanceof Reptile) {
            reptileCount--;
        }
        if (this instanceof Amphibian) {
            amphibianCount--;
        }
    }

    public static int getMammalCount() {
        return mammalCount;
    }

    public static int getAmphibianCount() {
        return amphibianCount;
    }

    public static int getReptileCount() {
        return reptileCount;
    }

    public static int getTotalAnimalCount() {
        return totalAnimalCount;
    }

    public int getID() {
        return this.ID;
    }

    public void setSound(String sound){
        this.sound = sound;
    }

    public String makeSound() {
        return "Animal makes a sound";
    }

    public String getType() {
        return "Animal returns the type";
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setHistory(String h) {
        this.history = h;
    }

    public String getName() {
        return this.name;
    }

    public String getHistory() {
        return this.history;
    }
}
