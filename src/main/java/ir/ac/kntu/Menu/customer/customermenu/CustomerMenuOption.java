package ir.ac.kntu.Menu.customer.customermenu;

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
                "3.Contact menu" +
                "4.Support\n" +
                "5.Setting\n" +
                "6.Back");
    }

}
