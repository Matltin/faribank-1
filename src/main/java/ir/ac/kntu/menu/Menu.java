package ir.ac.kntu.menu;

import ir.ac.kntu.Constance;
import ir.ac.kntu.util.ScannerWrapper;

import java.text.ParseException;

public abstract class Menu {

    public abstract void show() throws ParseException;

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
        String phoneNumber;
        do {
            System.out.println("Enter Phone number : ");
            phoneNumber = ScannerWrapper.getInstance().nextLine();

        } while (!checkPhoneNumber(phoneNumber));
        return phoneNumber;
    }

    public Long getInputMoney() {
        System.out.println("Enter the money : ");
        return Long.valueOf(ScannerWrapper.getInstance().nextLine());
    }

    public Integer getNumber() {
        System.out.println("Enter number : ");
        return Integer.valueOf(ScannerWrapper.getInstance().nextLine());
    }

    public String getAccountNumber() {
        System.out.println("Enter Account number : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getDate() {
        System.out.println("Enter date : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getPassword() {
        System.out.println("Enter password : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getUserName() {
        System.out.println("Enter userName : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getMessage() {
        System.out.println("Enter Message : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getYesNo() {
        System.out.println("Do you want accept ? (Y/N) : ");
        return ScannerWrapper.getInstance().nextLine();
    }


    private boolean checkPhoneNumber(String phoneNumber) {
        if(!phoneNumber.matches("^(09)[0-9]{9}")) {
            System.out.println(Constance.RED + "invalid phoneNumber format!!" + Constance.RESET);
            return false;
        }
        return true;
    }




}
