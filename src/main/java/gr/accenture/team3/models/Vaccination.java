package gr.accenture.team3.models;

public class Vaccination {
    private Insured insured;
    private Doctor doctor;
    private String vaccinationDate;
    private String expirationDate;

    public Vaccination(Insured insured, Doctor doctor, String vaccinationDate, String expirationDate) {  //mporoume na kanoume extend reservation
        this.insured = insured;
        this.doctor = doctor;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = expirationDate;
    }
    public Vaccination(Insured insured){
        this.insured = insured;
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

    public String getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(String vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}