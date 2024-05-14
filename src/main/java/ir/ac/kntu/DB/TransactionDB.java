package ir.ac.kntu.DB;

import ir.ac.kntu.Transaction.Transaction;

import java.util.HashSet;
import java.util.Set;

public class TransactionDB {
    private Set<Transaction> transactions;

    public TransactionDB() {
        transactions = new HashSet<>();
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
