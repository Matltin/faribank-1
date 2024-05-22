package ir.ac.kntu.menu.admin.useraccessmenu;

import ir.ac.kntu.db.DB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.customer.Customer;

public class UserAccessMenu extends Menu {
    @Override
    public void show() {
        System.out.println("user access menu");
        UserAccessMenuOption userAccessMenuOption = printMenuOption();
        while (userAccessMenuOption != UserAccessMenuOption.BACK) {
            if (userAccessMenuOption != null) {
                switch (userAccessMenuOption) {
                    case SHOW_USER:
                        showUser();
                    case SEARCH_USER:
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
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            System.out.println(counter + ". " + customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPhoneNumber());
            counter++;
        }

    }
}
