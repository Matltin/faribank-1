package ir.ac.kntu.Menu.customer.accountmangemenu.recenttransactionmenu;

import ir.ac.kntu.Menu.Menu;
import ir.ac.kntu.Person.Customer.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecentTransactionMenu extends Menu {
    @Override
    public void show() {
        System.out.println("search by");
        RecentTransactionMenuOption recentTransactionMenuOption = printMenuOption();
        while (recentTransactionMenuOption != RecentTransactionMenuOption.BACK) {
            if(recentTransactionMenuOption != null) {
                switch (recentTransactionMenuOption) {
                    case BY_NUMBER:
                    case BY_TIME:
                    case ALL:
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            recentTransactionMenuOption = printMenuOption();
        }
    }

    private RecentTransactionMenuOption printMenuOption() {
        System.out.println("----------search by----------");
        RecentTransactionMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(RecentTransactionMenuOption.class);
    }

    private void searchByNumber(Customer customer) {
        try {
            int number = getNumber();
            int size = customer.getAccount().getTransactionDB().getTransactions().size();
            if (size == 0) {
                throw new RuntimeException("there is no transaction yet!");
            }
            for (int i = size - 1; i > size - number; i--) {
                System.out.println(customer.getAccount().getTransactionDB().getTransactions().get(i));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void searchByTime(Customer customer) throws ParseException {
        String firstStr = getDate();
        String secondStr = getDate();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd -- HH:mm:ss");

        Date firstDate = simpleDateFormat.parse(firstStr);
        Date secondDate = simpleDateFormat.parse(secondStr);

        int size = customer.getAccount().getTransactionDB().getTransactions().size();
        for(int i = size - 1; i >= 0; i++) {
            long time = customer.getAccount().getTransactionDB().getTransactions().get(i).getDate().getTime();
            if(firstDate.getTime() <= time && time <= secondDate.getTime()) {
                System.out.println(customer.getAccount().getTransactionDB().getTransactions().get(i));
            }
        }
    }

    private void searchAll(Customer customer) {
        try {
            int size = customer.getAccount().getTransactionDB().getTransactions().size();
            if (size == 0) {
                throw new RuntimeException("there is no transaction yet!");
            }
            for (int i = size - 1; i >= 0; i--) {
                System.out.println(customer.getAccount().getTransactionDB().getTransactions().get(i));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
