package ir.ac.kntu.menu.customer.accountmangemenu.recenttransactionmenu;

public enum RecentTransactionMenuOption {
    BY_NUMBER,
    BY_TIME,
    ALL,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Search by number\n" +
                "2.search by time\n" +
                "3.All\n" +
                "4.Back\n");
    }
}
