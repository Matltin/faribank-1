package ir.ac.kntu.Menu.admin.useraccessmenu;

public enum UserAccessMenuOption {
    SHOW_USER,
    SEARCH_USER,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Show user\n" +
                "2.Search user\n" +
                "3.Back\n");
    }
}
