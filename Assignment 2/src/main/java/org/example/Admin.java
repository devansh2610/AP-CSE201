package org.example;

import java.util.ArrayList;

public class Admin extends Auth implements Menu {
    public void basicmenu() {
        System.out.println("Admin Menu:\n" +
                "1. Manage Attractions\n" +
                "2. Manage Animals\n" +
                "3. Schedule Events\n" +
                "4. Set Discounts\n" +
                "5. Set Special Deal\n" +
                "6. View Visitor Stats\n" +
                "7. View Feedback\n" +
                "8. Exit");
    }

    public void secondmenu() {
        System.out.println("Manage Attractions:\n" +
                "1. Add Attraction\n" +
                "2. View Attractions\n" +
                "3. Modify Attraction\n" +
                "4. Remove Attraction\n" +
                "5. Exit");
    }
}
