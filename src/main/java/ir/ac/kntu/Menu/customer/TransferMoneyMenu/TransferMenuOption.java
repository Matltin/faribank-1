package ir.ac.kntu.Menu.customer.TransferMoneyMenu;

public enum TransferMenuOption {
    TRANSFER_MONEY_RECENT_ACCOUNT,
    TRANSFER_MONEY_CONTACT,
    TRANSFER_MONEY_ACCOUNT,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Transfer money by recent account\n" +
                "2.Transfer money by contact\n" +
                "3.Transfer money by Account\n" +
                "4.Back\n");
    }
}
