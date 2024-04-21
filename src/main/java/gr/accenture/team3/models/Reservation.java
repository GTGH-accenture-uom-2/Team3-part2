package gr.accenture.team3.models;

import java.time.LocalDate;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;
    private LocalDate localdate;

    public Reservation(Insured insured, Timeslot timeslot, LocalDate localdate) {
        this.insured = insured;
        this.timeslot = timeslot;
        this.localdate = localdate;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public LocalDate getLocaldate() {
        return localdate;
    }

    public void setLocaldate(LocalDate localdate) {
        this.localdate = localdate;
    }
}
