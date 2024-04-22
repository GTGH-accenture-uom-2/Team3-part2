package gr.accenture.team3.services;

import gr.accenture.team3.dto.VaccinationDTO;
import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationService {
    @Autowired
    InsuredService insuredService;
    @Autowired
    TimeslotService timeslotService;
    List<Vaccination> vaccinations = new ArrayList<>();

    public List<Vaccination> addVaccination(Vaccination vaccination) {
        vaccinations.add(vaccination);
        return vaccinations;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }


    public VaccinationDTO getVaccinationStatus(String amka){
        for(Vaccination vaccination: vaccinations){
            if(vaccination.getInsured().equals(insuredService.getInsuredByAmka(amka))){
                return new VaccinationDTO(vaccination.getVaccinationDate());
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "This insured is not vaccinated!");
    }

   /* public List<Vaccination> addByDoctor(Long id, String amka, LocalDate expirationDate){

        vaccinations.add(new Vaccination(insuredService.getInsuredByAmka(amka),timeslotService.getTimeslotById(id).getDoctor(),timeslotService.getTimeslotById(id),expirationDate.minusYears(2)));
        return vaccinations;
    } */


}
