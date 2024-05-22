package ir.ac.kntu.person.admin;

import ir.ac.kntu.person.Person;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Admin admin = (Admin) o;
        return Objects.equals(userName, admin.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userName);
    }
}
