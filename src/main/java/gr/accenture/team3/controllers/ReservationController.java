package gr.accenture.team3.controllers;

import gr.accenture.team3.models.*;
import gr.accenture.team3.services.PDFService;
import gr.accenture.team3.services.ReservationService;
import gr.accenture.team3.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
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
    @Autowired
    PDFService pdfService;

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

    @PostMapping("/create/amka/{amka}/id/{id}/surname/{surname}")
    public Reservation createAReservation(@PathVariable("amka") String amka, @PathVariable("id") Long id, @PathVariable("surname") String surname,@RequestParam (required=false) Integer code){
        return reservationService.addNewReservation(amka,id,surname,code);
    }

   @PostMapping("/add")
   public List<Reservation> addReservation(@RequestBody  Reservation reservation){
       return reservationService.addReservation(reservation);
   }

    @GetMapping("/search")
    public List<Timeslot> getAvailableTimeslotforDay(@RequestParam LocalDate localDate,@RequestParam Integer code){
        return reservationService.getAvailableTimeslotforDay(localDate,code);
    }

    @PutMapping("/update")
    public Reservation changeTimeslot(@RequestParam String amka, @RequestParam Long id){
        return reservationService.changeReservation(amka,id);
    }
    @GetMapping()
    public List<Timeslot> getAllTimeslotsPerMonth(@RequestParam Integer code){
        return reservationService.getAllTimeslotsPerMonth(code);
    }

    @GetMapping("/generatePdfForDoctorDay")
    public String generatePdfForDoctorDay(@RequestParam String doctorAmka, @RequestParam String date, @RequestParam String path) {
        LocalDate parsedDate = LocalDate.parse(date);
        List<Reservation> reservations = reservationService.getReservationsForDoctorAndDay(doctorAmka, parsedDate);

        try {
            pdfService.createAndSavePDF(reservations, path);
            return "PDF generated successfully at: " + path;
        } catch (IOException e) {
            return "Failed to generate PDF: " + e.getMessage();
        }
    }

}
