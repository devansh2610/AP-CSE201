package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Visitor extends Auth implements Menu, userInfo, Feedback {
    private String username;
    private String password;
    private int age;
    private String phone;
    private double balance;
    private String email;
    private String type;
    private String category;
    private String feedback;
    private Map<String, Integer> ticketmap = new HashMap<>();
    private Map<String, String> feedbackmap = new HashMap<>();
    public static int visitorcount;

    public Visitor(String user, String email, String pass, int age, String ph, double bal) {
        this.username = user;
        this.email = email;
        this.password = pass;
        this.age = age;
        this.phone = ph;
        this.balance = bal;
    }

    public void setFeedback(String feedback){
        this.feedback = feedback;
    }


    public void associatefeedback(){
        feedbackmap.put(this.getUsername(), this.feedback);
    }


    public void showfeedback(Visitor visitor){
        System.out.println(visitor.getUsername() + ": " + feedbackmap.get(visitor.getUsername()));
    }

    public void thankfeedback(){
        System.out.println("Thank you for your feedback!");
    }


    public void purchaseTicket(Attraction attraction) {
        int currentcount = ticketmap.getOrDefault(attraction.getName(), 0);
        ticketmap.put(attraction.getName(), currentcount + 1);
    }

    public void reduceTicket(Attraction attraction){
        int currentcount = ticketmap.getOrDefault(attraction.getName(),0);
        if (currentcount<=0){
            ticketmap.put(attraction.getName(), 0);
        }
        else{
            ticketmap.put(attraction.getName(), currentcount - 1);
        }
    }

    public int getTicketCount(Attraction attraction) {
        String attractionName = attraction.getName();
        return ticketmap.getOrDefault(attractionName, 0);
    }
    public String getCategory(){
        if(this.age>=18 && this.age<=24){
            return "Student";
        }
        else if(this.age>=25 && this.age<=60){
            return "Working";
        }
        else if(this.age>60){
            return "Senior";
        }
        else{
            return "Minor";
        }
    }
    @Override
    public int authentication(String email, String pass) {
        if (email.equals(this.email) && pass.equals(this.password)) {
            System.out.println("Login Successful.");
            System.out.print("\n");
            return 1;
        } else {
            System.out.println("Incorrect login credentials.");
            System.out.print("\n");
            return 0;
        }
    }

    @Override
    public void giveConf() {
        if(this.type=="Basic"){
            System.out.println(this.getType() + " Membership purchased. Your current balance is " + this.getBalance());
            System.out.println("\n");
        }
        else{
            System.out.print("Premium Membership purchased. You current balance is " + this.getBalance());
            System.out.println("\n");
        }
    }

    @Override
    public void setType(String option){
        if(option.equals("1")){
            this.type = "Basic";
        }
        else{
            this.type = "Premium";
        }
    }

    @Override
    public String getType(){
        return this.type;
    }

    public String getPhone() {
        return this.phone;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void addBalance(double n){
        this.balance = this.balance + n;
    }

    @Override
    public void subBalance(double n){
        this.balance = this.balance - n;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void basicmenu() {
        System.out.println("Visitor Menu:\n" +
                "1. Explore the Zoo\n" +
                "2. Buy Membership\n" +
                "3. Buy Tickets\n" +
                "4. View Discounts\n" +
                "5. View Special Deals\n" +
                "6. Visit Animals\n" +
                "7. Visit Attractions\n" +
                "8. Leave Feedback\n" +
                "9. Log Out");
    }

    @Override
    public void secondmenu() {
        System.out.println("Explore the Zoo:\n" +
                "1. View Attractions\n" +
                "2. View Animals\n" +
                "3. Exit");
    }
}
