package ir.ac.kntu.person.customer;

import ir.ac.kntu.db.ContactPersonDB;
import ir.ac.kntu.db.DB;
import ir.ac.kntu.db.MessageDB;
import ir.ac.kntu.db.RecentTransactionDB;
import ir.ac.kntu.faribank.account.Account;
import ir.ac.kntu.person.ContactPerson;
import ir.ac.kntu.person.Person;

import java.util.Objects;

public class Customer extends Person {

    private String iDocument;
    private String phoneNumber;
    private Account account;
    private ContactPersonDB contactPersonDB;
    private RecentTransactionDB recentTransaction;
    private boolean contactAvailable;
    private State state;
    private MessageDB messageDB;

    public Customer(String firstName, String lastName, String password, String iDocument, String phoneNumber) {
        super(firstName, lastName, password);
        this.iDocument = iDocument;
        this.phoneNumber = phoneNumber;
        contactPersonDB = new ContactPersonDB();
        recentTransaction = new RecentTransactionDB();
        contactAvailable = true;
        state = State.IN_PROGRESSING;
        messageDB = new MessageDB();
    }

    public String getIDocument() {
        return iDocument;
    }

    public void setId(String iDocument) {
        this.iDocument = iDocument;
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

    public void setContactAvailable(boolean contactAvailable) {
        this.contactAvailable = contactAvailable;
    }

    public ContactPersonDB getContactPerson() {
        return contactPersonDB;
    }

    public void setContactPeople(ContactPersonDB contactPersonDB) {
        this.contactPersonDB = contactPersonDB;
    }

    public boolean isContactAvailable() {
        return contactAvailable;
    }

    public RecentTransactionDB getRecentTransaction() {
        return recentTransaction;
    }

    public void setRecentTransaction(RecentTransactionDB recentTransaction) {
        this.recentTransaction = recentTransaction;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public MessageDB getMessageDB() {
        return messageDB;
    }

    public void setMessageDB(MessageDB messageDB) {
        this.messageDB = messageDB;
    }

    public void addContactPerson(String firstName, String lastName, String phoneNumber) {
        String accountNumber = "";
        for (Customer customer : DB.getCustomerDB().getCustomers()) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                accountNumber = customer.getAccount().getAccountNO();
                break;
            }
        }
        try {
            if (!accountNumber.isEmpty()) {
                ContactPerson contactPerson = new ContactPerson(firstName, lastName, phoneNumber, accountNumber);
                contactPersonDB.addContactPerson(contactPerson);
            } else {
                throw new RuntimeException("404 : user not found!!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "phoneNumber='" + phoneNumber + '\'' +
                ", iDocument='" + iDocument + '\'' +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return contactAvailable == customer.contactAvailable && Objects.equals(iDocument, customer.iDocument) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(account, customer.account) && Objects.equals(contactPersonDB, customer.contactPersonDB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iDocument, phoneNumber, account, contactPersonDB, contactAvailable);
    }
}
