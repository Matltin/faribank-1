package ir.ac.kntu.menu.customer.support;

import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.customer.Customer;

public class SupportMenu extends Menu {
    @Override
    public void show() {
        SupportMEnuOption supportMEnuOption = printMenuOption();
        while (supportMEnuOption != SupportMEnuOption.BACK) {
            if(supportMEnuOption != null) {
                switch (supportMEnuOption) {
                    case REQUEST:
                    case SHOW_REQUEST:
//                        showRequest();
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            supportMEnuOption = printMenuOption();
        }

    }

    private SupportMEnuOption printMenuOption() {
        System.out.println("----------customer Menu----------");
        SupportMEnuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(SupportMEnuOption.class);
    }

    private void showRequest(Customer customer) {
        customer.getMessageDB().printMessage();
        int number = getNumber();
        System.out.println(customer.getMessageDB().getMessageList().get(number - 1));
    }
}
