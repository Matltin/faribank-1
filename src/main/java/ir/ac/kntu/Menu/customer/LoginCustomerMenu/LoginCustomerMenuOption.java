package ir.ac.kntu.Menu.customer.LoginCustomerMenu;

public enum LoginCustomerMenuOption {
    LOGIN,
    REGISTER,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Login\n" +
                "2.Register\n" +
                "3.Back\n");
    }

}
