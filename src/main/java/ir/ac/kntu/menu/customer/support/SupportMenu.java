package ir.ac.kntu.menu.customer.support;

import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.customer.requestmenu.RequestCustomerMenu;
import ir.ac.kntu.person.customer.Customer;

public class SupportMenu extends Menu {

    private Customer customer;
    private RequestCustomerMenu requestCustMenu;

    public SupportMenu(RequestCustomerMenu requestCustMenu) {
        this.requestCustMenu = requestCustMenu;
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
                        requestCustMenu.show(customer);
                        break;
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
        if(customer.getMessageDB().size() == 0) {
            System.out.println("there is no request to show!!");
            return;
        }
        customer.getMessageDB().printMessage();
        int number = getNumber();
        System.out.println(customer.getMessageDB().getMessageList().get(number - 1));
    }
}
