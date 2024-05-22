package ir.ac.kntu.menu.customer.settingmenu;

import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.customer.Customer;

public class SettingMenu extends Menu {

    @Override
    public void show() {
        System.out.println("setting menu");
        SettingMenuOption settingMenuOption = printMenuOption();
        while (settingMenuOption != SettingMenuOption.BACK) {
            if(settingMenuOption != null) {
                switch (settingMenuOption) {
                    case EDIT_USER_PASSWORD:
                    case EDIT_CARD_PASSWORD:
                    case ACTIVATION_CONTACT:
                    case UN_ACTIVATION_CONTACT:
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            settingMenuOption = printMenuOption();
        }
    }

    private SettingMenuOption printMenuOption() {
        System.out.println("----------account Menu----------");
        SettingMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(SettingMenuOption.class);
    }

    private void editUserPassword(Customer customer) {
        String password = getPassword();
        customer.setPassword(password);
    }

    private void editCardPassword(Customer customer) {
        System.out.println("this feature is coming soon!!");
    }

    private void activationContact(Customer customer) {
        customer.setContactAvailable(true);
    }

    private void unActivationContact(Customer customer) {
        customer.setContactAvailable(false);
    }
}