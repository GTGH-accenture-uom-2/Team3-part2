package gr.accenture.team3.services;

import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VaccinationService {
    @Autowired
    Insured insured;
    @Autowired
    Vaccination vaccination;
   public Vaccination getVaccinationStatus(String amka){

           if (insured.getAmka().equals(amka)){
               return vaccination;
           }
       throw new ResponseStatusException(HttpStatus.NOT_FOUND,
               "This amka doesn't belong to anyone!");
    }
}
