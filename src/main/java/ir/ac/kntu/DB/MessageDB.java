package ir.ac.kntu.DB;

import ir.ac.kntu.Message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MessageDB {

    private List<Message> messageList;

    public MessageDB() {
        messageList = new ArrayList<>();
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public void addMessage(Message message) {
        messageList.add(message);
    }

    public void printMessage() {
        int counter = 1;
        for(Message message : messageList) {
            System.out.println(counter + "." + message.getMessage());
            counter++;
        }
    }
}
