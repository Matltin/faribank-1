package ir.ac.kntu;

import ir.ac.kntu.db.*;
import ir.ac.kntu.faribank.account.Account;
import ir.ac.kntu.message.Message;
import ir.ac.kntu.message.MessageOption;
import ir.ac.kntu.person.ContactPerson;
import ir.ac.kntu.person.admin.Admin;
import ir.ac.kntu.person.customer.Customer;
import ir.ac.kntu.transaction.Transaction;
import ir.ac.kntu.transaction.TransactionType;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {

    @Test
    void checkAdminDB() throws ParseException {
        AdminDB adminDB = new AdminDB(new HashSet<>());
        Admin admin1 = new Admin("Matin", "Ahmadi", "1", "m");
        Admin admin2 = new Admin("Erfan", "Dostmohammadi", "2", "e");

        assertEquals(admin1, adminDB.findAdmin(admin1.getUserName()));
        assertNull(adminDB.findAdmin(admin2.getUserName()));
    }

    @Test
    void checkPrintMessageAnswerDB() throws FileNotFoundException {
        FileOutputStream f = new FileOutputStream("outputfile/PrintMessage.txt");
        System.setOut(new PrintStream(f));

        AnswerDB answerDB = new AnswerDB(new ArrayList<>());
        Message message1 = new Message("09102607040", "contact", MessageOption.CONTACT);
        Message message2 = new Message("09059293062", "report", MessageOption.REPORT);
        Message message3 = new Message("09126410299", "setting", MessageOption.SETTING);
        Message message4 = new Message("09136942050", "transfer", MessageOption.TRANSFER);
        answerDB.add(message1);
        answerDB.add(message2);
        answerDB.add(message3);
        answerDB.add(message4);

        answerDB.printMessage();
    }

    @Test
    void checkFindPersonContactPersonDB() {
        ContactPersonDB contactPersonDB = new ContactPersonDB();
        ContactPerson contactPerson1 = new ContactPerson("ali", "mohammadi", "09127428575", "1234");
        ContactPerson contactPerson2 = new ContactPerson("jafar", "ghasemi", "09126547895", "1235");
        contactPersonDB.addContactPerson(contactPerson1);

        assertEquals(contactPerson1, contactPersonDB.findPerson(contactPerson1.getAccountNumber()));
        assertNull(contactPersonDB.findPerson(contactPerson2.getAccountNumber()));
    }

    @Test
    void checkRemovePersonContactPersonDB() {
        ContactPersonDB contactPersonDB = new ContactPersonDB();
        ContactPerson contactPerson1 = new ContactPerson("ali", "mohammadi", "09127428575", "1234");
        ContactPerson contactPerson2 = new ContactPerson("jafar", "ghasemi", "09126547895", "1235");
        contactPersonDB.addContactPerson(contactPerson1);
        contactPersonDB.removePerson(contactPerson1);
        contactPersonDB.removePerson(contactPerson2);

        assertFalse(contactPersonDB.checkContact(contactPerson1.getAccountNumber()));
    }

    @Test
    void checkPrintContactPersonContactPersonDB() throws FileNotFoundException {
        FileOutputStream f = new FileOutputStream("outputfile/PrintContactPerson.txt");
        System.setOut(new PrintStream(f));

        ContactPersonDB contactPersonDB = new ContactPersonDB();
        ContactPerson contactPerson1 = new ContactPerson("ali", "mohammadi", "09127428575", "1234");
        ContactPerson contactPerson2 = new ContactPerson("jafar", "ghasemi", "09126547895", "1235");
        contactPersonDB.addContactPerson(contactPerson1);
        contactPersonDB.addContactPerson(contactPerson2);

        contactPersonDB.printContactPerson();
    }

    @Test
    void checkFindCustomerCustomerDB() {
        CustomerDB customerDB = new CustomerDB(new HashSet<>());
        Customer customer1 = new Customer("ali", "mohsen", "1234", "40214433", "091260377011");
        Customer customer2 = new Customer("erfan", "mohammadi", "1569", "9926213", "09059293062");
        customerDB.addCustomer(customer1);
        customerDB.addCustomer(customer2);

        assertEquals(customer1, customerDB.findCustomer(customer1.getAccount().getAccountNO()));
    }

    @Test
    void checkMessageSizeMessageDB() {
        MessageDB messageDB = new MessageDB();
        Message message1 = new Message("09102607040", "contact", MessageOption.CONTACT);
        Message message2 = new Message("09059293062", "report", MessageOption.REPORT);
        Message message3 = new Message("09126410299", "setting", MessageOption.SETTING);
        Message message4 = new Message("09136942050", "transfer", MessageOption.TRANSFER);
        messageDB.addMessage(message1);
        messageDB.addMessage(message2);
        messageDB.addMessage(message3);
        messageDB.addMessage(message4);

        assertEquals(4, messageDB.size());
    }

    @Test
    void checkPrintMessageDB() throws FileNotFoundException {
        FileOutputStream f = new FileOutputStream("outputfile/PrintMessageDB.txt");
        System.setOut(new PrintStream(f));

        MessageDB messageDB = new MessageDB();
        Message message1 = new Message("09102607040", "contact", MessageOption.CONTACT);
        Message message2 = new Message("09059293062", "report", MessageOption.REPORT);
        Message message3 = new Message("09126410299", "setting", MessageOption.SETTING);
        Message message4 = new Message("09136942050", "transfer", MessageOption.TRANSFER);
        messageDB.addMessage(message1);
        messageDB.addMessage(message2);
        messageDB.addMessage(message3);
        messageDB.addMessage(message4);

        messageDB.printMessage();
    }

    @Test
    void checkPrintTransactionsDB() throws FileNotFoundException {
        FileOutputStream f = new FileOutputStream("outputfile/PrintTransactionDB.txt");
        System.setOut(new PrintStream(f));

        TransactionDB transactionDB = new TransactionDB();
        Transaction transaction1 = new Transaction("kazem", "motalehi", "123456", "654321", TransactionType.TRANSFER);
        Transaction transaction2 = new Transaction("armin", "fakhar", "456789", "654321", TransactionType.TRANSFER);
        Transaction transaction3 = new Transaction("mohammad", "afar", "987654", "654321", TransactionType.TRANSFER);
        Transaction transaction4 = new Transaction("mani", "abodi", "147258", "654321", TransactionType.TRANSFER);
        Transaction transaction5 = new Transaction("matin", "ahmadi", "654321", "654321", TransactionType.INCREASE_CREDIT);
        transactionDB.addTransaction(transaction1);
        transactionDB.addTransaction(transaction2);
        transactionDB.addTransaction(transaction3);
        transactionDB.addTransaction(transaction4);
        transactionDB.addTransaction(transaction5);

        transactionDB.printTransactions();
    }

    @Test
    void checkAccountIncreaseC() {
        CustomerDB customerDB = new CustomerDB(new HashSet<>());
        Customer customer1 = new Customer("ali", "mohsen", "1234", "40214433", "091260377011");
        Customer customer2 = new Customer("erfan", "mohammadi", "1569", "9926213", "09059293062");
        customerDB.addCustomer(customer1);
        customerDB.addCustomer(customer2);
        Account account = new Account(0,customer1.getAccount().getAccountNO());
        account.increaseCredit(10000, customerDB);

        assertEquals(10000, account.getBalance());
    }

    @Test
    void checkAccountTransferMoney() {
        CustomerDB customerDB = new CustomerDB(new HashSet<>());
        Customer customer1 = new Customer("ali", "mohsen", "1234", "40214433", "091260377011");
        Customer customer2 = new Customer("erfan", "mohammadi", "1569", "9926213", "09059293062");
        customerDB.addCustomer(customer1);
        customerDB.addCustomer(customer2);
        Account account = new Account(1500,customer1.getAccount().getAccountNO());
        account.transferMoney(1000, customer2.getAccount().getAccountNO(), customerDB);
        account.transferMoney(100, customer2.getAccount().getAccountNO(), customerDB);

        assertEquals(0, customer1.getAccount().getBalance());
    }
    


}
