package ir.ac.kntu.menu.admin.requst;

public enum RequestMenuOption {
    SEARCH,
    SHOW,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Search\n" +
                "2.Show\n" +
                "3.back\n");
    }
}
