package gr.accenture.team3.controllers;

import gr.accenture.team3.models.Reservation;
import gr.accenture.team3.models.Timeslot;
import gr.accenture.team3.models.Vaccination;
import gr.accenture.team3.models.VaccinationCenter;
import gr.accenture.team3.services.ReservationService;
import gr.accenture.team3.services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public List<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter){
        return vaccinationCenterService.addVaccinationCenter(vaccinationCenter);
    }

    @GetMapping("/all")
    public List<VaccinationCenter> getVaccinationCenters(){
        return vaccinationCenterService.getVaccinationCenters();
    }

    @GetMapping("/timeslots")
    public List<Timeslot> getAllTimeslotPerVacCenter(@RequestParam Integer code){
        return vaccinationCenterService.getAllTimeslotsPerVacCenter(code);
    }
}
