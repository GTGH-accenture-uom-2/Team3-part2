package gr.accenture.team3.dto;

import gr.accenture.team3.models.Insured;

import java.time.LocalDate;

public class VaccinationDTO {
    private Insured insured;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;

    public VaccinationDTO(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
        expirationDate = vaccinationDate.plusYears(2);
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

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    @Override
    public String toString() {
        return "Insured: " +
                "vaccinationDate=" + vaccinationDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}

