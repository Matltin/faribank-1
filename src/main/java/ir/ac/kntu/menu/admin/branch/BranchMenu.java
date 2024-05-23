package ir.ac.kntu.menu.admin.branch;

import ir.ac.kntu.db.AnswerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.message.Message;
import ir.ac.kntu.message.MessageOption;
import ir.ac.kntu.message.State;

public class BranchMenu extends Menu {
    @Override
    public void show() {
        System.out.println("request menu");
        MessageOption messageOption = printMenuOption();
        while (messageOption != MessageOption.BACK) {
            if(messageOption != null) {
                switch (messageOption) {
                    case CONTACT:

                        break;
                    case SETTING:

                        break;
                    case TRANSFER:

                        break;
                    case REPORT:

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

    private void showByContact(AnswerDB answerDB) {
        print(answerDB, MessageOption.CONTACT);
        int number = getNumber();
        int counter = 0;
        for(Message message : answerDB.getMessageList()) {
            if(message.getMessageOption() == MessageOption.CONTACT) {
                counter++;
                checkForClosed(counter, number, message);
            }
        }
    }

    private void showSetting(AnswerDB answerDB) {
        print(answerDB, MessageOption.SETTING);
        int number = getNumber();
        int counter = 0;
        for(Message message : answerDB.getMessageList()) {
            if(message.getMessageOption() == MessageOption.SETTING) {
                counter++;
                checkForClosed(counter, number, message);
            }
        }
    }

    private void showTransfer(AnswerDB answerDB) {
        print(answerDB, MessageOption.TRANSFER);
        int number = getNumber();
        int counter = 0;
        for(Message message : answerDB.getMessageList()) {
            if(message.getMessageOption() == MessageOption.TRANSFER) {
                counter++;
                checkForClosed(counter, number, message);
            }
        }
    }

    private void showReport(AnswerDB answerDB) {
        print(answerDB, MessageOption.REPORT);
        int number = getNumber();
        int counter = 0;
        for(Message message : answerDB.getMessageList()) {
            if(message.getMessageOption() == MessageOption.REPORT) {
                counter++;
                checkForClosed(counter, number, message);
            }
        }
    }

    private void checkForClosed(int counter, int number, Message message) {
        if(counter == number) {
            System.out.println(message);
            String answer = getMessage();
            message.setMessageAnswer(answer);
            message.setState(State.CLOSED);
        }
    }

    private void print(AnswerDB answerDB, MessageOption messageOption) {
        int counter = 1;
        for(Message message : answerDB.getMessageList()) {
            if(message.getMessageOption() == messageOption) {
                System.out.println(counter + "." + message);
                counter++;
            }
        }
    }
}
