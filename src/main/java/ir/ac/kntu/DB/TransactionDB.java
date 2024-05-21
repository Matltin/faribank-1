package ir.ac.kntu.DB;

import ir.ac.kntu.Transaction.Transaction;

import java.util.LinkedList;
import java.util.List;

public class TransactionDB {
    private List<Transaction> transactions;

    public TransactionDB() {
        transactions = new LinkedList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printTransactions() {
        int counter = 1;
        for(Transaction transaction : transactions) {
            System.out.println(counter + "." + transaction);
            counter++;
        }
    }




}
