package ir.ac.kntu.menu.admin.adminmenu;

import ir.ac.kntu.db.DB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.customer.Customer;
import ir.ac.kntu.person.customer.State;

public class AdminMenu extends Menu {
    @Override
    public void show() {
        System.out.println("admin Menu");
        AdminMenuOption adminMenuOption = printMenuOption();
        while (adminMenuOption != AdminMenuOption.BACK) {
            if(adminMenuOption != null) {
                switch (adminMenuOption) {
                    case AUTHENTICATION:
                        authentication();
                    case REQUEST:
                    case USER_ACCESS:
                }
            } else {
                System.out.println("invalid input!!");
            }
            adminMenuOption = printMenuOption();
        }
    }

    private AdminMenuOption printMenuOption() {
        System.out.println("----------admin Menu----------");
        AdminMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(AdminMenuOption.class);
    }

    private void authentication() {
        int counter = 1;
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if (customer.getState() == State.IN_PROGRESSING) {
                System.out.println(counter + "." + customer);
                counter++;
            }
        }
        int number = getNumber();
        counter = 0;
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if (customer.getState() == State.IN_PROGRESSING) {
                counter++;
                if(counter == number) {
                    customer.setState(State.ACCEPTED);
                    System.out.println("the state is changed!!");
                    break;
                }
            }
        }
    }
}
