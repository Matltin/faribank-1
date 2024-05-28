package ir.ac.kntu.menu.customer.requestmenu;

import ir.ac.kntu.db.AnswerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.message.Message;
import ir.ac.kntu.message.MessageOption;
import ir.ac.kntu.person.customer.Customer;

public class RequestCustomerMenu extends Menu {

    private Customer customer;
    private AnswerDB answerDB;

    public RequestCustomerMenu(AnswerDB answerDB) {
        this.answerDB = answerDB;
    }

    public void show(Customer customer) {
        this.customer = customer;
        show();
    }

    @Override
    public void show() {
        System.out.println("request menu");
        MessageOption messageOption = printMenuOption();
        while (messageOption != MessageOption.BACK) {
            if (messageOption != null) {
                switch (messageOption) {
                    case CONTACT -> contact();
                    case SETTING -> setting();
                    case TRANSFER -> transfer();
                    case REPORT -> report();
                    default -> System.out.print("");
                }
            } else {
                System.out.println("invalid input!!");
            }
            messageOption = printMenuOption();
        }
    }

    private MessageOption printMenuOption() {
        System.out.println("----------request Menu----------");
        MessageOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(MessageOption.class);
    }

    private void contact() {
        String message = getMessage();
        Message newMessage = new Message(customer.getPhoneNumber(), message, MessageOption.CONTACT);
        customer.getMessageDB().addMessage(newMessage);
        answerDB.add(newMessage);
    }

    private void setting() {
        String message = getMessage();
        Message newMessage = new Message(customer.getPhoneNumber(), message, MessageOption.SETTING);
        customer.getMessageDB().addMessage(newMessage);
        answerDB.add(newMessage);
    }

    private void transfer() {
        String message = getMessage();
        Message newMessage = new Message(customer.getPhoneNumber(), message, MessageOption.TRANSFER);
        customer.getMessageDB().addMessage(newMessage);
        answerDB.add(newMessage);
    }

    private void report() {
        String message = getMessage();
        Message newMessage = new Message(customer.getPhoneNumber(), message, MessageOption.REPORT);
        customer.getMessageDB().addMessage(newMessage);
        answerDB.add(newMessage);
    }
}
