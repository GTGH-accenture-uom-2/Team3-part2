package gr.accenture.team3.controllers;

import gr.accenture.team3.models.*;
import gr.accenture.team3.services.ReservationService;
import gr.accenture.team3.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    TimeslotService timeslotService;

    @PostMapping("/add")
   public List<Reservation> addReservation(@RequestBody  Reservation reservation){
       return reservationService.addReservation(reservation);
   }
   @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getReservations();
    }
    @GetMapping("/search")
    public List<Timeslot> getAvailableTimeslot(@RequestParam LocalDate localDate){

        return reservationService.availableTimeslot(localDate);
    }

    @PostMapping("/createReservation")
    public Reservation createAReservation(@RequestParam String amka, @RequestParam Long idTimeslot, @RequestParam String surname){
        return reservationService.addNewReservation(amka,idTimeslot,surname);
    }
    @GetMapping("/createReservation")
    public Reservation getNewReservation(@RequestParam String amka){ return reservationService.getAReservation(amka);}

}
