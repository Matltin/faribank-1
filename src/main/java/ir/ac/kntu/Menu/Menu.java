package ir.ac.kntu.Menu;

import ir.ac.kntu.util.ScannerWrapper;

public abstract class Menu {

    public abstract void show();

    public <T extends Enum<T>> T getOption(Class<T> tEnum) {
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine()) - 1;
        T[] options = tEnum.getEnumConstants();
        if (choice >= 0 && choice < options.length) {
            return options[choice];
        }
        System.out.println("Wrong choice!");
        return null;
    }

    public String getFirstName() {
        System.out.println("Enter first name : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getLastName() {
        System.out.println("Enter last name : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getIDocument() {
        System.out.println("Enter id : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getPhoneNumber() {
        System.out.println("Enter Phone number : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public Long getInputMoney() {
        System.out.println("Enter the money : ");
        return ScannerWrapper.getInstance().nextLong();
    }

    public Integer getNumber() {
        System.out.println("Enter number : ");
        return ScannerWrapper.getInstance().nextInt();
    }

    public String getAccountNumber() {
        System.out.println("Enter Account number : ");
        return ScannerWrapper.getInstance().next();
    }

    public String getDate() {
        System.out.println("Enter date : ");
        return ScannerWrapper.getInstance().next();
    }

    public String getPassword() {
        System.out.println("Enter password : ");
        return ScannerWrapper.getInstance().next();
    }


}
