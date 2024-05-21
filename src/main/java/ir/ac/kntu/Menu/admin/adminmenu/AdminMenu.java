package ir.ac.kntu.Menu.admin.adminmenu;

import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Menu.customer.CustomerMenu.CustomerMenuOption;

public class AdminMenu extends Menu {
    @Override
    public void show() {
        System.out.println("admin Menu");
        AdminMenuOption adminMenuOption = printMenuOption();
        while (adminMenuOption != AdminMenuOption.BACK) {
            if(adminMenuOption != null) {
                switch (adminMenuOption) {
                    case AUTHENTICATION:
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
}
