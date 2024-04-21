package gr.accenture.team3.controllers;

import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Reservation;
import gr.accenture.team3.models.VaccinationCenter;
import gr.accenture.team3.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping("/add")
   public List<Reservation> addReservation(@RequestBody  Reservation reservation){
       return reservationService.addReservation(reservation);
   }
   @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getReservations();
    }
}
