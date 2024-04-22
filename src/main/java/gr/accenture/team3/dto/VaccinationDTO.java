package gr.accenture.team3.dto;

import java.time.LocalDate;

public class VaccinationDTO {
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
}
