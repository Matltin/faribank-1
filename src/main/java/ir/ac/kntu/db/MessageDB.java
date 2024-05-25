package ir.ac.kntu.db;

import ir.ac.kntu.message.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageDB {

    private List<Message> messageList;

    public MessageDB() {
        messageList = new ArrayList<>();
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public int size() {
        return messageList.size();
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public void addMessage(Message message) {
        messageList.add(message);
    }

    public void printMessage() {
        int counter = 1;
        for (Message message : messageList) {
            System.out.println(counter + "." + message.getMessage());
            counter++;
        }
    }
}
