package ir.ac.kntu.FariBank.Account;

import ir.ac.kntu.Constance;
import ir.ac.kntu.DB.CustomerDB;
import ir.ac.kntu.DB.DB;
import ir.ac.kntu.DB.TransactionDB;
import ir.ac.kntu.Person.Customer.Customer;
import ir.ac.kntu.Transaction.Transaction;

public class Account {

    private long balance;
    private String accountNO;
    private TransactionDB transactionDB;

    public Account(long balance, String accountNO) {
        this.balance = balance;
        this.accountNO = accountNO;
        transactionDB = new TransactionDB();
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(String accountNO) {
        this.accountNO = accountNO;
    }

    public void increaseCredit(long inputMoney) {
        setBalance(getBalance() + inputMoney);
    }

    public void transferMoney(long inputMoney, String accountNO) {
        try {
            if (inputMoney + Constance.WAGE <= balance) {
                setBalance(getBalance() - inputMoney - Constance.WAGE);
                transferMoneyToCustomer(inputMoney, accountNO);
            } else {
                throw new RuntimeException("input money : " + inputMoney + " Your balance!!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void transferMoneyToCustomer(long money, String accountNO) {
        CustomerDB customers = DB.getCustomerDB();
        Customer customer = customers.findCustomer(accountNO);
        customer.getAccount().increaseCredit(money);
        Transaction transaction = new Transaction(customer.getFirstName(), customer.getLastName(), customer.getAccount().getAccountNO(), getAccountNO());
        transactionDB.addTransaction(transaction);
    }
}
