package gr.accenture.team3.controllers;

import gr.accenture.team3.models.*;
import gr.accenture.team3.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

//    @PostMapping("/add")
//   public List<Reservation> addReservation(@RequestBody  Reservation reservation){
//       return reservationService.addReservation(reservation);
//   }
   @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getReservations();
    }

    @PostMapping("/createReservation")
    public Reservation createAReservation(@RequestParam String amka, @RequestParam Long id, @RequestParam String surname){
        return reservationService.addNewReservation(amka,id,surname);
    }
    @GetMapping("/createReservation")
    public Reservation getNewReservation(@RequestParam String amka){ return reservationService.getAReservation(amka);}

    @PutMapping("/updateReservation")
    public Reservation changeTimeslot(@RequestParam String amka, @RequestParam Long id){
        return reservationService.changeReservation(amka,id);
    }
}
