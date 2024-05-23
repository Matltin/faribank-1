package ir.ac.kntu.menu.admin.searchmenu;

import ir.ac.kntu.db.AnswerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.message.Message;
import ir.ac.kntu.message.State;

public class SearchMenu extends Menu {
    @Override
    public void show() {
        System.out.println("search menu");
        SearchMenuOption searchMenuOption = printMenuOption();
        while (searchMenuOption != SearchMenuOption.BACK) {
            if (searchMenuOption != null) {
                switch (searchMenuOption) {
                    case STATE:
                    case BRANCH:
                    case USER:
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            searchMenuOption = printMenuOption();
        }

    }

    private SearchMenuOption printMenuOption() {
        System.out.println("----------request Menu----------");
        SearchMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(SearchMenuOption.class);
    }

    private void searchByUser(AnswerDB answerDB) {
        String phoneNumber = getPhoneNumber();
        for (Message message : answerDB.getMessageList()) {
            if (message.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(message);
                String answer = getMessage();
                message.setMessageAnswer(answer);
                message.setState(State.CLOSED);
                return;
            }
        }
        System.out.println("the phone number does not exist!!");
    }
}
