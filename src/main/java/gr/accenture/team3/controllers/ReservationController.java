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

    @GetMapping("/all")
    public List<Reservation> getReservation(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "2") int size){
        return reservationService.getReservations(page, size);
    }

    @GetMapping("/forDay")
    public List<Reservation> getReservationsForDay(@RequestParam String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return reservationService.getReservationsForDay(parsedDate);
    }

    @GetMapping("/getΑReservation")
    public Reservation getΑReservation(@RequestParam String amka){ return reservationService.getAReservation(amka);}

    @PostMapping("/create")
    public Reservation createAReservation(@RequestParam String amka, @RequestParam Long idTimeslot, @RequestParam String surname,@RequestParam (required=false) Integer code){
        return reservationService.addNewReservation(amka,idTimeslot,surname,code);
    }

   @PostMapping("/add")
   public List<Reservation> addReservation(@RequestBody  Reservation reservation){
       return reservationService.addReservation(reservation);
   }

    @GetMapping("/getAvailableTimeslotforDay")
    public List<Timeslot> getAvailableTimeslotforDay(@RequestParam LocalDate localDate){
        return reservationService.getAvailableTimeslotforDay(localDate);
    }

    @PutMapping("/update")
    public Reservation changeTimeslot(@RequestParam String amka, @RequestParam Long id){
        return reservationService.changeReservation(amka,id);
    }

}
