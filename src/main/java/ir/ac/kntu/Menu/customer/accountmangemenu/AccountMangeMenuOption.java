package ir.ac.kntu.Menu.customer.accountmangemenu;

public enum AccountMangeMenuOption {
    INCREASE_CREDIT,
    ACCOUNT_BALANCE,
    TRANSACTION_LIST,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Increase credit\n" +
                "2.Account balance\n" +
                "3.Transaction list\n" +
                "4.Back\n");
    }
}
