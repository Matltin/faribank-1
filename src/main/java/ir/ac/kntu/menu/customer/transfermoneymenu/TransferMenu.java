package ir.ac.kntu.menu.customer.transfermoneymenu;

import ir.ac.kntu.db.DataBase;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.ContactPerson;
import ir.ac.kntu.person.customer.Customer;

public class TransferMenu extends Menu {

    @Override
    public void show() {
        System.out.println("transfer menu");
        TransferMenuOption transferMenuOption = printMenuOption();
        while (transferMenuOption != TransferMenuOption.BACK) {
            if (transferMenuOption != null) {
                switch (transferMenuOption) {
                    case TRANSFER_MONEY_RECENT_ACCOUNT:
                    case TRANSFER_MONEY_CONTACT:
                    case TRANSFER_MONEY_ACCOUNT:
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            transferMenuOption = printMenuOption();
        }
    }

    private TransferMenuOption printMenuOption() {
        System.out.println("----------customer Menu----------");
        TransferMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(TransferMenuOption.class);
    }

    private void transferByRecentAccount(Customer customer) {
        customer.getRecentTransaction().printRecentContact();
        int number = getNumber();
        if (0 < number && number <= customer.getRecentTransaction().getContactPersonList().size()) {
            ContactPerson contactPerson = customer.getRecentTransaction().getContactPersonList().get(number - 1);
            long inputMoney = getInputMoney();
//            customer.getAccount().transferMoney(inputMoney, customer.getAccount().getAccountNO());
        } else {
            System.out.println("Number out of range!");
        }

    }

    private void transferByContact(Customer customer) {
        int number;
        if (customer.isContactAvailable()) {
            customer.getContactPerson().printContactPerson();
            number = getNumber();
            if (0 < number && number <= customer.getContactPerson().getContactPerson().size()) {
                checkContact(number, customer);
            } else {
                System.out.println("Number out of range!");
            }
        } else {
            System.out.println("Access to contacts is closed");
        }
    }

    private void transferByAccount(Customer customer) {
        String accountNo = getAccountNumber();
//        Customer cust = DataBase.getCustomerDB().findCustomer(accountNo);
//        if (cust != null) {
//            long inputMoney = getInputMoney();
//            customer.getAccount().transferMoney(inputMoney, accountNo);
//            ContactPerson contactPerson1 = new ContactPerson(cust.getFirstName(), cust.getLastName(), cust.getPhoneNumber(), cust.getAccount().getAccountNO());
//            customer.getRecentTransaction().addContactPersonList(contactPerson1);
//        } else {
//            System.out.println("There is co person with this account number !!");
//        }
    }

    private void checkContact(int number, Customer customer) {
//        ContactPerson contactPerson = customer.getContactPerson().getContactPerson().get(number - 1);
//        Customer cust = DataBase.getCustomerDB().findCustomer(contactPerson.getAccountNumber());
//        if (cust.getContactPerson().checkContact(customer.getAccount().getAccountNO())) {
//            long inputMoney = getInputMoney();
//            customer.getAccount().transferMoney(inputMoney, cust.getAccount().getAccountNO());
//            ContactPerson contactPerson1 = new ContactPerson(cust.getFirstName(), cust.getLastName(), cust.getPhoneNumber(), cust.getAccount().getAccountNO());
//            customer.getRecentTransaction().addContactPersonList(contactPerson1);
//        } else {
//            System.out.println("your are not contact of " + cust.getFirstName() + " " + cust.getFirstName());
//        }
    }
}
