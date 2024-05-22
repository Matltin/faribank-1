package ir.ac.kntu.menu.customer.settingmenu;

public enum SettingMenuOption {
    EDIT_USER_PASSWORD,
    EDIT_CARD_PASSWORD,
    ACTIVATION_CONTACT,
    UN_ACTIVATION_CONTACT,
    BACK;


    public static void printOption() {
        System.out.println("\n1.Edit user password\n" +
                "2.Edit card password\n" +
                "3.Activation contact\n" +
                "4.Un activation contact\n" +
                "5.Back");
    }
}
