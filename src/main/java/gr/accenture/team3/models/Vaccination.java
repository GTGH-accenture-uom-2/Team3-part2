package gr.accenture.team3.models;

import java.time.LocalDate;

public class Vaccination  extends Reservation{
    private LocalDate expirationDate;
    private Doctor doctor;

    public Vaccination (Insured insured, Doctor doctor, Timeslot timeslot, LocalDate localdate) {
        super(insured,timeslot,localdate);  //mporoume na kanoume extend reservation
        this.doctor = doctor;
        expirationDate = localdate.plusYears(2);
    }
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
