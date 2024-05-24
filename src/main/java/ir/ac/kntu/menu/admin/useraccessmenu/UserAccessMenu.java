package ir.ac.kntu.menu.admin.useraccessmenu;

import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.admin.searchusermenu.SearchUserMenu;
import ir.ac.kntu.person.customer.Customer;

public class UserAccessMenu extends Menu {

    private CustomerDB customerDB;
    private SearchUserMenu searchUserMenu;

    public UserAccessMenu(CustomerDB customerDB, SearchUserMenu searchUserMenu) {
        this.customerDB = customerDB;
        this.searchUserMenu = searchUserMenu;
    }

    @Override
    public void show() {
        System.out.println("user access menu");
        UserAccessMenuOption userAccessMenuOption = printMenuOption();
        while (userAccessMenuOption != UserAccessMenuOption.BACK) {
            if (userAccessMenuOption != null) {
                switch (userAccessMenuOption) {
                    case SHOW_USER:
                        showUser();
                        break;
                    case SEARCH_USER:
                        searchUserMenu.show();
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            userAccessMenuOption = printMenuOption();
        }
    }

    private UserAccessMenuOption printMenuOption() {
        System.out.println("----------user access Menu----------");
        UserAccessMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(UserAccessMenuOption.class);
    }

    private void showUser() {
        int counter = 1;
        for (Customer customer : customerDB.getCustomers()) {
            System.out.println(counter + ". " + customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPhoneNumber());
            counter++;
        }
        if(customerDB.size() == 0) {
            System.out.println("it is empty!!");
        }

    }
}
