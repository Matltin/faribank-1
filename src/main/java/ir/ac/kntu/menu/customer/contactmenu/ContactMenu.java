package ir.ac.kntu.menu.customer.contactmenu;

import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.ContactPerson;
import ir.ac.kntu.person.customer.Customer;

public class ContactMenu extends Menu {
    @Override
    public void show() {
        System.out.println("contact menu");
        ContactMenuOption contactMenuOption = printMenuOption();
        while (contactMenuOption != ContactMenuOption.BACK) {
            if (contactMenuOption != null) {
                switch (contactMenuOption) {
                    case SHOW_CONTACT_LIST:
                    case EDIT_CONTACT_INFO:
                    case ADD_CONTACT:
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

    public void showContactList(Customer customer) {
        int number;
        customer.getContactPerson().printContactPerson();
        number = getNumber();
        if (0 < number && number <= customer.getContactPerson().getContactPerson().size()) {
            System.out.println(customer.getContactPerson().getContactPerson().get(number - 1));
        } else {
            System.out.println("Number out of range!");
        }
    }

    public void editContactINFO(Customer customer) {
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

    public void addContact(Customer customer) {
//        String firstName = getFirstName();
//        String lastName = getLastName();
//        String phoneNumber = getPhoneNumber();
//        if (customer.getContactPerson().findPerson(phoneNumber) != null) {
//            System.out.println("The contact is already exist");
//            return;
//        }
//        customer.addContactPerson(firstName, lastName, phoneNumber);
    }
}
