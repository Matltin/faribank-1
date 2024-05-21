package ir.ac.kntu.Message;

public enum MessageOption {
    CONTACT,
    SETTING,
    TRANSFER,
    REPORT,
    BACK;

    public static void printOption() {
        System.out.println("\n1.Contact\n" +
                "2.Setting\n" +
                "3.Transfer\n" +
                "4.Report\n" +
                "5.Back\n");
    }
}
