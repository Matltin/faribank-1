package ir.ac.kntu.Menu.admin.loginadminmenu;

public enum LoginAdminMenuOption {
    LOGIN,
    REGISTER,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Login\n" +
                "2.Register\n" +
                "3.Back\n");
    }
}
