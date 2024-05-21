package ir.ac.kntu.Menu.customer.Support;

import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Menu.customer.customermenu.CustomerMenu;
import ir.ac.kntu.Menu.customer.customermenu.CustomerMenuOption;
import ir.ac.kntu.Message.Message;
import ir.ac.kntu.Person.Customer.Customer;

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
