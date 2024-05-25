package ir.ac.kntu.menu.customer.support;

import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.customer.requestmenu.RequestCustomerMenu;
import ir.ac.kntu.person.customer.Customer;

public class SupportMenu extends Menu {

    private Customer customer;
    private RequestCustomerMenu requestCustomerMenu;

    public SupportMenu(RequestCustomerMenu requestCustomerMenu) {
        this.requestCustomerMenu = requestCustomerMenu;
    }

    public void show(Customer customer) {
        this.customer = customer;
        show();
    }

    @Override
    public void show() {
        SupportMEnuOption supportMEnuOption = printMenuOption();
        while (supportMEnuOption != SupportMEnuOption.BACK) {
            if (supportMEnuOption != null) {
                switch (supportMEnuOption) {
                    case REQUEST:
                        requestCustomerMenu.show(customer);
                    case SHOW_REQUEST:
                        showRequest();
                        break;
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

    private void showRequest() {
        customer.getMessageDB().printMessage();
        int number = getNumber();
        System.out.println(customer.getMessageDB().getMessageList().get(number - 1));
    }
}
