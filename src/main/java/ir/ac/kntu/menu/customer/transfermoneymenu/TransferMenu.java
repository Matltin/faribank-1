package ir.ac.kntu.menu.customer.transfermoneymenu;

import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.ContactPerson;
import ir.ac.kntu.person.customer.Customer;

public class TransferMenu extends Menu {

    private CustomerDB customerDB;
    private Customer customer;

    public TransferMenu(CustomerDB customerDB) {
        this.customerDB = customerDB;
    }

    public void show(Customer customer) {
        this.customer = customer;
        show();
    }

    @Override
    public void show() {
        System.out.println("transfer menu");
        TransferMenuOption transferMenuOption = printMenuOption();
        while (transferMenuOption != TransferMenuOption.BACK) {
            if (transferMenuOption != null) {
                switch (transferMenuOption) {
                    case TRANSFER_MONEY_RECENT_ACCOUNT:
                        transferByRecentAccount();
                        break;
                    case TRANSFER_MONEY_CONTACT:
                        transferByContact();
                        break;
                    case TRANSFER_MONEY_ACCOUNT:
                        transferByAccount();
                        break;
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

    private void transferByRecentAccount() {
        customer.getRecentTransaction().printRecentContact();
        int number = getNumber();
        if (0 < number && number <= customer.getRecentTransaction().getContactPersonList().size()) {
            ContactPerson contactPerson = customer.getRecentTransaction().getContactPersonList().get(number - 1);
            long inputMoney = getInputMoney();
            customer.getAccount().transferMoney(inputMoney, contactPerson.getAccountNumber(), customerDB);
        } else {
            System.out.println("Number out of range!");
        }
    }

    private void transferByContact() {
        int number;
        if (customer.isContactAvailable()) {
            customer.getContactPerson().printContactPerson();
            number = getNumber();
            if (0 < number && number <= customer.getContactPerson().getContactPerson().size()) {
                checkContact(number);
            } else {
                System.out.println("Number out of range!");
            }
        } else {
            System.out.println("Access to contacts is closed");
        }
    }

    private void transferByAccount() {
        String accountNo = getAccountNumber();
        Customer cust = customerDB.findCustomer(accountNo);
        if (cust != null) {
            long inputMoney = getInputMoney();
            customer.getAccount().transferMoney(inputMoney, accountNo, customerDB);
            ContactPerson contactPerson1 = new ContactPerson(cust.getFirstName(), cust.getLastName(), cust.getPhoneNumber(), cust.getAccount().getAccountNO());
            customer.getRecentTransaction().addContactPersonList(contactPerson1);
        } else {
            System.out.println("There is co person with this account number !!");
        }
    }

    private void checkContact(int number) {
        ContactPerson contactPerson = customer.getContactPerson().getContactPerson().get(number - 1);
        Customer cust = customerDB.findCustomer(contactPerson.getAccountNumber());
        if (cust.getContactPerson().checkContact(customer.getAccount().getAccountNO())) {
            long inputMoney = getInputMoney();
            customer.getAccount().transferMoney(inputMoney, cust.getAccount().getAccountNO(), customerDB);
            ContactPerson contactPerson1 = new ContactPerson(cust.getFirstName(), cust.getLastName(), cust.getPhoneNumber(), cust.getAccount().getAccountNO());
            customer.getRecentTransaction().addContactPersonList(contactPerson1);
        } else {
            System.out.println("your are not contact of " + cust.getFirstName() + " " + cust.getFirstName());
        }
    }
}
