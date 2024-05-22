package ir.ac.kntu.person.customer;

import ir.ac.kntu.Constance;

public enum State {
    ACCEPTED(Constance.GREEN + "Accepted"),
    IN_PROGRESSING(Constance.YELLOW + "in Progressing"),
    REJECT(Constance.RED + "Reject");

    private final String  state;

    private State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
