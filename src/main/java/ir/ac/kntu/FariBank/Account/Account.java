package ir.ac.kntu.FariBank.Account;

import ir.ac.kntu.Constance;
import ir.ac.kntu.DB.CustomerDB;
import ir.ac.kntu.DB.DB;
import ir.ac.kntu.DB.TransactionDB;
import ir.ac.kntu.Person.Customer.Customer;

public class Account {

    private long balance;
    private long accountNO;
    private TransactionDB transactionDB;

    public Account(long balance, long accountNO) {
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

    public long getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(long accountNO) {
        this.accountNO = accountNO;
    }

    public void increaseCredit(long inputMoney) {
        setBalance(getBalance() + inputMoney);
    }

    public void transferMoney(long inputMoney, long accountNO) {
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

    public void transferMoneyToCustomer(long money, long accountNO) {
        CustomerDB customers = DB.getCustomerDB();
        Customer customer = customers.findCustomer(accountNO);
        customer.getAccount().increaseCredit(money);
    }
}
