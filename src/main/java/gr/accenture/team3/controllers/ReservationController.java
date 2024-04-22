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
    @GetMapping("/getAvailableTimeslotforDay")
    public List<Timeslot> getAvailableTimeslotforDay(@RequestParam LocalDate localDate){
        return reservationService.getAvailableTimeslotforDay(localDate);
    }

    @PostMapping("/create")
    public Reservation createAReservation(@RequestParam String amka, @RequestParam Long idTimeslot, @RequestParam String surname){
        return reservationService.addNewReservation(amka,idTimeslot,surname);
    }
    @PutMapping("/update")
    public Reservation changeTimeslot(@RequestParam String amka, @RequestParam Long id){
        return reservationService.changeReservation(amka,id);
    }
    @GetMapping("/getΑReservation")
    public Reservation getΑReservation(@RequestParam String amka){ return reservationService.getAReservation(amka);}

}
