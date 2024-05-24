package ir.ac.kntu.menu.customer.contactmenu;

import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.ContactPerson;
import ir.ac.kntu.person.customer.Customer;

public class ContactMenu extends Menu {

    private Customer customer;
    private CustomerDB customerDB;

    public ContactMenu(CustomerDB customerDB) {
        this.customerDB = customerDB;
    }

    public void show(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void show() {
        System.out.println("contact menu");
        ContactMenuOption contactMenuOption = printMenuOption();
        while (contactMenuOption != ContactMenuOption.BACK) {
            if (contactMenuOption != null) {
                switch (contactMenuOption) {
                    case SHOW_CONTACT_LIST:
                        showContactList();
                        break;
                    case EDIT_CONTACT_INFO:
                        editContactINFO();
                        break;
                    case ADD_CONTACT:
                        addContact();
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input");
            }
            contactMenuOption = printMenuOption();
        }
    }

    private ContactMenuOption printMenuOption() {
        System.out.println("----------account Menu----------");
        ContactMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(ContactMenuOption.class);
    }

    private void showContactList() {
        int number;
        customer.getContactPerson().printContactPerson();
        number = getNumber();
        if (0 < number && number <= customer.getContactPerson().getContactPerson().size()) {
            System.out.println(customer.getContactPerson().getContactPerson().get(number - 1));
        } else {
            System.out.println("Number out of range!");
        }
    }

    private void editContactINFO() {
        String phoneNumber = getPhoneNumber();
        ContactPerson contactPerson = customer.getContactPerson().findPerson(phoneNumber);
        if (contactPerson != null) {
            customer.getContactPerson().removePerson(contactPerson);
            String firstName = getFirstName();
            String lastName = getLastName();
            contactPerson.setFirstName(firstName);
            contactPerson.setLastName(lastName);
            customer.getContactPerson().addContactPerson(contactPerson);
        } else {
            System.out.println("contact not found!!");
        }
    }

    private void addContact() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String phoneNumber = getPhoneNumber();
        if (customer.getContactPerson().findPerson(phoneNumber) != null) {
            System.out.println("The contact is already exist");
            return;
        }
        customer.addContactPerson(firstName, lastName, phoneNumber, customerDB);
    }
}
