package org.example;

import org.w3c.dom.Attr;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin();
        ArrayList<Attraction> attractionlist = new ArrayList<Attraction>();
        Attraction junglesafari = new Attraction("Jungle Safari", " A thrilling adventure in the jungle.");
        Attraction botanicalgarden = new Attraction("Botanical Garden", "A thrilling adventure in the botanical garden");
        Attraction dinosaurshow = new Attraction("Dinosaur show", "A thrilling adventure in the dinosaur show");
        attractionlist.add(junglesafari); attractionlist.add(botanicalgarden); attractionlist.add(dinosaurshow);
        ArrayList<Visitor> visitorlist = new ArrayList<Visitor>();

        ArrayList<Animal> animallist = new ArrayList<>();
        Animal lion = new Mammal("Lion","The king of the jungle, known for its majestic mane and fierce roar.");
        Animal giraffe = new Mammal("Giraffe","Tall and elegant herbivores with long necks and unique spotted patterns");
        Animal frog = new Amphibian("Frog","Small, agile creatures that are known for their distinctive croaking calls.");
        Animal salamander = new Amphibian("Salamander","Amphibians with smooth, moist skin and a variety of vibrant colors.");
        Animal snake = new Reptile("Snake","Slithering reptiles with no limbs, often recognized for their venomous species.");
        Animal tortoise = new Reptile("Tortoise","Slow-moving reptiles with protective shells that can live for a very long time.");
        animallist.add(lion); animallist.add(giraffe); animallist.add(frog); animallist.add(salamander); animallist.add(snake); animallist.add(tortoise);
        lion.setSound("Roar"); giraffe.setSound("Moo"); frog.setSound("Ribbit"); salamander.setSound("Shhh"); snake.setSound("Hiss"); tortoise.setSound("Slowsound");

        ArrayList<Discount> discountlist = new ArrayList<>();
        Discount minor10 = new Discount("MINOR10", "minor", 10);
        Discount senior20 = new Discount("SENIOR20", "senior", 20);
        discountlist.add(minor10); discountlist.add(senior20);

        ArrayList<SpecialDeals> spdealslist = new ArrayList<>();
        SpecialDeals deal1 = new SpecialDeals(2,15);
        SpecialDeals deal2 = new SpecialDeals(3, 30);
        spdealslist.add(deal1); spdealslist.add(deal2);

        int totalvisitors = 0;
        double revenue = 0;


        System.out.println("Welcome to ZOOtpia");
        while(true){
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.println("4. Exit program");
            System.out.println("Enter your choice: ");
            String firstinput = scanner.nextLine();

            if (firstinput.equals("1")){  // enter as admin
                System.out.println("Enter Admin Username: ");
                String enteruser = scanner.nextLine();
                System.out.println("Enter Admin password: ");
                String enterpass = scanner.nextLine();
                int auth = admin.authentication(enteruser,enterpass);   // call authentication method in admin
                if(auth==1){
                    while(true){
                        admin.basicmenu();  // print admin menu from menu method in admin
                        System.out.println("Enter option number: ");
                        String secondinput = scanner.nextLine(); //SECOND INPUT INITALIZED
                        if(secondinput.equals("1")){
                            while(true){
                                admin.secondmenu();
                                System.out.println("Enter option number: ");
                                String majorchoice = scanner.nextLine();
                                if(majorchoice.equals("1")){
                                    System.out.println("Enter Attraction Name: ");
                                    String attname = scanner.nextLine();
                                    int found = 0;
                                    for (Attraction attraction: attractionlist){
                                        if(attraction.getName().equals(attname)){
                                            System.out.println("This attraction already exists!");
                                            found = found + 1;
                                        }
                                    }

                                    if (found==0){
                                        System.out.println("Enter Attraction Description: ");
                                        String attdesc = scanner.nextLine();
                                        Attraction attraction = new Attraction(attname,attdesc);
                                        attractionlist.add(attraction);
                                        System.out.println("Attraction has been added to the Zoo.");
                                    }
                                }
                                else if(majorchoice.equals("2")){
                                    if(attractionlist.isEmpty()){
                                        System.out.println("No attractions available currently!");
                                    }
                                    else{
                                        for(Attraction attraction: attractionlist){
                                            System.out.println("ID: " + attraction.getID() + "; " + attraction.getName());
                                        }
                                    }
                                }
                                else if (majorchoice.equals("3")) {
                                    if (attractionlist.isEmpty()) {
                                        System.out.println("No attractions available currently!");
                                    } else {
                                        for (Attraction attraction : attractionlist) {
                                            System.out.println("ID: " + attraction.getID() + "; " + attraction.getName());
                                        }

                                        int userchoice = 0;
                                        int found = 0;
                                        Attraction changeatt = null;

                                        boolean validInput = false;

                                        do {
                                            try {
                                                System.out.print("Enter attraction ID: ");
                                                userchoice = Integer.parseInt(scanner.nextLine());

                                                for (Attraction attraction : attractionlist) {
                                                    if (attraction.getID() == userchoice) {
                                                        found = 1;
                                                        changeatt = attraction;
                                                        break;
                                                    }
                                                }

                                                if (found == 0) {
                                                    System.out.println("Enter a valid attraction ID!");
                                                } else {
                                                    validInput = true;
                                                }

                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid input. Please enter a valid attraction ID (a whole number).");
                                            }
                                        } while (!validInput);

                                        System.out.println("1. Change name");
                                        System.out.println("2. Change description");
                                        System.out.print("Enter option number: ");
                                        String thischange = scanner.nextLine();
                                        if (thischange.equals("1")) {
                                            System.out.println("Enter new name: ");
                                            thischange = scanner.nextLine();
                                            changeatt.setName(thischange);
                                            System.out.println("Attraction's name has been changed successfully.");
                                        } else if (thischange.equals("2")) {
                                            System.out.println("Enter description: ");
                                            thischange = scanner.nextLine();
                                            changeatt.setDescription(thischange);
                                            System.out.println("Attraction's description has been changed successfully.");
                                        } else {
                                            System.out.println("Enter a valid option!");
                                        }
                                    }
                                }

                                else if (majorchoice.equals("4")) {
                                    if (attractionlist.isEmpty()) {
                                        System.out.println("No attractions available currently!");
                                    } else {
                                        for (Attraction attraction : attractionlist) {
                                            System.out.println("ID: " + attraction.getID() + "; " + attraction.getName());
                                        }

                                        int userchoice = 0;
                                        int found = 0;
                                        Attraction changeatt = null;

                                        boolean validInput = false;

                                        do {
                                            try {
                                                System.out.print("Enter attraction ID: ");
                                                userchoice = Integer.parseInt(scanner.nextLine());

                                                for (Attraction attraction : attractionlist) {
                                                    if (attraction.getID() == userchoice) {
                                                        found = 1;
                                                        changeatt = attraction;
                                                        break;
                                                    }
                                                }

                                                if (found == 0) {
                                                    System.out.println("Enter a valid attraction ID!");
                                                } else {
                                                    validInput = true;
                                                }

                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid input. Please enter a valid attraction ID (a whole number).");
                                            }
                                        } while (!validInput);

                                        attractionlist.remove(changeatt);
                                        System.out.println("Attraction has been successfully removed!");
                                    }
                                }

                                else if(majorchoice.equals("5")){
                                    break;
                                }
                                else {
                                    System.out.println("Enter a valid option!");
                                }
                            }
                        }

                        else if(secondinput.equals("2")){
                            while(true){
                                System.out.println("Manage Animals:\n" +
                                        "1. Add Animal\n" +
                                        "2. Update Animal Details\n" +
                                        "3. Remove Animal\n" +
                                        "4. Exit");
                                System.out.println("Enter option number: ");
                                String choice = scanner.nextLine();
                                int found = 0;
                                if(choice.equals("1")){
                                    System.out.println("Enter Animal Name: ");
                                    String aniname = scanner.nextLine();
                                    for(Animal animal: animallist){
                                        if(animal.getName().equalsIgnoreCase(aniname)){
                                            System.out.println("Animal with this name already exists!");
                                            found = 1;
                                            break;
                                        }
                                    }
                                    if(found==0){
                                        System.out.println("Enter Animal Description: ");
                                        String desc = scanner.nextLine();
                                        System.out.println("Enter Animal Type: ");
                                        String anitype = scanner.nextLine();
                                        if(anitype.equalsIgnoreCase("Mammal")){
                                            Animal newanimal = new Mammal(aniname, desc);
                                            animallist.add(newanimal);
                                            System.out.println("Enter sound animal will make when it is fed: ");
                                            String sound = scanner.nextLine();
                                            newanimal.setSound(sound);

                                            System.out.println("Animal has been added to the Zoo.");
                                        }
                                        else if(anitype.equalsIgnoreCase("Reptile")){
                                            Animal newanimal = new Reptile(aniname, desc);
                                            animallist.add(newanimal);
                                            System.out.println("Enter sound animal will make when it is fed: ");
                                            String sound = scanner.nextLine();
                                            newanimal.setSound(sound);
                                            System.out.println("Animal has been added to the Zoo.");
                                        }
                                        else if(anitype.equalsIgnoreCase("Amphibian")){
                                            Animal newanimal = new Amphibian(aniname, desc);
                                            animallist.add(newanimal);
                                            System.out.println("Enter sound animal will make when it is fed: ");
                                            String sound = scanner.nextLine();
                                            newanimal.setSound(sound);
                                            System.out.println("Animal has been added to the Zoo.");
                                        }
                                        else{
                                            System.out.println("Enter a valid type: Mammal, Amphibian or Reptile.");
                                        }
                                    }
                                }

                                else if (choice.equals("2")) {
                                    for (Animal animal : animallist) {
                                        System.out.println(animal.getID() + ". " + animal.getName());
                                    }

                                    int i = 0;
                                    found = 0;
                                    Animal anichange = null;

                                    boolean validInput = false;

                                    do {
                                        try {
                                            System.out.print("Enter animal ID of the animal you want to modify: ");
                                            i = Integer.parseInt(scanner.nextLine());

                                            for (Animal animal : animallist) {
                                                if (i == animal.getID()) {
                                                    anichange = animal;
                                                    found = found + 1;
                                                    break;
                                                }
                                            }

                                            if (found != 0) {
                                                validInput = true;
                                            } else {
                                                System.out.println("Enter a valid animal ID.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter a valid animal ID (a whole number).");
                                        }
                                    } while (!validInput);

                                    System.out.println("Enter Animal Description/History: ");
                                    String anihist = scanner.nextLine();
                                    anichange.setHistory(anihist);
                                    System.out.println("Animal description/history updated.");
                                }


                                else if (choice.equals("3")) {
                                    for (Animal animal : animallist) {
                                        System.out.println(animal.getID() + ". " + animal.getName());
                                    }

                                    int i = 0;
                                    found = 0;
                                    Animal anidelete = null;

                                    boolean validInput = false;

                                    do {
                                        try {
                                            System.out.print("Enter animal ID to be removed: ");
                                            i = Integer.parseInt(scanner.nextLine());

                                            for (Animal animal : animallist) {
                                                if (i == animal.getID()) {
                                                    anidelete = animal;
                                                    found = found + 1;
                                                    break;
                                                }
                                            }

                                            if (found != 0) {
                                                validInput = true;
                                            } else {
                                                System.out.println("Enter a valid animal ID.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter a valid animal ID (a whole number).");
                                        }
                                    } while (!validInput);

                                    anidelete.lessenCount();
                                    animallist.remove(anidelete);
                                    System.out.println("Animal has been removed.");
                                }


                                else if(choice.equals("4")){
                                    break;
                                }

                                else{
                                    System.out.println("Enter a valid option!");
                                }
                            }
                        }

                        else if (secondinput.equals("3")) { // SCHEDULE EVENTS
                            if (attractionlist.isEmpty()) {
                                System.out.println("No attractions available currently!");
                            } else {
                                for (Attraction attraction : attractionlist) {
                                    System.out.println("ID: " + attraction.getID() + "; Name: " + attraction.getName());
                                }
                                int selectid = 0;
                                int found = 0;
                                Attraction selectatt = null;
                                boolean validInput = false;

                                do {
                                    try {
                                        System.out.print("Enter ID of the attraction: ");
                                        selectid = Integer.parseInt(scanner.nextLine());

                                        for (Attraction attraction : attractionlist) {
                                            if (selectid == attraction.getID()) {
                                                selectatt = attraction;
                                                found = found + 1;
                                                break;
                                            }
                                        }

                                        if (found != 0) {
                                            validInput = true;
                                        } else {
                                            System.out.println("Enter a valid attraction ID!");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a valid attraction ID (a whole number).");
                                    }
                                } while (!validInput);

                                System.out.println("1. Change price of entry ticket");
                                System.out.println("2. Change availability of attraction");
                                System.out.print("Enter option number: ");
                                String anothopt = scanner.nextLine();
                                if (anothopt.equals("1")) {
                                    try {
                                        System.out.print("Enter price of entry ticket: ");
                                        int newPrice = Integer.parseInt(scanner.nextLine());
                                        selectatt.setPrice(newPrice);
                                        System.out.println("Ticket price updated successfully.");
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a valid number for the price.");
                                    }
                                }

                                else if (anothopt.equals("2")) {
                                    if (selectatt.getAvail()) {
                                        selectatt.setAvail(false);
                                    } else {
                                        selectatt.setAvail(true);
                                    }
                                    System.out.println("Availability changed successfully to: " + selectatt.notifier());
                                }

                                else {
                                    System.out.println("Enter a valid option!");
                                }
                            }
                        }

                        else if(secondinput.equals("4")){
                            while(true){
                                System.out.println("Set Discounts:\n" +
                                        "1. Add Discount\n" +
                                        "2. Modify Discount\n" +
                                        "3. Remove Discount\n" +
                                        "4. Exit");
                                System.out.println("Enter option number: ");
                                String userchoice = scanner.nextLine();
                                if (userchoice.equals("1")) {
                                    while (true) {
                                        System.out.print("Enter discount category ('Student'/'Senior'/'Working'/'Minor'): ");
                                        String disccat = scanner.nextLine();

                                        if (disccat.equalsIgnoreCase("Student") || disccat.equalsIgnoreCase("Senior") || disccat.equalsIgnoreCase("Working") || disccat.equalsIgnoreCase("Minor")) {
                                            int discperc = 0;
                                            boolean validInput = false;

                                            do {
                                                try {
                                                    System.out.print("Enter discount percentage: ");
                                                    discperc = Integer.parseInt(scanner.nextLine());

                                                    if (discperc > 0 && discperc < 100) {
                                                        int found = 0;
                                                        String code = disccat + String.valueOf(discperc);
                                                        Discount newdisc = new Discount(code, disccat, discperc);

                                                        for (Discount thediscounts : discountlist) {
                                                            if (thediscounts.getCode().equals(newdisc.getCode())) {
                                                                found = 1;
                                                                break;
                                                            }
                                                        }

                                                        if (found == 1) {
                                                            System.out.println("Discount with the same code and specifications already exists!");
                                                        } else {
                                                            discountlist.add(newdisc);
                                                            System.out.println("Discount created successfully.");
                                                        }

                                                        validInput = true;
                                                    } else {
                                                        System.out.println("Enter a valid discount percentage (between 1 and 99).");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a valid discount percentage (a whole number).");
                                                }
                                            } while (!validInput);

                                            break;
                                        } else {
                                            System.out.println("Enter a valid category! ('Student'/'Senior'/'Working'/'Minor')");
                                        }
                                    }
                                }

                                else if(userchoice.equals("2")){
                                    if(discountlist.isEmpty()){
                                        System.out.println("No discounts exist!");
                                    }
                                    else{
                                        for(Discount disc: discountlist){
                                            System.out.println(disc.getCode().toUpperCase());
                                        }
                                        System.out.println("Enter the discount code of the discount you want to modify: ");
                                        String userinp = scanner.nextLine();
                                        int found = 0;
                                        Discount editdisc = null;
                                        for(Discount disc: discountlist){
                                            if(disc.getCode().equalsIgnoreCase(userinp)){
                                                found = 1;
                                                editdisc = disc;
                                                break;
                                            }
                                        }
                                        if(found==0){
                                            System.out.println("Enter a valid discount code!");
                                        }
                                        else{
                                            System.out.println("1. Change code");
                                            System.out.println("2. Change percentage");
                                            System.out.println("3. Change category");
                                            System.out.println("Enter option number: ");
                                            userinp = scanner.nextLine();
                                            if(userinp.equals("1")){
                                                System.out.println("Enter code: ");
                                                userinp = scanner.nextLine();
                                                found = 0;
                                                for(Discount thedisc: discountlist){
                                                    if(thedisc.getCode().equalsIgnoreCase(userinp)){
                                                        found = 1;
                                                        break;
                                                    }
                                                }
                                                if(found==1){
                                                    System.out.println("A discount with this code already exists!");
                                                }
                                                else{
                                                    for(Discount disc: discountlist){
                                                        if(disc.getCode().equalsIgnoreCase(editdisc.getCode())){
                                                            discountlist.remove(disc);
                                                        }
                                                    }
                                                    editdisc.setCode(userinp);
                                                    discountlist.add(editdisc);
                                                    System.out.println("Discount code succesfully changed.");
                                                }
                                            }

                                            else if (userinp.equals("2")) {
                                                try {
                                                    System.out.print("Enter percentage: ");
                                                    int newPercentage = Integer.parseInt(scanner.nextLine());
                                                    if (newPercentage <= 0 || newPercentage >= 100) {
                                                        System.out.println("Enter a valid discount percentage!");
                                                    } else {
                                                        editdisc.setPercentage(newPercentage);
                                                        System.out.println("Discount percentage successfully changed.");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a valid integer for the percentage.");
                                                }
                                            }

                                            else if(userinp.equals("3")){
                                                System.out.println("Enter category ('Student'/'Senior'/'Working'/'Minor'): ");
                                                String disccat = scanner.nextLine();
                                                if(!(disccat.equalsIgnoreCase("Student") || disccat.equalsIgnoreCase("Senior") || disccat.equalsIgnoreCase("Working")
                                                        || disccat.equalsIgnoreCase("Minor"))){
                                                    System.out.println("Enter a valid category! ('Student'/'Senior'/'Working'/'Minor')");
                                                }
                                                else{
                                                    editdisc.setCategory(disccat);
                                                    System.out.println("Discount category succesfully changed.");
                                                }
                                            }
                                            else{
                                                System.out.println("Enter a valid option!");
                                            }

                                        }
                                    }
                                }

                                else if(userchoice.equals("3")){
                                    if(discountlist.isEmpty()){
                                        System.out.println("No discounts exist!");
                                    }
                                    else{
                                        for(Discount disc: discountlist){
                                            System.out.println(disc.getCode().toUpperCase());
                                        }
                                        int found = 0;
                                        Discount remdisc = null;
                                        System.out.println("Enter discount code you want to remove: ");
                                        String userinp = scanner.nextLine();
                                        for(Discount disc: discountlist){
                                            if(userinp.equalsIgnoreCase(disc.getCode())){
                                                found = 1;
                                                remdisc = disc;
                                                break;
                                            }
                                        }
                                        if(found==0){
                                            System.out.println("Enter a valid discount code!");
                                        }
                                        else{
                                            discountlist.remove(remdisc);
                                            System.out.println("Discount succesfully removed!");
                                        }
                                    }
                                }

                                else if(userchoice.equals("4")){
                                    break;
                                }
                                else {
                                    System.out.println("Enter a valid option!");
                                }
                            }
                        }
                        else if (secondinput.equals("5")) {
                            while (true) {
                                int ticketsneeded = 0;
                                int percneeded = 0;
                                boolean validInput = false;

                                try {
                                    System.out.print("Enter number/quantity of tickets: ");
                                    ticketsneeded = Integer.parseInt(scanner.nextLine());

                                    System.out.print("Enter discount percentage: ");
                                    percneeded = Integer.parseInt(scanner.nextLine());

                                    if (ticketsneeded > 0 && percneeded > 0) {
                                        int found = 0;

                                        for (SpecialDeals spdeal : spdealslist) {
                                            if (spdeal.getTickets() == ticketsneeded && spdeal.getPercentage() == percneeded) {
                                                found = 1;
                                                System.out.println("A special deal with these specifications already exists!");
                                                break;
                                            }
                                        }

                                        if (found == 0) {
                                            System.out.println("Special deal successfully created!");
                                            SpecialDeals newspdeal = new SpecialDeals(ticketsneeded, percneeded);
                                            spdealslist.add(newspdeal);
                                        }

                                        validInput = true;
                                    } else {
                                        System.out.println("Enter valid values for tickets and percentage (greater than 0).");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter valid numbers for tickets and percentage.");
                                }

                                if (validInput) {
                                    break;
                                }
                            }
                        }

                        else if(secondinput.equals("6")){
                            System.out.println("Visitor Statistics:\n" +
                                    "- Total Visitors: " + totalvisitors + "\n" +
                                    "- Total Revenue: Rs. " + revenue);
                            String mostpopular = null;
                            int maxTicketed = 0;
                            for (Attraction attraction: attractionlist) {
                                int ticketedCount = attraction.getTicketed();
                                if (ticketedCount > maxTicketed) {
                                    maxTicketed = ticketedCount;
                                    mostpopular = attraction.getName();
                                }
                            }
                            System.out.println("- Most Popular Attraction: " + mostpopular);
                        }
                        else if(secondinput.equals("7")){
                            if(visitorlist.isEmpty()){
                                System.out.println("There are no visitors yet!");
                            }
                            else{
                                for(Visitor visitor: visitorlist){
                                    visitor.showfeedback(visitor);
                                }

                            }
                        }
                        else if(secondinput.equals("8")){
                            break;
                        }
                        else{
                            System.out.println("Enter a valid option!");
                        }
                    }
                }
            }
            else if(firstinput.equals("2")){
                while(true){
                    System.out.println("1. Register\n" +
                            "2. Login\n" +
                            "3. Back");
                    System.out.println("Enter option number: ");
                    String secondinput = scanner.nextLine();
                    if (secondinput.equals("1")) {
                        String visitorname = "";
                        int visitorage = 0;
                        String visitorph = "";
                        double visitorbal = 0.0;
                        String visitoremail = "";
                        String visitorpass = "";

                        // Input validation for visitor name
                        boolean validName = false;
                        while (!validName) {
                            System.out.println("Enter Visitor Name: ");
                            visitorname = scanner.nextLine();
                            validName = visitorname.matches("^[a-zA-Z\\s]+$"); // Allows only letters and spaces
                            if (!validName) {
                                System.out.println("Invalid name. Name must contain only letters and spaces.");
                            }
                        }

                        // Input validation for visitor age
                        boolean validAge = false;
                        while (!validAge) {
                            System.out.print("Enter Visitor Age: ");
                            try {
                                visitorage = Integer.parseInt(scanner.nextLine());
                                if (visitorage >= 0) {
                                    validAge = true;
                                } else {
                                    System.out.println("Age must be a non-negative integer.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Age must be a non-negative integer.");
                            }
                        }

                        // Input validation for visitor phone number
                        boolean validPhoneNumber = false;
                        while (!validPhoneNumber) {
                            System.out.println("Enter Visitor Phone Number: ");
                            visitorph = scanner.nextLine();
                            validPhoneNumber = visitorph.matches("^[0-9]+$"); // Allows only numeric characters
                            if (!validPhoneNumber) {
                                System.out.println("Invalid phone number. Please enter a numeric string.");
                            }
                        }

                        // Input validation for visitor balance
                        boolean validBalance = false;
                        while (!validBalance) {
                            System.out.print("Enter Visitor Balance: ");
                            try {
                                visitorbal = Double.parseDouble(scanner.nextLine());
                                if (visitorbal >= 100) {
                                    validBalance = true;
                                } else {
                                    System.out.println("Balance must be at least 100.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Balance must be a numeric value.");
                            }
                        }

                        System.out.println("Enter Visitor Email: ");
                        visitoremail = scanner.nextLine();
                        System.out.println("Enter Visitor Password: ");
                        visitorpass = scanner.nextLine();

                        Visitor newvisitor = new Visitor(visitorname, visitoremail, visitorpass, visitorage, visitorph, visitorbal);
                        visitorlist.add(newvisitor);
                        System.out.println("Registration is successful.");
                    }


                    else if(secondinput.equals("2")){
                        System.out.println("Enter Visitor Email: ");
                        String vemail = scanner.nextLine();
                        System.out.println("Enter Visitor Password: ");
                        String vpass = scanner.nextLine();
                        int found = 0;
                        Visitor ourvis = null;
                        for (Visitor v: visitorlist){
                            if (v.getEmail().equals(vemail) && v.getPassword().equals(vpass)){
                                ourvis = v;
                                found = found + 1;
                                break;
                            }
                        }
                        if (found==0){
                            System.out.println("Enter valid credentials!");
                        }
                        else{
                            System.out.println("Login Successful.");
                            while(true){
                                ourvis.basicmenu();
                                System.out.println("Enter option number: ");
                                String majorchoice = scanner.nextLine();
                                if(majorchoice.equals("1")){
                                    while(true){
                                        ourvis.secondmenu();
                                        System.out.println("Enter option number: ");
                                        String secondarychoice = scanner.nextLine();
                                        if (secondarychoice.equals("1")) {
                                            while (true) {
                                                if (attractionlist.isEmpty()) {
                                                    System.out.println("No attractions available currently!");
                                                    break;
                                                }

                                                for (Attraction attraction : attractionlist) {
                                                    if (attraction.getAvail()) {
                                                        System.out.println("ID: " + attraction.getID() + "; Name: " + attraction.getName());
                                                    } else {
                                                        System.out.println("ID: " + attraction.getID() + "; Name: " + attraction.getName() + " (Currently closed)");
                                                    }
                                                }

                                                System.out.print("Enter ID of the attraction you are interested in: ");
                                                int chosenid;
                                                try {
                                                    chosenid = Integer.parseInt(scanner.nextLine());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a valid attraction ID.");
                                                    continue;
                                                }

                                                found = 0;
                                                Attraction chosenatt = null;
                                                for (Attraction attraction : attractionlist) {
                                                    if (attraction.getID() == chosenid) {
                                                        found = 1;
                                                        chosenatt = attraction;
                                                        break;
                                                    }
                                                }

                                                if (found != 0) {
                                                    System.out.println(chosenatt.getDescription());
                                                    break;
                                                } else {
                                                    System.out.println("Enter a valid attraction ID.");
                                                }
                                            }
                                        }

                                        else if (secondarychoice.equals("2")) {
                                            while (true) {
                                                if (animallist.isEmpty()) {
                                                    System.out.println("No animals currently available");
                                                    break;
                                                }

                                                for (Animal animal : animallist) {
                                                    System.out.println("ID: " + animal.getID() + "; Name: " + animal.getName());
                                                }

                                                System.out.print("Enter ID of the animal you want to choose: ");
                                                int chosenid;
                                                try {
                                                    chosenid = Integer.parseInt(scanner.nextLine());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a valid animal ID.");
                                                    continue;
                                                }

                                                Animal chosenanimal = null;
                                                found = 0;
                                                for (Animal animal : animallist) {
                                                    if (animal.getID() == chosenid) {
                                                        found = 1;
                                                        chosenanimal = animal;
                                                        break;
                                                    }
                                                }

                                                if (found != 0) {
                                                    System.out.println(chosenanimal.getHistory());
                                                    break;
                                                } else {
                                                    System.out.println("Enter a valid animal ID.");
                                                }
                                            }
                                        }

                                        else if(secondarychoice.equals("3")){
                                            break;
                                        }
                                        else{
                                            System.out.println("Enter a valid option!");
                                        }
                                    }
                                }
                                else if(majorchoice.equals("2")){
                                    if(ourvis.getType()!=null){
                                        System.out.println("You already have a membership!");
                                    }
                                    else {
                                        System.out.println("Buy Membership:\n" +
                                                "1. Basic Membership (₹20)\n" +
                                                "2. Premium Membership (₹50)");
                                        System.out.println("Enter your choice: ");
                                        String secondarychoice = scanner.nextLine();
                                        if(secondarychoice.equals("1")){
                                            System.out.println("Enter discount code: ");
                                            String userdisc = scanner.nextLine();
                                            if(userdisc.equalsIgnoreCase("None") || userdisc.isEmpty()){
                                                if(ourvis.getBalance()<20){
                                                    System.out.println("Insufficient balance");
                                                }
                                                else{
                                                    ourvis.setType("1");
                                                    ourvis.subBalance(20);
                                                    ourvis.giveConf();
                                                    totalvisitors++;
                                                    revenue = revenue + 20;
                                                }
                                            }
                                            else{
                                                int conf = 0;
                                                found = 0;
                                                for(Discount discount: discountlist){
                                                    if(userdisc.equalsIgnoreCase(discount.getCode())){
                                                        found = found + 1;
                                                        conf = discount.applyDiscount(ourvis);
                                                        if(conf==1){
                                                            double bal = 20*discount.getPercentage();
                                                            bal = bal/100;
                                                            bal = 20 - bal;
                                                            if(ourvis.getBalance()<bal){
                                                                System.out.println("Insufficient balance!");
                                                                break;
                                                            }
                                                            else{
                                                                ourvis.setType("1");
                                                                //ourvis.addBalance(20*discount.percentage/100 + ourvis.getBalance());
                                                                System.out.println("Discount code succesfully applied! You only paid Rs. " + bal);
                                                                ourvis.subBalance(bal);
                                                                ourvis.giveConf();
                                                                totalvisitors++;
                                                                revenue = revenue + bal;
                                                                break;
                                                            }
                                                        }
                                                        else if(conf==0){
                                                            System.out.println("Your age bracket does not qualify for the discount on this code! (Enter 'None' or leave blank if you don't have a coupon!)");
                                                            break;
                                                        }
                                                    }
                                                }
                                                if(found==0){
                                                    System.out.println("Invalid discount code!");
                                                }
                                            }
                                        }
                                        else if(secondarychoice.equals("2")){
                                            System.out.println("Enter discount code: ");
                                            String userdisc = scanner.nextLine();
                                            if(userdisc.equalsIgnoreCase("None") || userdisc.isEmpty()){
                                                if(ourvis.getBalance()<50){
                                                    System.out.println("Insufficient balance!");
                                                }
                                                else{
                                                    ourvis.setType("2");
                                                    ourvis.subBalance(50);
                                                    ourvis.giveConf();
                                                    totalvisitors++;
                                                    revenue = revenue + 50;
                                                    break;
                                                }
                                            }
                                            else{
                                                int conf = 0;
                                                found = 0;
                                                for(Discount discount: discountlist){
                                                    if(userdisc.equalsIgnoreCase(discount.getCode())){
                                                        found = found + 1;
                                                        conf = discount.applyDiscount(ourvis);
                                                        if(conf==1){
                                                            double bal = 50*discount.getPercentage();
                                                            bal = bal/100;
                                                            bal = 50 - bal;
                                                            if(ourvis.getBalance()<bal){
                                                                System.out.println("Insufficient balance!");
                                                            }
                                                            else{
                                                                ourvis.setType("2");
                                                                System.out.println("Discount code succesfully applied!");
                                                                bal = 50*discount.getPercentage();
                                                                bal = bal/100;
                                                                bal = 50 - bal;
                                                                System.out.println("You only paid Rs. " + bal + "!");
                                                                ourvis.subBalance(bal);
                                                                ourvis.giveConf();
                                                                totalvisitors++;
                                                                revenue = revenue + bal;
                                                                break;
                                                            }
                                                        }
                                                        if(conf==0){
                                                            System.out.println("Your age bracket does not qualify for this discount! (Enter 'None' or leave blank if you don't have a coupon!)");
                                                            break;
                                                        }
                                                    }
                                                }
                                                if(found==0){
                                                    System.out.println("Invalid discount code!");
                                                }
                                            }
                                        }
                                        else{
                                            System.out.println("Enter a valid option!");
                                        }
                                    }
                                }

                                else if(majorchoice.equals("3")){
                                    if(ourvis.getType()==null){
                                        System.out.println("You need to buy a membership first!");
                                    }
                                    else{
                                        if(attractionlist.isEmpty()){
                                            System.out.println("No attractions available yet!");
                                        }
                                        else if(ourvis.getType().equalsIgnoreCase("Premium")){
                                            System.out.println("As a premium member you do not need to buy tickets! Please use Visit Attractions directly.");
                                        }
                                        else{
                                            System.out.println("Select an Attraction to Buy a Ticket:");
                                            for(Attraction attraction: attractionlist){
                                                if(attraction.getAvail()==true){
                                                    System.out.println("ID: " + attraction.getID() + "; " + attraction.getName() + " (" + attraction.getPrice() + ")");
                                                }
                                            }
                                            System.out.print("Enter ID of attraction: ");
                                            int secondarychoice;
                                            while (true) {
                                                try {
                                                    secondarychoice = Integer.parseInt(scanner.nextLine());
                                                    break;  // Exit the loop if the input is a valid integer
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a valid attraction ID.");
                                                }
                                            }

                                            found = 0;
                                            Attraction foundatt = null;
                                            for (Attraction attraction : attractionlist) {
                                                if (secondarychoice == attraction.getID()) {
                                                    foundatt = attraction;
                                                    found = 1;
                                                    break;
                                                }
                                            }

                                            if (found == 0) {
                                                System.out.println("Enter a valid attraction ID.");
                                            }

                                            if(found==0){
                                                System.out.println("Enter a valid attraction ID!");
                                            }
                                            else{
                                                System.out.print("Enter quantity: ");
                                                int quantity;
                                                while (true) {
                                                    try {
                                                        quantity = Integer.parseInt(scanner.nextLine());
                                                        break;  // Exit the loop if the input is a valid integer
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Invalid input. Please enter a valid quantity.");
                                                    }
                                                }

                                                double amt = foundatt.getPrice();
                                                SpecialDeals specialdeal = null;
                                                for (SpecialDeals spdeal : spdealslist) {
                                                    if (quantity == spdeal.getTickets()) {
                                                        specialdeal = spdeal;
                                                        amt = spdeal.applyDiscount(foundatt.getPrice());
                                                        break;
                                                    }
                                                }

                                                System.out.println("Enter discount code: ");
                                                String userdisc = scanner.nextLine();
                                                if(userdisc.equalsIgnoreCase("None") || userdisc.isEmpty()){
                                                    System.out.println("No discount coupon used.");
                                                    if(ourvis.getBalance()<amt){
                                                        System.out.println("Insufficient balance!");
                                                    }
                                                    else if(specialdeal!=null){
                                                        if(specialdeal.used == true){
                                                            System.out.println("The ticket for " + foundatt.getName() + " was purchased succesfully.");
                                                            specialdeal.toString();
                                                            ourvis.subBalance(amt);
                                                            int i = 0;
                                                            for(i=0; i<quantity; i++){
                                                                ourvis.purchaseTicket(foundatt);
                                                            }
                                                            System.out.println("Updated balance is Rs. " + ourvis.getBalance() +".");
                                                            specialdeal.used = false;
                                                            foundatt.addTicketed(quantity);
                                                            revenue = revenue + amt;
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("The ticket for " + foundatt.getName() + " was purchased succesfully.");
                                                        ourvis.subBalance(amt);
                                                        int i = 0;
                                                        for(i=0; i<quantity; i++){
                                                            ourvis.purchaseTicket(foundatt);
                                                        }
                                                        foundatt.addTicketed(quantity);
                                                        System.out.println("Updated balance is Rs. " + ourvis.getBalance() +".");
                                                        revenue = revenue + amt;
                                                    }
                                                }
                                                else{
                                                    int conf = 0;
                                                    found = 0;
                                                    for(Discount discount: discountlist){
                                                        if(userdisc.equalsIgnoreCase(discount.getCode())){
                                                            found = 1;
                                                            conf = discount.applyDiscount(ourvis);
                                                            if(conf==1){
                                                                System.out.println("Discount code succesfully applied!");
                                                                amt = amt - amt*discount.getPercentage()/100;
                                                                if(ourvis.getBalance()<amt){
                                                                    System.out.println("Insufficient balance!");
                                                                    break;
                                                                }
                                                                else if(specialdeal!=null){
                                                                    if(specialdeal.used == true){
                                                                        specialdeal.toString();
                                                                        ourvis.subBalance(amt);
                                                                        System.out.println("Updated balance is Rs. " + ourvis.getBalance() +".");
                                                                        int i = 0;
                                                                        for(i=0; i<quantity; i++){
                                                                            ourvis.purchaseTicket(foundatt);
                                                                        }
                                                                        foundatt.addTicketed(quantity);
                                                                        specialdeal.used = false;
                                                                        revenue = revenue + amt;
                                                                        break;
                                                                    }
                                                                }
                                                                else{
                                                                    ourvis.subBalance(amt);
                                                                    foundatt.addTicketed(quantity);
                                                                    System.out.println("Updated balance is Rs. " + ourvis.getBalance() +".");
                                                                    revenue = revenue + amt;
                                                                    break;
                                                                }
                                                            }
                                                            if(conf==0){
                                                                System.out.println("Your age bracket does not qualify for this discount! (Enter 'None' or leave blank if you don't have a coupon!)");
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    if(found==0){
                                                        System.out.println("Invalid discount code!");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                else if(majorchoice.equals("4")){
                                    if(discountlist.isEmpty()){
                                        System.out.println("No discounts currently available!");
                                    }
                                    else{
                                        for(Discount discount: discountlist){
                                            System.out.println(discount.getCategory().toUpperCase() + "(" + discount.getPercentage() + "% discount): " + discount.getCode().toUpperCase());
                                        }
                                    }
                                }

                                else if(majorchoice.equals("5")){
                                    if(spdealslist.isEmpty()){
                                        System.out.println("No special deals currently available!");
                                    }
                                    else{
                                        for(SpecialDeals specialdeal: spdealslist){
                                            System.out.println("Buy " + specialdeal.getTickets() + " tickets and get " + specialdeal.getPercentage() +"% off.");
                                        }
                                    }
                                }

                                else if(majorchoice.equals("6")){
                                    if(ourvis.getType()==null){
                                        System.out.println("You need to buy a membership first!");
                                    }
                                    else{
                                        if(animallist.isEmpty()){
                                            System.out.println("No animals currently available!");
                                        }
                                        else{
                                            for(Animal animal: animallist){
                                                System.out.println("ID: " + animal.getID() + "; " + animal.getName());
                                            }
                                            System.out.print("Enter ID of the animal you want to visit: ");
                                            int chosenani;
                                            while (true) {
                                                try {
                                                    chosenani = Integer.parseInt(scanner.nextLine());
                                                    break;  // Exit the loop if the input is a valid integer
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a valid animal ID.");
                                                }
                                            }

                                            Animal theone = null;
                                            found = 0;
                                            for (Animal animal : animallist) {
                                                if (chosenani == animal.getID()) {
                                                    found = found + 1;
                                                    theone = animal;
                                                    break;
                                                }
                                            }

                                            if(found==0){
                                                System.out.println("Enter a valid animal ID!");
                                            }
                                            else{
                                                System.out.println("1. Feed the animal.");
                                                System.out.println("2. Read about the animal.");
                                                System.out.println("Enter option number: ");
                                                String secondarychoice = scanner.nextLine();
                                                if(!(secondarychoice.equals("1")) && !(secondarychoice.equals("2"))){
                                                    System.out.println("Enter a valid option!");
                                                }
                                                else{
                                                    if(secondarychoice.equals("1")){
                                                        System.out.println(theone.makeSound());
                                                    }
                                                    else if(secondarychoice.equals("2")){
                                                        System.out.println(theone.getHistory());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                else if(majorchoice.equals("7")){
                                    if(attractionlist.isEmpty()){
                                        System.out.println("No attractions currently available!");
                                    }
                                    else{
                                        for(Attraction attraction: attractionlist){
                                            if(attraction.getAvail()==true){
                                                System.out.println("ID: " + attraction.getID() + "; " + attraction.getName());
                                            }
                                        }
                                        System.out.print("Enter ID of the attraction you want to visit: ");
                                        int choice;
                                        while (true) {
                                            try {
                                                choice = Integer.parseInt(scanner.nextLine());
                                                break;  // Exit the loop if the input is a valid integer
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid input. Please enter a valid attraction ID.");
                                            }
                                        }

                                        found = 0;
                                        Attraction chosenatt = null;
                                        for (Attraction attraction : attractionlist) {
                                            if (attraction.getID() == choice) {
                                                found = 1;
                                                chosenatt = attraction;
                                                break;
                                            }
                                        }

                                        if (found == 0) {
                                            System.out.println("Enter a valid attraction ID.");
                                        }

                                        if(found==0){
                                            System.out.println("Enter a valid attraction ID!");
                                        }
                                        else{
                                            if(ourvis.getType()==null){
                                                System.out.println("Cannot visit attractions without buying a membership!");
                                            }
                                            else{
                                                if(ourvis.getType().equalsIgnoreCase("Premium")){
                                                    System.out.println("Welcome to " + chosenatt.getName() + "!");
                                                }
                                                else{
                                                    if(ourvis.getTicketCount(chosenatt)<=0){
                                                        System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                                                    }
                                                    else{
                                                        System.out.println("Welcome to " + chosenatt.getName() + "!");
                                                        ourvis.reduceTicket(chosenatt);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                else if(majorchoice.equals("8")){
                                    System.out.println("Enter feedback: ");
                                    String userfeedback = scanner.nextLine();
                                    if(userfeedback.length() >250){
                                        System.out.println("Enter within 250 characters!");
                                    }
                                    else{
                                        ourvis.setFeedback(userfeedback);
                                        ourvis.associatefeedback();
                                        ourvis.thankfeedback();
                                    }
                                }

                                else if(majorchoice.equals("9")){
                                    System.out.println("Logged out.");
                                    break;
                                }

                                else{
                                    System.out.println("Enter a valid option!");
                                }
                            }
                        }
                    }
                    else if(secondinput.equals("3")){
                        break;
                    }
                }
            }
            else if(firstinput.equals("3")){
                if(spdealslist.isEmpty()){
                    System.out.println("No special deals available right now!");
                }
                else{
                    for(SpecialDeals spdeal: spdealslist){
                        System.out.println("Buy " + spdeal.getTickets() + " tickets and get " + spdeal.getPercentage() + "% off.");
                    }
                }
            }
            else if(firstinput.equals("4")){
                System.exit(0);
            }
            else{
                System.out.println("Enter a valid option!");
            }
        }
    }
}