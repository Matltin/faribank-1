package ir.ac.kntu.menu.mainmenu;

import ir.ac.kntu.db.AdminDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.admin.adminmenu.AdminMenu;
import ir.ac.kntu.menu.admin.loginadminmenu.LoginAdminMenu;
import ir.ac.kntu.menu.customer.customermenu.CustomerMenu;
import ir.ac.kntu.menu.customer.logincustomermenu.LoginCustomerMenu;

public class MainMenu extends Menu {

    private LoginAdminMenu loginAdminMenu;
    private LoginCustomerMenu loginCustomerMenu;

    public MainMenu(LoginAdminMenu loginAdminMenu, LoginCustomerMenu loginCustomerMenu) {
        this.loginAdminMenu = loginAdminMenu;
        this.loginCustomerMenu = loginCustomerMenu;
    }

    @Override
    public void show() {
        System.out.println("Welcome to Fari Bank");
        MainMenuOption mainMenuOption = printMenuOptions();
        while (mainMenuOption != MainMenuOption.EXIT) {
            if (mainMenuOption != null) {
                switch (mainMenuOption) {
                    case ADMIN:
                        loginAdminMenu.show();
                        break;
                    case CUSTOMER:
                        loginAdminMenu.show();
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            mainMenuOption = printMenuOptions();
        }
    }

    private MainMenuOption printMenuOptions() {
        System.out.println("----------main Menu----------");
        MainMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(MainMenuOption.class);
    }
}
