package ir.ac.kntu.message;

public class Message {

    private MessageOption messageOption;
    private String message;
    private String messageAnswer;
    private String phoneNumber;

    public Message(String phoneNumber, String message, MessageOption messageOption) {
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.messageOption = messageOption;
        this.messageAnswer = "";
    }

    public MessageOption getMessageOption() {
        return messageOption;
    }

    public void setMessageOption(MessageOption messageOption) {
        this.messageOption = messageOption;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageAnswer() {
        return messageAnswer;
    }

    public void setMessageAnswer(String messageAnswer) {
        this.messageAnswer = messageAnswer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        if(messageAnswer.isEmpty()) {
            return "Message{" +
                    "message='" + message + '\'' +
                    ", messageOption=" + messageOption + '\'' +
                    '}';
        }
        return "Message{" +
                "message='" + message + '\'' +
                ", messageOption=" + messageOption + '\'' +
                ", messageAnswer='" + messageAnswer +
                '}';
    }
}
