package org.example;

class Mammal extends Animal {
    private String sound;
    public Mammal(String n, String h) {
        super(n, h);
    }

    @Override
    public String getType() {
        return "Mammal";
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
