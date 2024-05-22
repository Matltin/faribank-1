package ir.ac.kntu.menu.admin.adminmenu;

public enum AdminMenuOption {
    AUTHENTICATION,
    REQUEST,
    USER_ACCESS,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Authentication\n" +
                "2.Request\n" +
                "3.User access\n" +
                "4.Back\n");
    }
}