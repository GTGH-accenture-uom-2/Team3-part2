package gr.accenture.team3.controllers;

import gr.accenture.team3.models.Timeslot;
import gr.accenture.team3.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/timeslot")
public class TimeslotsController {
    @Autowired
    TimeslotService timeslotService;

    @GetMapping
    public List<Timeslot> getAllTimeslots (@RequestParam (required=false) Integer code){
        return  timeslotService.getAllTimeslots(code);
    }

    @GetMapping("/oneTimeslot")
    public Timeslot getOneTimeslot(@RequestParam Long id){
        try {
            return timeslotService.getOneTimeslot(id);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found", e);
        }
    }

    @GetMapping("/getTimeslotByDate")
    public List<Timeslot> getTimeslotByDate(@RequestParam LocalDate localdate){
        try {
            return timeslotService.getTimeslotByDate(localdate);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found", e);
        }
    }

    @PostMapping
    public List<Timeslot> addTimeslot(@RequestBody Timeslot timeslot){
        return timeslotService.addTimeslot(timeslot);
    }



}
