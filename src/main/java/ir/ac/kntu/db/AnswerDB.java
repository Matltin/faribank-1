package ir.ac.kntu.db;

import ir.ac.kntu.message.Message;

import java.util.List;

public class AnswerDB {
    private List<Message> messageQueue;

    public AnswerDB(List<Message> messageQueue) {
        this.messageQueue = messageQueue;
    }

    public void add(Message message){
        messageQueue.add(message);
    }

    public void remove(Message message) {
        messageQueue.remove(message);
    }
}
