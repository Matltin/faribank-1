package ir.ac.kntu.menu.admin.requstmenu;

public enum RequestAdminMenuOption {
    SEARCH,
    SHOW,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Search\n" +
                "2.Show\n" +
                "3.back\n");
    }
}
