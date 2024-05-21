package ir.ac.kntu.DB;

import ir.ac.kntu.Message.Message;

import java.util.Queue;

public class AnswerDB {
    private Queue<Message> messageQueue;

    public AnswerDB(Queue<Message> messageQueue) {
        this.messageQueue = messageQueue;
    }

    public void add(Message message){
        messageQueue.add(message);
    }

    public Message remove(Message message) {
        return messageQueue.remove();
    }
}
