package ir.ac.kntu.menu.customer.settingmenu;

import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.customer.Customer;

public class SettingMenu extends Menu {

    private Customer customer;

    public void show(Customer customer) {
        this.customer = customer;
        show();
    }

    @Override
    public void show() {
        System.out.println("setting menu");
        SettingMenuOption settingMenuOption = printMenuOption();
        while (settingMenuOption != SettingMenuOption.BACK) {
            if (settingMenuOption != null) {
                switch (settingMenuOption) {
                    case EDIT_USER_PASSWORD -> editUserPassword();
                    case EDIT_CARD_PASSWORD -> editCardPassword();
                    case ACTIVATION_CONTACT -> activationContact();
                    case UN_ACTIVATION_CONTACT -> unActivationContact();
                    default -> System.out.print("");
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

    private void editUserPassword() {
        String password = getPassword();
        customer.setPassword(password);
    }

    private void editCardPassword() {
        String password = getCardPassword();
    }

    private void activationContact() {
        customer.setContactAvailable(true);
    }

    private void unActivationContact() {
        customer.setContactAvailable(false);
    }
}
