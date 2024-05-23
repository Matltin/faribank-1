package ir.ac.kntu.menu.customer.requestmenu;

import ir.ac.kntu.db.AnswerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.message.Message;
import ir.ac.kntu.message.MessageOption;
import ir.ac.kntu.person.customer.Customer;

public class RequestCustomerMenu extends Menu {
    @Override
    public void show() {
        System.out.println("request menu");
        MessageOption messageOption = printMenuOption();
        while (messageOption != MessageOption.BACK) {
            if (messageOption != null) {
                switch (messageOption) {
                    case CONTACT:
//                        contact(customer, answerDB);
                        break;
                    case SETTING:
//                        setting(customer, answerDB);
                        break;
                    case TRANSFER:
//                        transfer(customer, answerDB);
                        break;
                    case REPORT:
//                        report(customer, answerDB);
                        break;
                    default:
                        break;
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

    private void contact(Customer customer, AnswerDB answerDB) {
        String message = getMessage();
        Message newMessage = new Message(customer.getPhoneNumber(), message, MessageOption.CONTACT);
        customer.getMessageDB().addMessage(newMessage);
        answerDB.add(newMessage);
    }

    private void setting(Customer customer, AnswerDB answerDB) {
        String message = getMessage();
        Message newMessage = new Message(customer.getPhoneNumber(), message, MessageOption.SETTING);
        customer.getMessageDB().addMessage(newMessage);
        answerDB.add(newMessage);
    }

    private void transfer(Customer customer, AnswerDB answerDB) {
        String message = getMessage();
        Message newMessage = new Message(customer.getPhoneNumber(), message, MessageOption.TRANSFER);
        customer.getMessageDB().addMessage(newMessage);
        answerDB.add(newMessage);
    }

    private void report(Customer customer, AnswerDB answerDB) {
        String message = getMessage();
        Message newMessage = new Message(customer.getPhoneNumber(), message, MessageOption.REPORT);
        customer.getMessageDB().addMessage(newMessage);
        answerDB.add(newMessage);
    }
}
