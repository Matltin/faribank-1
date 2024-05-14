package ir.ac.kntu.Transaction;

import ir.ac.kntu.util.Calendar;

import java.util.Date;
import java.util.Random;

public class Transaction {

    private String firstNameDestination;
    private String lastNameDestination;
    private Date date;
    private String formatDate;
    private String destinationAccountNO;
    private String sourceAccountNO;
    private String followupNumber;    // شناره پیگیری

    public Transaction(String firstNameDestination, String lastNameDestination,
                       String destinationAccountNO, String sourceAccountNO) {
        this.firstNameDestination = firstNameDestination;
        this.lastNameDestination = lastNameDestination;
        this.date = Calendar.getDate();
        this.formatDate = Calendar.getDateFormat(date);
        this.destinationAccountNO = destinationAccountNO;
        this.sourceAccountNO = sourceAccountNO;
        this.followupNumber = getRandom();
    }

    private String getRandom() {
        int max=9999,min=1000;
        int number = min + (int)(Math.random() * ((max - min) + 1));
        return String.valueOf(number);

    }
}
