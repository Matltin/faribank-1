package ir.ac.kntu.db;

import ir.ac.kntu.person.ContactPerson;

import java.util.LinkedList;
import java.util.List;

public class RecentTransactionDB {
    private List<ContactPerson> contactPersonList;

    public RecentTransactionDB() {
        contactPersonList = new LinkedList<>();
    }

    public List<ContactPerson> getContactPersonList() {
        return contactPersonList;
    }

    public void setContactPersonList(List<ContactPerson> contactPersonList) {
        this.contactPersonList = contactPersonList;
    }

    public void addContactPersonList(ContactPerson contactPerson) {
        contactPersonList.add(contactPerson);
    }

    public void printRecentContact() {
        int counter = 1;
        for(ContactPerson contactPerson : contactPersonList) {
            System.out.println(counter + "." + contactPerson.getFirstName() + " " + contactPerson.getLastName());
            counter++;
        }
    }
}
