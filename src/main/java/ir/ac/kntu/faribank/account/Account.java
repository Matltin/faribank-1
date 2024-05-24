package ir.ac.kntu.faribank.account;

import ir.ac.kntu.Constance;
import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.db.DataBase;
import ir.ac.kntu.db.TransactionDB;
import ir.ac.kntu.person.customer.Customer;
import ir.ac.kntu.transaction.Transaction;
import ir.ac.kntu.transaction.TransactionType;

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

    public void increaseCredit(long inputMoney, CustomerDB customerDB) {
        setBalance(getBalance() + inputMoney);
        Customer customer = customerDB.findCustomer(accountNO);
        Transaction transaction = new Transaction(customer.getFirstName(), customer.getLastName(), customer.getAccount().getAccountNO(), getAccountNO(), TransactionType.INCREASE_CREDIT);
        transactionDB.addTransaction(transaction);
    }

    public TransactionDB getTransactionDB() {
        return transactionDB;
    }

    public void setTransactionDB(TransactionDB transactionDB) {
        this.transactionDB = transactionDB;
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

    private void transferMoneyToCustomer(long money, String accountNO) {
        CustomerDB customers = DataBase.getCustomerDB();
        Customer customer = customers.findCustomer(accountNO);
        customer.getAccount().setBalance(money + getBalance());
        Transaction transaction = new Transaction(customer.getFirstName(), customer.getLastName(), customer.getAccount().getAccountNO(), getAccountNO(), TransactionType.TRANSFER);
        transactionDB.addTransaction(transaction);
    }
}
