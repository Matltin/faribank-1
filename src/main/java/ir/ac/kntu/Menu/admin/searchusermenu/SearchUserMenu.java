package ir.ac.kntu.Menu.admin.searchusermenu;

import ir.ac.kntu.DB.DB;
import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Person.Customer.Customer;

public class SearchUserMenu extends Menu {
    @Override
    public void show() {
        System.out.println("search menu");
        SearchUserMenuOption userAccessMenuOption = printMenuOption();
        while (userAccessMenuOption != SearchUserMenuOption.BACK) {
            if(userAccessMenuOption != null) {
                switch (userAccessMenuOption) {
                    case BY_FIRST_NAME:
                        searchByFirstName();
                        break;
                    case BY_LAST_NAME:
                        searchByLastName();
                        break;
                    case BY_PHONE_NUMBER:
                        searchByPhoneNumber();
                        break;
                    case BY_FIRST_LAST_NAME:
                        searchByFirstLastName();
                        break;
                    case BY_FIRST_NAME_PHONE_NUMBER:
                        searchByFirstNamePhoneNumber();
                        break;
                    case BY_LAST_NAME_PHONE_NUMBER:
                        searchByLastNamePhoneNumber();
                        break;
                    case BY_FIRST_LAST_NAME_PHONE_NUMBER:
                        searchByFirstLastNamePhoneNumber();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private SearchUserMenuOption printMenuOption() {
        System.out.println("----------search Menu----------");
        SearchUserMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(SearchUserMenuOption.class);
    }

    private void searchByFirstName(){
        String firstName = getFirstName();
        int counter = 1;
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if(customer.getFirstName().equals(firstName)) {
                System.out.println(counter + "." + customer + " " +customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }
    private void searchByLastName(){
        int counter = 1;
        String lastName = getLastName();
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if(customer.getLastName().equals(lastName)) {
                System.out.println(counter + "." + customer + " " +customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByPhoneNumber(){
        int counter = 1;
        String phoneNumber = getPhoneNumber();
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if(customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(counter + "." + customer + " " +customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByFirstLastName(){
        int counter = 1;
        String firstName = getFirstName();
        String lastName = getLastName();
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if(customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
                System.out.println(counter + "." + customer + " " +customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByFirstNamePhoneNumber(){
        int counter = 1;
        String firstName = getFirstName();
        String phoneNumber = getPhoneNumber();
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if(customer.getFirstName().equals(firstName) && customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(counter + "." + customer + " " +customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByLastNamePhoneNumber(){
        int counter = 1;
        String lastName = getLastName();
        String phoneNumber = getPhoneNumber();
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if(customer.getLastName().equals(lastName) && customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(counter + "." + customer + " " +customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }

    private void searchByFirstLastNamePhoneNumber(){
        int counter = 1;
        String firstName = getFirstName();
        String lastName = getLastName();
        String phoneNumber = getPhoneNumber();
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if(customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName) && customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(counter + "." + customer + " " +customer.getAccount().getTransactionDB());
                counter++;
            }
        }
    }
}
