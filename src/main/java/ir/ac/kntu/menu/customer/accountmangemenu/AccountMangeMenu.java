package ir.ac.kntu.menu.customer.accountmangemenu;

import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.person.customer.Customer;
import ir.ac.kntu.transaction.Transaction;

public class AccountMangeMenu extends Menu {

    private Customer customer;
    private CustomerDB customerDB;

    public AccountMangeMenu(CustomerDB customerDB) {
        this.customerDB = customerDB;
    }

    public void show(Customer customer){
        this.customer = customer;
        show();
    }

    @Override
    public void show() {
        System.out.println("account Menu");
        AccountMangeMenuOption accountMangeMenuOption = printMenuOption();
        while (accountMangeMenuOption != AccountMangeMenuOption.BACK) {
            if (accountMangeMenuOption != null) {
                switch (accountMangeMenuOption) {
                    case INCREASE_CREDIT:
                        increaseCredit();
                        break;
                    case ACCOUNT_BALANCE:
                        showAccountBalance();
                        break;
                    case TRANSACTION_LIST:
                        showTransactionList();
                        break;
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

    private void increaseCredit() {
        long inputMoney = getInputMoney();
        customer.getAccount().increaseCredit(inputMoney, customerDB);
    }

    private void showAccountBalance() {
        System.out.println(customer.getAccount().getBalance());
    }

    private void showTransactionList() {
        for (Transaction transaction : customer.getAccount().getTransactionDB().getTransactions()) {
            System.out.println(transaction);
        }
    }
}
