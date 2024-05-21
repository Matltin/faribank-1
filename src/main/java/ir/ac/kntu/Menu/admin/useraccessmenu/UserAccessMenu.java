package ir.ac.kntu.Menu.admin.useraccessmenu;

import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Menu.admin.adminmenu.AdminMenuOption;

public class UserAccessMenu extends Menu {
    @Override
    public void show() {
        System.out.println("user access menu");
        UserAccessMenuOption userAccessMenuOption = printMenuOption();
        while (userAccessMenuOption != UserAccessMenuOption.BACK) {
            if(userAccessMenuOption != null) {
                switch (userAccessMenuOption) {
                    case BY_FIRST_NAME:
                    case BY_LAST_NAME:
                    case BY_PHONE_NUMBER:
                    case BY_FIRST_LAST_NAME:
                    case BY_FIRST_NAME_PHONE_NUMBER:
                    case BY_LAST_NAME_PHONE_NUMBER:
                    case BY_FIRST_LAST_NAME_PHONE_NUMBER:
                    default:
                        break;
                }
            }
        }

    }

    private UserAccessMenuOption printMenuOption() {
        System.out.println("----------customer Menu----------");
        UserAccessMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(UserAccessMenuOption.class);
    }
}
