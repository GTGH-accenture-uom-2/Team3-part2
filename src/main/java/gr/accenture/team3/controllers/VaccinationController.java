package gr.accenture.team3.controllers;

import gr.accenture.team3.models.Vaccination;
import gr.accenture.team3.services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    VaccinationService vaccinationService;
    @GetMapping
    public Vaccination getVaccinationStatus(@RequestParam String amka){
        return vaccinationService.getVaccinationStatus(amka);
    }
}
