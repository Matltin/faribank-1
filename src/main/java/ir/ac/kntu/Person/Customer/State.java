package ir.ac.kntu.Person.Customer;

import ir.ac.kntu.Constance;

public enum State {
    ACCEPTED(Constance.GREEN + "Accepted"),
    PROGRESSING(Constance.YELLOW + "Progressing"),
    REJECT(Constance.RED + "Reject");

    private final String  state;

    private State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
