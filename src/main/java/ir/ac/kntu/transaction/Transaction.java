package ir.ac.kntu.transaction;

import ir.ac.kntu.util.Calendar;

import java.util.Date;

public class Transaction {

    private String firstNameDestination;
    private String lastNameDestination;
    private Date date;
    private String formatDate;
    private String destinationAccountNO;
    private String sourceAccountNO;
    private TransactionType transactionType;
    private String followupNumber;    // شناره پیگیری

    public Transaction(String firstNameDestination, String lastNameDestination,
                       String destinationAccountNO, String sourceAccountNO, TransactionType transactionType) {
        this.firstNameDestination = firstNameDestination;
        this.lastNameDestination = lastNameDestination;
        this.date = Calendar.getDate();
        this.formatDate = Calendar.getDateFormat(date);
        this.destinationAccountNO = destinationAccountNO;
        this.sourceAccountNO = sourceAccountNO;
        this.followupNumber = getRandom();
        this.transactionType = transactionType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDate() {
        return date;
    }

    private String getRandom() {
        int max = 9999, min = 1000;
        int number = min + (int) (Math.random() * ((max - min) + 1));
        return String.valueOf(number);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "followupNumber='" + followupNumber + '\'' +
                ", transactionType=" + transactionType +
                ", sourceAccountNO='" + sourceAccountNO + '\'' +
                ", destinationAccountNO='" + destinationAccountNO + '\'' +
                ", formatDate='" + formatDate + '\'' +
                ", lastNameDestination='" + lastNameDestination + '\'' +
                ", firstNameDestination='" + firstNameDestination + '\'' +
                '}';
    }
}
