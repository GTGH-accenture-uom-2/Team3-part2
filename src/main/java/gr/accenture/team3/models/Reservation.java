package gr.accenture.team3.models;

import java.time.LocalDate;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;
    private LocalDate vaccinationDate;
    private Integer code;

    public Reservation(Insured insured, Timeslot timeslot, LocalDate vaccinationDate,Integer code) {
        this.insured = insured;
        this.timeslot = timeslot;
        this.vaccinationDate = vaccinationDate;
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

}
