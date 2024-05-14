package ir.ac.kntu.Person.Customer;

import ir.ac.kntu.FariBank.Account.Account;
import ir.ac.kntu.Person.Person;

public class Customer extends Person {

    private String id;
    private String phoneNumber;
    private Account account;

    public Customer(String firstName, String lastName, String password, String id, String phoneNumber) {
        super(firstName, lastName, password);
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
