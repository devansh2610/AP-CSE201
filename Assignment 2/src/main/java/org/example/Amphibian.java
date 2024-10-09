package org.example;

public class Amphibian extends Animal {
    private String sound;
    public Amphibian(String n, String h) {
        super(n, h);
    }

    @Override
    public String getType() {
        return "Amphibian";
    }

    @Override
    public void setSound(String sound){
        this.sound = sound;
    }

    @Override
    public String makeSound(){
        return this.sound;
    }
}
