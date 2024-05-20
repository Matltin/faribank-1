package ir.ac.kntu.Menu.customer.contactmenu;

public enum ContactMenuOption {
    SHOW_CONTACT_LIST,
    EDIT_CONTACT_INFO,
    ADD_CONTACT,
    BACK;

    public static void printOption() {
        System.out.println("\n1.show contact list\n" +
                "2.Edit contact info\n" +
                "3.Add contact\n" +
                "4.Back\n");
    }
}
