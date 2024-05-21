package ir.ac.kntu.Menu.admin.loginadminmenu;

import ir.ac.kntu.DB.DB;
import ir.ac.kntu.Menu.MainMenu.MainMenuOption;
import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Person.Admin.Admin;

public class LoginAdminMenu extends Menu {
    @Override
    public void show() {
        System.out.println("logging page");
        LoginAdminMenuOption loginAdminMenuOption = printMenuOption();
        while (loginAdminMenuOption != LoginAdminMenuOption.BACK) {
            if(loginAdminMenuOption != null) {
                switch (loginAdminMenuOption) {
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
            loginAdminMenuOption = printMenuOption();
        }
    }

    private LoginAdminMenuOption printMenuOption() {
        System.out.println("----------logging Menu----------");
        MainMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(LoginAdminMenuOption.class);
    }

    private void login() {
        String userName = getUserName();
        String password = getPassword();
        for(Admin admin : DB.getAdminDB().getAdmins()) {
            if(admin.getUserName().equals(userName) && admin.getPassword().equals(password)) {

                return;
            }
        }
        System.out.println("invalid username or password");
    }

    private void register() {
        System.out.println("nadarim hanoz!" +
                "zoor nazan farsi neveshtam!!");
    }
}
