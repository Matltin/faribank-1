package ir.ac.kntu.DB;

import ir.ac.kntu.Message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MessageDB {

    private Queue<Message> messagesQueue;
    private List<Message> messageList;

    public MessageDB() {
        messageList = new ArrayList<>();
    }

    public void addMessage(Message message) {
        messageList.add(message);
    }
}
