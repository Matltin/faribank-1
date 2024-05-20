package ir.ac.kntu.Menu.customer.LoginCustomerMenu;

import ir.ac.kntu.DB.DB;
import ir.ac.kntu.Menu.customer.MainMenu.MainMenuOption;
import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Person.Customer.Customer;

public class LoginCustomerMenu extends Menu {

    @Override
    public void show() {
        System.out.println("logging page");
        LoginCustomerMenuOption loginCustomerMenuOption = printMenuOption();
        while (loginCustomerMenuOption != LoginCustomerMenuOption.BACK) {
            if(loginCustomerMenuOption != null) {
                switch (loginCustomerMenuOption) {
                    case LOGIN:
                        login();
                    case REGISTER:
//                        register();
                    default:
                        break;
                }
            }
            loginCustomerMenuOption = printMenuOption();
        }
    }

    private LoginCustomerMenuOption printMenuOption() {
        System.out.println("----------logging Menu----------");
        MainMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(LoginCustomerMenuOption.class);
    }

    private void login() {
        String iDocument = getIDocument();
        String phoneNumber = getPhoneNumber();
        Customer cust = null;
        for(Customer customer : DB.getCustomerDB().getCustomers()) {
            if(customer.getId().equals(iDocument) && customer.getPhoneNumber().equals(phoneNumber)) {
                cust = customer;
                break;
            }
        }
        if(cust != null) {

        } else {
            System.out.println("IDocument or PhoneNumber is invalid!!");
        }
    }
}
