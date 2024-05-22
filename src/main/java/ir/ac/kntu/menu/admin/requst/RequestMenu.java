package ir.ac.kntu.menu.admin.requst;

import ir.ac.kntu.db.AnswerDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.message.State;

public class RequestMenu extends Menu {
    @Override
    public void show() {
        System.out.println("request menu");
        RequestMenuOption requestMenuOption = printMenuOption();
        while (requestMenuOption != RequestMenuOption.BACK) {
            if(requestMenuOption != null) {
                switch (requestMenuOption) {
                    case SEARCH:
                    case SHOW:
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            requestMenuOption = printMenuOption();
        }
    }

    private RequestMenuOption printMenuOption() {
        System.out.println("----------request Menu----------");
        RequestMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(RequestMenuOption.class);
    }

    private void showRequest(AnswerDB answerDB) {
        answerDB.printMessage();
        int number = getNumber();
        answerDB.getMessageList().get(number - 1).setState(State.IN_PROGRESS);
        System.out.println(answerDB.getMessageList().get(number - 1) + "phone number : " + answerDB.getMessageList().get(number - 1).getPhoneNumber());
    }

}
