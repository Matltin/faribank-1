package ir.ac.kntu.Menu.customer.LoginCustomerMenu;

import ir.ac.kntu.DB.DB;
import ir.ac.kntu.Menu.MainMenu.MainMenuOption;
import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Person.Customer.Customer;

public class LoginCustomerMenu extends Menu {

    @Override
    public void show() {
        System.out.println("logging page");
        LoginCustomerMenuOption loginCustomerMenuOption = printMenuOption();
        while (loginCustomerMenuOption != LoginCustomerMenuOption.BACK) {
            if (loginCustomerMenuOption != null) {
                switch (loginCustomerMenuOption) {
                    case LOGIN:
                        login();
                    case REGISTER:
                        register();
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            loginCustomerMenuOption = printMenuOption();
        }
    }

    private LoginCustomerMenuOption printMenuOption() {
        System.out.println("----------logging Menu----------");
        LoginCustomerMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(LoginCustomerMenuOption.class);
    }

    private void login() {
        String iDocument = getIDocument();
        String phoneNumber = getPhoneNumber();
        Customer cust = null;
        for (Customer customer : DB.getCustomerDB().getCustomers()) {
            if (customer.getIDocument().equals(iDocument) && customer.getPhoneNumber().equals(phoneNumber)) {
                cust = customer;
                break;
            }
        }
        if (cust != null) {

        } else {
            System.out.println("IDocument or PhoneNumber is invalid!!");
        }
    }

    private void register() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String phoneNumber = getPhoneNumber();
        String iDocument = getIDocument();
        String password = getPassword();
        for (Customer customer : DB.getCustomerDB().getCustomers()) {
            if (customer.getPhoneNumber().equals(phoneNumber) || customer.getIDocument().equals(iDocument)) {
                System.out.println("the phone number or the iDocument is already exist");
                return;
            }
        }
        while (!checkPassword(password)) {
            System.out.println("password is too weak!");
            System.out.println("password must have lower case and upperCase and numeric and special character(@,#,$,&,*)");
            password = getPassword();
        }
        Customer customer = new Customer(firstName, lastName, password, iDocument, phoneNumber);
        DB.getCustomerDB().addCustomer(customer);
    }

    private boolean checkPassword(String password) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;
        boolean character = false;
        if (password.length() < 8) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                upperCase = true;
            } else if (Character.isLowerCase(password.charAt(i))) {
                lowerCase = true;
            } else if (Character.isDigit(password.charAt(i))) {
                number = true;
            } else if (isCharacter(password.charAt(i))) {
                character = true;
            } else if (isInvalidCharacter(password.charAt(i))) {
                return false;
            }
        }
        return upperCase && lowerCase && number && character;
    }

    private boolean isCharacter(char ch) {
        return ch == '@' || ch == '#' || ch == '$' || ch == '&' || ch == '*';
    }

    private boolean isInvalidCharacter(char ch) {
        return ch == '~' || ch == '!' || ch == '^' || ch == '(' || ch == ')' ||
                ch == '-' || ch == '/' || ch == '=' || ch == '"' || ch == ':' || ch == '`';
    }
}
