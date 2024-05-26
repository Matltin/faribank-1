package ir.ac.kntu.menu.customer.customermenu;

public enum CustomerMenuOption {
    TRANSFER_MONEY,
    ACCOUNT_MANAGE,
    CONTACT_MENU,
    SUPPORT,
    SETTING,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Transfer money\n" +
                "2.Account mange\n" +
                "3.Contact menu\n" +
                "4.Support\n" +
                "5.Setting\n" +
                "6.Back\n");
    }

}
