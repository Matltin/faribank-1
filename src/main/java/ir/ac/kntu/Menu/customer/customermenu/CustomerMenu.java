package ir.ac.kntu.Menu.customer.customermenu;

import ir.ac.kntu.Menu.Menu;

public class CustomerMenu extends Menu {

    @Override
    public void show() {
        System.out.println("customer Menu");
        CustomerMenuOption customerMenuOption = printMenuOption();
        while (customerMenuOption != CustomerMenuOption.BACK) {
            if(customerMenuOption != null) {
                switch (customerMenuOption) {
                    case TRANSFER_MONEY:
                    case ACCOUNT_MANAGE:
                    case CONTACT_MENU:
                    case SUPPORT:
                    case SETTING:
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            customerMenuOption = printMenuOption();
        }
    }

    private CustomerMenuOption printMenuOption() {
        System.out.println("----------customer Menu----------");
        CustomerMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(CustomerMenuOption.class);
    }
}
