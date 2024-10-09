package org.example;

class Auth {
    private String username;
    private String password;

    public int authentication(String user, String pass) {
        this.username = "admin";
        this.password = "admin123";
        if (user.equals(this.username) && pass.equals(this.password)) {
            System.out.println("Logged in As Admin.");
            System.out.print("\n");
            return 1;
        } else {
            System.out.println("Incorrect Admin credentials.");
            System.out.print("\n");
            return 0;
        }
    }

    public String getUsername() {
        return "admin";
    }

    public String getPassword() {
        return "admin123";
    }

    public void setUsername(String user) {
        System.out.println("Admin username is not changeable!");
    }

    public void setPassword(String pass) {
        System.out.println("Admin password is not changeable!");
    }
}
