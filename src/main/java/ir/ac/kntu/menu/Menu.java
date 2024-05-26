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
        String password;
        do{
            System.out.println("Enter password : ");
            password = ScannerWrapper.getInstance().nextLine();
        } while (!checkPasswordStrength(password));
        return password;
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

    private boolean checkPasswordStrength(String password) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;
        boolean character = false;
        if (password.length() < 8) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                upperCase = true;
            } else if (Character.isLowerCase(password.charAt(i))) {
                lowerCase = true;
            } else if (Character.isDigit(password.charAt(i))) {
                number = true;
            } else if (isCharacter(password.charAt(i))) {
                character = true;
            } else if (isInvalidCharacter(password.charAt(i))) {
                return false;
            }
        }
        if(upperCase && lowerCase && number && character) {
            return true;
        }
        System.out.println("password is too weak!");
        return false;
    }

    private boolean isCharacter(char character) {
        return character == '@' || character == '#' || character == '$' || character == '&' || character == '*';
    }

    private boolean isInvalidCharacter(char character) {
        return character == '~' || character == '!' || character == '^' || character == '(' || character == ')' ||
                character == '-' || character == '/' || character == '=' || character == '"' || character == ':' || character == '`';
    }


}
