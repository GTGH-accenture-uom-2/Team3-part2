package gr.accenture.team3.models;

import java.time.LocalDate;

public class Vaccination  extends Reservation{

    private Doctor doctor;
    private LocalDate expirationDate;

    public Vaccination (Insured insured, Doctor doctor, Timeslot timeslot, LocalDate vaccinationDate) {
        super(insured,timeslot,vaccinationDate);  //mporoume na kanoume extend reservation
        this.doctor = doctor;
        expirationDate = vaccinationDate.plusYears(2);
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
