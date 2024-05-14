package ir.ac.kntu.Person.Admin;

import ir.ac.kntu.Person.Person;

public class Admin extends Person {

    private String userName;

    public Admin(String firstName, String lastName, String password, String userName) {
        super(firstName, lastName, password);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
