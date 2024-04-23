package gr.accenture.team3.models;

import java.time.LocalDate;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;
    private LocalDate vaccinationDate;
    private Integer vaccinationCenterCode;

    public Reservation(Insured insured, Timeslot timeslot, LocalDate vaccinationDate) {
        this.insured = insured;
        this.timeslot = timeslot;
        this.vaccinationDate = vaccinationDate;
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

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public Integer getVaccinationCenterCode() {
        return vaccinationCenterCode;
    }

    public void setVaccinationCenterCode(Integer vaccinationCenterCode) {
        this.vaccinationCenterCode = vaccinationCenterCode;
    }
}
