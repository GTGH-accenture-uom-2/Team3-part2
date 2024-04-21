package gr.accenture.team3.controllers;

import gr.accenture.team3.models.Timeslot;
import gr.accenture.team3.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/student")
public class TimeslotsController {
    @Autowired
    TimeslotService timeslotService;

    @GetMapping
    public List<Timeslot> getAllTimeslots (){

        return  timeslotService.getAllTimeslots();
    }

    @GetMapping("/oneTimeslot")
    public Timeslot getOneTimeslot(@RequestParam Long id){
        for(Timeslot timeslot:timeslotService.getAllTimeslots()){
            if(id == timeslot.getId()) {
                return timeslot;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found");
    }

    @PostMapping
    public List<Timeslot> addTimeslot(@RequestBody Timeslot timeslot){
        return timeslotService.addTimeslot(timeslot);
    }



}
