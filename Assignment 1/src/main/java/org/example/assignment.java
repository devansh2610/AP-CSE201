package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

class Member {
    int memberID;
    String name;
    int age;
    String phoneNumber;
    ArrayList<Book> issuedbooks;
    double fine;
    boolean fineneeded;
    double totalfine;

    public Member(int memberID, String name, int age, String phoneNumber) {
        this.memberID = memberID;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.issuedbooks = new ArrayList<>();
        this.fine = 0.0;
        this.fineneeded = false;
        this.totalfine = 0.0;
    }

    int getMemberID() {
        return memberID;
    }

    String getName() {
        return name;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    double getFine(){
        return fine;
    }

    double getTotalFine() {
        return totalfine;
    }
}

class MemberIdGenerator {
    static int memberidcount = 0;
    static int generateUniqueId() {
        return ++memberidcount;
    }
}

class Book {
    int bookID;
    String title;
    String author;
    int totalCopies;
    long issuetime;
    long returntime;
    boolean returned;
    boolean timeexceed;

    public Book(int bookID, String title, String author, int totalCopies) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.issuetime = 0;
        this.returntime = 0;
        this.returned = true;
        this.timeexceed = false;
    }

    int getBookID() {
        return bookID;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }
}

class BookIdGenerator {
    static int bookidcount = 0;
    static int generateUniqueId() {
        return ++bookidcount;
    }
}

