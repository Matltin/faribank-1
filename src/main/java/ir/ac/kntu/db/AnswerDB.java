package ir.ac.kntu.db;

import ir.ac.kntu.message.Message;

import java.util.List;

public class AnswerDB {
    private List<Message> messageList;

    public AnswerDB(List<Message> messageQueue) {
        this.messageList = messageQueue;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void add(Message message){
        messageList.add(message);
    }

    public void remove(Message message) {
        messageList.remove(message);
    }

    public void printMessage() {
        int counter = 1;
        for(Message message : messageList) {
            System.out.println(counter + "." + "message branch : " + message.getMessageOption()
                    + "phone number : " + message.getPhoneNumber());
            counter++;
        }

    }
}
