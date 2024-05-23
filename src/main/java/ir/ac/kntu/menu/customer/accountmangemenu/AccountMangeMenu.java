package ir.ac.kntu.menu.customer.accountmangemenu;

import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.customer.Customer;
import ir.ac.kntu.transaction.Transaction;

public class AccountMangeMenu extends Menu {

    @Override
    public void show() {
        System.out.println("account Menu");
        AccountMangeMenuOption accountMangeMenuOption = printMenuOption();
        while (accountMangeMenuOption != AccountMangeMenuOption.BACK) {
            if (accountMangeMenuOption != null) {
                switch (accountMangeMenuOption) {
                    case INCREASE_CREDIT:
                    case ACCOUNT_BALANCE:
                    case TRANSACTION_LIST:
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            accountMangeMenuOption = printMenuOption();
        }
    }

    private AccountMangeMenuOption printMenuOption() {
        System.out.println("----------account Menu----------");
        AccountMangeMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(AccountMangeMenuOption.class);
    }

    private void increaseCredit(Customer customer) {
        long inputMoney = getInputMoney();
        customer.getAccount().increaseCredit(inputMoney);
    }

    private void showAccountBalance(Customer customer) {
        System.out.println(customer.getAccount().getBalance());
    }

    private void showTransactionList(Customer customer) {
        for (Transaction transaction : customer.getAccount().getTransactionDB().getTransactions()) {
            System.out.println(transaction);
        }
    }
}
