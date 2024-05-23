package ir.ac.kntu.menu.admin.adminmenu;

import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.admin.requstmenu.RequestAdminMenu;
import ir.ac.kntu.menu.admin.useraccessmenu.UserAccessMenu;
import ir.ac.kntu.message.Message;
import ir.ac.kntu.message.MessageOption;
import ir.ac.kntu.person.admin.Admin;
import ir.ac.kntu.person.customer.Customer;
import ir.ac.kntu.person.customer.State;

public class AdminMenu extends Menu {

    private CustomerDB customerDB;
    private RequestAdminMenu requestAdminMenu;
    private UserAccessMenu userAccessMenu;
    private Admin admin;

    public AdminMenu(CustomerDB customerDB, RequestAdminMenu requestAdminMenu, UserAccessMenu userAccessMenu) {
        this.customerDB = customerDB;
        this.requestAdminMenu = requestAdminMenu;
        this.userAccessMenu = userAccessMenu;
    }

    public void show(Admin admin) {
        this.admin = admin;
        show();
    }

    @Override
    public void show() {
        System.out.println("admin Menu");
        AdminMenuOption adminMenuOption = printMenuOption();
        while (adminMenuOption != AdminMenuOption.BACK) {
            if (adminMenuOption != null) {
                switch (adminMenuOption) {
                    case AUTHENTICATION:
                        authentication();
                        break;
                    case REQUEST:
                        requestAdminMenu.show();
                        break;
                    case USER_ACCESS:
                        userAccessMenu.show();
                        break;
                    default:
                        break;
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
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getState() == State.IN_PROGRESSING) {
                System.out.println(counter + "." + customer);
                counter++;
            }
        }
        if(customerDB.size() == 0) {
            System.out.println("it is empty!!");
            return;
        }
        int number = getNumber();

        String yesOrNo = getYesNo();
        if(yesOrNo.equals("Y")) {
            accessCustomer(number);
        } else if(yesOrNo.equals("N")) {
            rejectCustomer(number);
        } else {
            System.out.println("invalid input!!");
        }
    }

    public void accessCustomer(int number) {
        int counter = 0;
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getState() == State.IN_PROGRESSING) {
                counter++;
                if (counter == number) {
                    customer.setState(State.ACCEPTED);
                    System.out.println("the state is changed!!");
                    break;
                }
            }
        }
    }

    public void rejectCustomer(int number) {
        int counter = 0;
        for (Customer customer : customerDB.getCustomers()) {
            if (customer.getState() == State.IN_PROGRESSING) {
                counter++;
                if (counter == number) {
                    customer.setState(State.REJECT);
                    String message = getMessage();
                    Message newMessage = new Message(customer.getPhoneNumber(), "", MessageOption.REPORT);
                    newMessage.setMessageAnswer(message);
                    customer.getMessageDB().addMessage(newMessage);
                    System.out.println("the state is changed!!");
                    break;
                }
            }
        }
    }
}
