package ir.ac.kntu.faribank.card;

import java.util.Random;

public class Card {
    private String password;

    public Card() {
        password = randomPassword();
    }

    private String randomPassword() {
        Random r = new Random();
        return String.valueOf(r.nextInt(1000,10000));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
