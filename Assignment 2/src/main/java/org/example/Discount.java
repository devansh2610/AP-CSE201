package org.example;

public class Discount extends Discounting {
    private String code;
    private String category;
    private int percentage;

    public Discount(String code, String category, int percentage){
        this.code = code;
        this.category = category;
        this.percentage = percentage;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String s){
        this.category = s;
    }
    public String getCode(){
        return this.code;
    }

    public void setCode(String s){
        this.code = s;
    }

    public void setPercentage(int x){
        this.percentage = x;
    }
    @Override
    public int getPercentage(){
        return this.percentage;
    }

    @Override
    public int applyDiscount(Visitor v){
        if (v.getCategory().equalsIgnoreCase(this.category)){
            return 1;
        }
        else{
            return 0;
        }
    }

}
