package ir.ac.kntu.Menu.customer.Support;

public enum SupportMEnuOption {
    REQUEST,
    SHOW_REQUEST,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Request\n" +
                "2.Show request\n" +
                "3.Back\n");
    }
}
