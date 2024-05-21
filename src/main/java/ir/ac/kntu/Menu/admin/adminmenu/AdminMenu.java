package ir.ac.kntu.Menu.admin.adminmenu;

import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Menu.customer.CustomerMenu.CustomerMenuOption;

public class AdminMenu extends Menu {
    @Override
    public void show() {
        System.out.println("admin Menu");
        AdminMenuOption adminMenuOption = printMenuOption();
    }

    private AdminMenuOption printMenuOption() {
        System.out.println("----------customer Menu----------");
        AdminMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(AdminMenuOption.class);
    }
}
