package gr.accenture.team3.services;

import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationService {
   @Autowired
    InsuredService insuredService;
    List<Vaccination> vaccinations=new ArrayList<>();
    public List<Vaccination> addVaccination(Vaccination vaccination) {
        vaccinations.add(vaccination);
        return vaccinations;
    }
    public List<Vaccination> getVaccinations(){
        return vaccinations;
    }

    public Vaccination getVaccinationStatus(String amka){
        for(Vaccination vaccination: vaccinations){
            if(vaccination.getInsured().equals(insuredService.getInsuredByAmka(amka))){
                return vaccination;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "This insured is not vaccinated!");
    }
}
