package ir.ac.kntu.menu.admin.statemenu;

import ir.ac.kntu.db.AnswerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.message.Message;
import ir.ac.kntu.message.MessageOption;
import ir.ac.kntu.message.State;

public class StateMenu extends Menu {
    @Override
    public void show() {
        System.out.println("state menu");
        State state = printMenuOption();
        while (state != State.BACK) {
            if(state != null) {
                switch (state) {
                    case SUBMIT:
                    case IN_PROGRESS:
                    case CLOSED:
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            state = printMenuOption();
        }
    }

    private State printMenuOption() {
        System.out.println("----------request Menu----------");
        State.printOption();
        System.out.print("Enter your choice : ");
        return getOption(State.class);
    }

    private void showSubmit(AnswerDB answerDB) {
        print(answerDB, State.SUBMIT);
        int number = getNumber();
        int counter = 0;
        for(Message message : answerDB.getMessageList()) {
            if(message.getState() == State.SUBMIT) {
                counter++;
                checkForClosed(counter, number, message);
            }
        }
    }

    private void showInProgress(AnswerDB answerDB) {
        print(answerDB, State.IN_PROGRESS);
        int number = getNumber();
        int counter = 0;
        for(Message message : answerDB.getMessageList()) {
            if(message.getState() == State.IN_PROGRESS) {
                counter++;
                checkForClosed(counter, number, message);
            }
        }
    }

    private void showClosed(AnswerDB answerDB) {
        int counter = 1;
        for(Message message : answerDB.getMessageList()) {
            if(message.getState() == State.CLOSED) {
                System.out.println(counter + "." + message);
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

    private void print(AnswerDB answerDB, State state) {
        int counter = 1;
        for(Message message : answerDB.getMessageList()) {
            if(message.getState() == state) {
                System.out.println(counter + "." + message);
                counter++;
            }
        }
    }
}