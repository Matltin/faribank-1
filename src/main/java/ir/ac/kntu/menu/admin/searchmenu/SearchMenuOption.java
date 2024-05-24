package ir.ac.kntu.menu.admin.searchmenu;

public enum SearchMenuOption {
    STATE,
    BRANCH,
    USER,
    BACK;

    public static void printOption() {
        System.out.println("\n1.State\n" +
                "2.Branch\n" +
                "3.User\n" +
                "4.Back\n");
    }
}