public class assignment {
    public static void main(String[] args) {
        int bookcount = 0;
        ArrayList<Book> booklist = new ArrayList<Book>();
        ArrayList<Member> memberlist = new ArrayList<Member>();
        ArrayList<Book> issuedbookslist = new ArrayList<Book>();
        List<Member> membersToRemove = new ArrayList<>();
        List<Book> booksToRemove = new ArrayList<>();
        List<Book> booksToReturn = new ArrayList<>();

        while (true) {
            System.out.println("1. Enter as a librarian");
            System.out.println("2. Enter as a member");
            System.out.println("3. Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter option number: ");
            Scanner scanner = new Scanner(System.in);
            String firstinput = scanner.nextLine();
            System.out.println("-----------------------------");

            if (firstinput.equals("1")) { //ENTER AS A LIBRARIAN
                while (true) {
                    System.out.println("1. Register a member\n" + "2. Remove a member\n" + "3. Add a book\n" + "4. Remove a book\n" +
                            "5. View all members along with their books and fines to be paid\n" + "6. View all books\n" + "7. Back\n");
                    System.out.println("-----------------------------");
                    System.out.print("Enter option number: ");
                    String secondinput = scanner.nextLine();
                    System.out.println("-----------------------------");

                    if (secondinput.equals("1")) {
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Phone number: ");
                        String phone = scanner.nextLine();
                        int age;
                        while (true) {
                            try {
                                System.out.print("Age: ");
                                age = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid integer for age.");
                            }
                        }

                        int found = 0;
                        for (Member member : memberlist) {
                            if (member.getPhoneNumber().equals(phone)) {
                                System.out.println("Member with this phone number already exists!");
                                System.out.println("-----------------------------");
                                found = found + 1;
                                break;
                            }
                        }
                        if (found == 0) {
                            Member newmember = new Member(MemberIdGenerator.generateUniqueId(), name, age, phone);
                            memberlist.add(newmember);
                            System.out.println("Member successfully registered with member ID: " + newmember.getMemberID());
                            System.out.println("-----------------------------");
                        }
                    }

                    else if (secondinput.equals("2")) {
                        for (Member member : memberlist) {
                            System.out.println("ID: " + member.getMemberID() + "; Name: " + member.getName() + "; Phone number: " + member.getPhoneNumber());
                        }
                        System.out.print("Enter phone number of the member to be removed: ");
                        String removephone = scanner.nextLine();
                        int found = 0;
                        for (Member member : memberlist) {
                            if (member.getPhoneNumber().equals(removephone)) {
                                found = found + 1;
                                if (member.issuedbooks.size() > 0) {
                                    System.out.println("Cannot remove this member yet: He/She has a book already issued.");
                                    break;
                                } else {
                                    memberlist.remove(member);
                                }
                                //membersToRemove.add(member);
                                System.out.println("Member successfully removed!");
                                System.out.println("-----------------------------");
                                break;
                            }
                        }

                        /*if (found!=0) {
                            memberlist.removeAll(membersToRemove);
                            membersToRemove.clear();
                        }*/

                        if (found == 0) {
                            System.out.println("Invalid phone number: Member with this phone number does not exist.");
                            System.out.println("-----------------------------");
                        }
                    }

                    else if (secondinput.equals("3")) {
                        System.out.print("Enter book title: ");
                        String booktitle = scanner.nextLine();
                        System.out.print("Enter author's name: ");
                        String authorname = scanner.nextLine();
                        System.out.print("Enter number of copies: ");
                        int copies = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < copies; i++) {
                            Book newbook = new Book(BookIdGenerator.generateUniqueId(), booktitle, authorname, copies);
                            booklist.add(newbook);
                        }

                        System.out.println("Books Added Successfully!");
                        System.out.println("-----------------------------");
                    }

                    else if (secondinput.equals("4")) {
                        for (Book book : booklist) {
                            System.out.println("ID: " + book.getBookID() + "; Title: " + book.getTitle());
                        }
                        System.out.print("Enter book ID to be removed: ");
                        int bookdelinput = scanner.nextInt();
                        scanner.nextLine();
                        int found = 0;
                        for (Book book : booklist) {
                            if (bookdelinput == book.getBookID()) {
                                found = found + 1;
                                if (issuedbookslist.contains(book)) {
                                    System.out.println("Cannot remove this book since it has been currently issued to a user.");
                                } else {
                                    booklist.remove(book);
                                    System.out.println("The book has been successfully removed!");
                                    System.out.println("-----------------------------");
                                    break;
                                }
                            }
                        }
                        /*if (found!=0) {
                            booklist.removeAll(booksToRemove);
                            booksToRemove.clear();
                        }*/

                            if (found == 0) {
                                System.out.println("The book does not exist in the library!");
                                System.out.println("-----------------------------");
                            }
                        }

                    else if (secondinput.equals("5")) {
                        double currentTime = System.currentTimeMillis();

                        System.out.println("List of all members along with their issued books and fines as of now:");
                        System.out.println("-------------------------------------------------------------");

                        for (Member member : memberlist) {
                            StringBuilder issuedBooksInfo = new StringBuilder();
                            double totalFine = 0.0; // Initialize totalFine for the member

                            for (Book book : member.issuedbooks) {
                                long issueTime = book.issuetime;
                                int timeDiff = (int) ((currentTime - issueTime) / 1000);

                                if (timeDiff > 10) {
                                    totalFine += timeDiff * 3; // Calculate the fine based on the time difference
                                }

                                issuedBooksInfo.append(book.getTitle()).append(", ");
                            }

                            String booksInfo = issuedBooksInfo.toString();

                            if (booksInfo.length() > 0) {
                                // Remove the trailing ", " from the string
                                booksInfo = booksInfo.substring(0, booksInfo.length() - 2);
                            } else {
                                booksInfo = "None"; // If no books are issued
                            }

                            System.out.println("ID: " + member.getMemberID() + "; Name: " + member.getName() + "; Books: " + booksInfo + "; Fine: " + totalFine);
                        }

                        System.out.println("-------------------------------------------------------------");
                    }


                        else if (secondinput.equals("6")) {
                            for (Book book : booklist) {
                                if (issuedbookslist.contains(book)) {
                                    System.out.println("ID: " + book.getBookID() + "; Title: " + book.getTitle() + " by " + book.getAuthor() + "(Has already been issued by someone)");
                                } else {
                                    System.out.println("ID: " + book.getBookID() + "; Title: " + book.getTitle() + " by " + book.getAuthor());
                                }
                            }
                            System.out.println("-----------------------------");
                        }

                        else if (secondinput.equals("7")) {
                            System.out.println("-----------------------------");
                            break;
                        }

                        else{
                            System.out.println("Enter a valid option.");
                        }
                    }
                }


                else if (firstinput.equals("2")) { //ENTER AS A MEMBER
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Phone number: ");
                    String phone = scanner.nextLine();
                    int found = 0;
                    Member loggedin = new Member(0, "blank", 0, "0");
                    for (Member member : memberlist) {
                        if (member.getPhoneNumber().equals(phone) && member.getName().equals(name)) {
                            loggedin = member;
                            found = found + 1;
                            System.out.println("Welcome " + member.getName() + ". Your member ID is: " + member.getMemberID());
                            break;
                        }
                    }
                    if (found == 0) {
                        System.out.println("Member " + name + " with phone number " + phone + "does not exist.");
                    } else {
                        while (true) {
                            System.out.println("1. List Available Books\n" + "2. List My Books\n" + "3. Issue book\n" + "4. Return book\n" + "5. Pay Fine\n" + "6. Back");
                            System.out.println("-----------------------------");
                            System.out.print("Enter option number: ");
                            String secondinput = scanner.nextLine();


                            if (secondinput.equals("1")) {
                                for (Book book : booklist) {
                                    if (issuedbookslist.contains(book)) {
                                        System.out.println("ID: " + book.getBookID() + "; Title: " + book.getTitle() + " by " + book.getAuthor() + "(Has already been issued by someone)");
                                    } else {
                                        System.out.println("ID: " + book.getBookID() + "; Title: " + book.getTitle() + " by " + book.getAuthor());
                                    }
                                }
                                System.out.println("-----------------------------");
                            }

                            else if (secondinput.equals("2")) {
                                if (loggedin.issuedbooks.size() <= 0) {
                                    System.out.println("You don't have any issued books!");
                                } else {
                                    for (Book book : loggedin.issuedbooks) {
                                        System.out.println("BOOK ID: " + book.getBookID() + "; " + book.getTitle() + " by " + book.getAuthor());
                                    }
                                }
                                System.out.println("-----------------------------");
                            }

                            else if (secondinput.equals("3")) {
                                long currenttime = System.currentTimeMillis();
                                if (loggedin.issuedbooks.size() >= 2) {
                                    System.out.println("You already have 2 books currently issued.");
                                    System.out.println("-----------------------------");
                                } else {
                                    if (issuedbookslist.size() == booklist.size()) {
                                        System.out.println("No books are available to be issued currently.");
                                        System.out.println("-----------------------------");
                                    } else {
                                        System.out.println("Books available for being issued: ");
                                        System.out.println("-----------------------------");
                                        for (Book book : booklist) {
                                            if (!(issuedbookslist.contains(book))) {
                                                System.out.println("ID: " + book.getBookID() + "; Title: " + book.getTitle() + " by " + book.getAuthor());
                                            }
                                        }
                                        System.out.print("Enter ID of the book you want to issue: ");
                                        int selectbook = scanner.nextInt();
                                        scanner.nextLine();
                                        Book bookselected = new Book(9999, "blank", "unknown", 0);
                                        int foundbook = 0;
                                        boolean flag = false;
                                        for (Book book : booklist) {
                                            if (book.getBookID() == selectbook) {
                                                foundbook = 1;
                                                if (issuedbookslist.contains(book)) {
                                                    System.out.println("This book with BOOK ID: " + book.getBookID() + " has already been issued to someone else.");
                                                    System.out.println("-----------------------------");
                                                    flag = true;
                                                } else {
                                                    bookselected = book;
                                                }
                                            }
                                        }
                                        if (found == 0) {
                                            System.out.println("Enter a valid BOOK ID");
                                            System.out.println("-----------------------------");
                                        } else {
                                            for (Book book : loggedin.issuedbooks) {
                                                int timediff = (int) ((currenttime - book.issuetime) / 1000);
                                                if (timediff > 10) {
                                                    loggedin.fineneeded = true;
                                                    book.timeexceed = true;
                                                }
                                            }
                                            if (loggedin.fineneeded == true) {
                                                System.out.println("You need to pay previous fine to issue new books!");
                                                System.out.println("-----------------------------");
                                            }
                                        }

                                        if (flag == false) {
                                            if (loggedin.fineneeded == false) {
                                                loggedin.issuedbooks.add(bookselected);
                                                bookselected.issuetime = System.currentTimeMillis();
                                                issuedbookslist.add(bookselected);
                                                bookselected.returned = false;
                                                System.out.println("This book has been succesfully issued to you!");
                                                System.out.println("-----------------------------");
                                            }
                                        }
                                    }
                                }
                                System.out.println("-----------------------------");
                            }

                            else if (secondinput.equals("4")) {
                                long currenttime = System.currentTimeMillis();
                                if (loggedin.issuedbooks.size() <= 0) {
                                    System.out.println("You don't have any issued books!");
                                    System.out.println("-----------------------------");
                                } else {
                                    System.out.println("Your currently issued books are: ");
                                    System.out.println("-----------------------------");
                                    for (Book book : loggedin.issuedbooks) {
                                        System.out.println("BOOK ID: " + book.getBookID() + "; " + book.getTitle() + " by " + book.getAuthor());
                                    }
                                    System.out.print("Enter BOOK ID of the book you want to return: ");
                                    int selectbook = scanner.nextInt();
                                    scanner.nextLine();
                                    int foundbook = 0;
                                    for (Book book : loggedin.issuedbooks) {
                                        if (book.getBookID() == selectbook) {
                                            foundbook = 1;
                                            loggedin.fine = 0;
                                            book.returntime = currenttime;
                                            int timediff = (int) ((book.returntime - book.issuetime) / 1000);
                                            if (timediff > 10) {
                                                loggedin.fineneeded = true;
                                                loggedin.fine = loggedin.fine + timediff * 3;
                                                //book.issuetime = 0;
                                                //book.returntime = 0;
                                                //loggedin.issuedbooks.remove(book);
                                                booksToReturn.add(book);
                                                issuedbookslist.remove(book);
                                                book.returned = true;
                                                book.timeexceed = true;
                                                System.out.println("Your fine of Rs. " + loggedin.getFine() + " has been registered (still due) and the book has been returned with a delay of "
                                                + timediff + " days.");
                                                loggedin.totalfine = loggedin.totalfine + loggedin.fine;
                                                System.out.println("-----------------------------");
                                            } else {
                                                //loggedin.fineneeded = false;
                                                book.returned = true;
                                                book.timeexceed = false;
                                                issuedbookslist.remove(book);
                                                //loggedin.issuedbooks.remove(book);
                                                booksToReturn.add(book);
                                                System.out.println("Your book has been returned.");
                                                System.out.println("-----------------------------");
                                            }
                                        }
                                    }

                                    loggedin.issuedbooks.removeAll(booksToReturn);
                                    booksToReturn.clear();

                                    if (foundbook == 0) {
                                        System.out.println("Enter a valid BOOK ID.");
                                        System.out.println("-----------------------------");
                                    }
                                }
                            }

                            else if (secondinput.equals("5")) {
                                long currenttime = System.currentTimeMillis();
                                for (Book book : loggedin.issuedbooks) {
                                    int timediff = (int) ((currenttime - book.issuetime) / 1000);
                                    if (timediff > 10) {
                                        loggedin.fineneeded = true;
                                        book.timeexceed = true;
                                    }
                                }
                                if (loggedin.fineneeded == false) {
                                    System.out.println("You don't have any fine to pay!");
                                    System.out.println("-----------------------------");
                                } else {
                                    int count = 0;
                                    for (Book book : loggedin.issuedbooks) {
                                        if (book.timeexceed == true && book.returned == false) {
                                            System.out.println("You need to first return the book " + book.getTitle() + " by " + book.getAuthor() + " (BOOK ID: " + book.getBookID() + ")");
                                            count = count + 1;
                                        }
                                    }
                                    if (count == 0) {
                                        System.out.println("Your total fine of Rs " + loggedin.getTotalFine() +  " has been paid.");
                                        System.out.println("-----------------------------");
                                        loggedin.fine = 0;
                                        loggedin.totalfine = 0;
                                        loggedin.fineneeded = false;
                                    }
                                }
                            }

                            else if (secondinput.equals("6")) {
                                break;
                            }

                            else{
                                System.out.println("Enter a valid option.");
                            }
                        }
                    }
                }

                else if (firstinput.equals("3")) {
                    System.exit(0);
                }

                else{
                    System.out.println("Enter a valid input.");
                }
            }
        }
    }