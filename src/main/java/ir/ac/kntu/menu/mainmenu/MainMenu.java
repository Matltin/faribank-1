package ir.ac.kntu.menu.mainmenu;

import ir.ac.kntu.Constance;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.admin.loginadminmenu.LoginAdminMenu;
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
                        loginCustomerMenu.show();
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println(Constance.RED + "invalid input!!");
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
