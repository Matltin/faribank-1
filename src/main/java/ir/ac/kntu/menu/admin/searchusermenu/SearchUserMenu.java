package ir.ac.kntu.menu.admin.searchusermenu;

import ir.ac.kntu.Constance;
import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.customer.Customer;

public class SearchUserMenu extends Menu {

    private CustomerDB customerDB;

    public SearchUserMenu(CustomerDB customerDB) {
        this.customerDB = customerDB;
    }

    @Override
    public void show() {
        System.out.println("search menu");
        SearchUserMenuOption usrAcsMenuOption = printMenuOption();
        while (usrAcsMenuOption != SearchUserMenuOption.BACK) {
            if (usrAcsMenuOption != null) {
                switch (usrAcsMenuOption) {
                    case BY_FIRST_NAME -> searchByFirstName();
                    case BY_LAST_NAME -> searchByLastName();
                    case BY_PHONE_NUMBER -> searchByPhoneNumber();
                    case BY_FIRST_LAST_NAME -> searchByFirstLastName();
                    case BY_FIRST_NAME_PHONE_NUMBER -> searchByFirstNamePhoneNumber();
                    case BY_LAST_NAME_PHONE_NUMBER -> searchByLastNamePhoneNumber();
                    case BY_FIRST_LAST_NAME_PHONE_NUMBER -> searchByFirstLastNamePhoneNumber();
                    default -> System.out.print("");
                }
            } else {
                System.out.println("invalid input!!");
            }
            usrAcsMenuOption = printMenuOption();
        }
    }

    private SearchUserMenuOption printMenuOption() {
        System.out.println("----------search Menu----------");
        SearchUserMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(SearchUserMenuOption.class);
    }

    private void searchByFirstName() {
        if(customerDB.size() == 0) {
            System.out.println(Constance.RED + "there is no customer to show" + Constance.RESET);
            return;
        }
        String firstName = getFirstName();
        int counter = 1;
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getFirstName().equals(firstName)) {
                System.out.println(counter + "." + customer + " " + customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByLastName() {
        if(customerDB.size() == 0) {
            System.out.println(Constance.RED + "there is no customer to show" + Constance.RESET);
            return;
        }
        int counter = 1;
        String lastName = getLastName();
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getLastName().equals(lastName)) {
                System.out.println(counter + "." + customer + " " + customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByPhoneNumber() {
        if(customerDB.size() == 0) {
            System.out.println(Constance.RED + "there is no customer to show" + Constance.RESET);
            return;
        }
        int counter = 1;
        String phoneNumber = getPhoneNumber();
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(counter + "." + customer + " " + customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByFirstLastName() {
        if(customerDB.size() == 0) {
            System.out.println(Constance.RED + "there is no customer to show" + Constance.RESET);
            return;
        }
        int counter = 1;
        String firstName = getFirstName();
        String lastName = getLastName();
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
                System.out.println(counter + "." + customer + " " + customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByFirstNamePhoneNumber() {
        if(customerDB.size() == 0) {
            System.out.println(Constance.RED + "there is no customer to show" + Constance.RESET);
            return;
        }
        int counter = 1;
        String firstName = getFirstName();
        String phoneNumber = getPhoneNumber();
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getFirstName().equals(firstName) && customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(counter + "." + customer + " " + customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByLastNamePhoneNumber() {
        if(customerDB.size() == 0) {
            System.out.println(Constance.RED + "there is no customer to show" + Constance.RESET);
            return;
        }
        int counter = 1;
        String lastName = getLastName();
        String phoneNumber = getPhoneNumber();
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getLastName().equals(lastName) && customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(counter + "." + customer + " " + customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByFirstLastNamePhoneNumber() {
        if(customerDB.size() == 0) {
            System.out.println(Constance.RED + "there is no customer to show" + Constance.RESET);
            return;
        }
        int counter = 1;
        String firstName = getFirstName();
        String lastName = getLastName();
        String phoneNumber = getPhoneNumber();
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName) && customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(counter + "." + customer + " " + customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }
}
