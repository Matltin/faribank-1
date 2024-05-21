package ir.ac.kntu.Menu.MainMenu;

public enum MainMenuOption {
    ADMIN,
    CUSTOMER,
    EXIT;

    public static void printOption() {
        System.out.println("\n1.Admin\n" +
                "2.Customer\n" +
                "3.Exit\n");
    }
}
