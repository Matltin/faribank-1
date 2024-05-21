package ir.ac.kntu.Menu.MainMenu;

import ir.ac.kntu.Menu.Menu;

public class MainMenu extends Menu {


    @Override
    public void show() {
        System.out.println("Welcome to Fari Bank");
        MainMenuOption mainMenuOption = printMenuOptions();
        while (mainMenuOption != MainMenuOption.EXIT) {
            if (mainMenuOption != null) {
                switch (mainMenuOption) {
                    case ADMIN:
                    case CUSTOMER:

                    default:
                        break;
                }
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
