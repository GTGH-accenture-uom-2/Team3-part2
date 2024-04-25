package gr.accenture.team3.models;

import java.time.LocalDate;

public class Vaccination {
    private Insured insured;
    private Timeslot timeslot;
    private Doctor doctor;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;

    public Vaccination (Insured insured, Doctor doctor, Timeslot timeslot, LocalDate vaccinationDate) {
        this.insured=insured; //mporoume na kanoume extend reservation
        this.doctor = doctor;
        this.timeslot=timeslot;
        this.vaccinationDate=vaccinationDate;
        expirationDate = vaccinationDate.plusYears(2);
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "Insured name =" + getInsured().getName() + " "+ getInsured().getSurname() +
                ", vaccination date=" + getVaccinationDate() +
                ", expiration date=" + expirationDate +
                '}';
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

}
