package ir.ac.kntu.Menu.admin.adminmenu;

import ir.ac.kntu.DB.DB;
import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Person.Customer.Customer;
import ir.ac.kntu.Person.Customer.State;

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
            if (customer.getState() == State.PROGRESSING) {
                System.out.println(counter + "." + customer);
                counter++;
            }
        }
        int number = getNumber();
        counter = 0;
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if (customer.getState() == State.PROGRESSING) {
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
