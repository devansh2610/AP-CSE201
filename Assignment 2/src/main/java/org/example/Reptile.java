package org.example;

class Reptile extends Animal {

    private String sound;
    public Reptile(String n, String h) {
        super(n, h);
    }

    @Override
    public String getType() {
        return "Reptile";
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
