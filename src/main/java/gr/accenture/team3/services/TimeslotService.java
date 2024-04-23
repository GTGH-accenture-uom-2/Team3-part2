package gr.accenture.team3.services;

import gr.accenture.team3.models.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService {
    List<Timeslot> timeslots ;
    @Autowired
    VaccinationCenterService vaccinationCenterService;

    public void initializeTimeslots(Integer code) {
        timeslots = vaccinationCenterService.getAllTimeslotsPerVacCenter(code);
    }

    public List<Timeslot> getAllTimeslots() {
        return timeslots;
    }

    public Timeslot getOneTimeslot(Long id) {
        for (Timeslot timeslot : timeslots) {
            if (id.equals(timeslot.getId())) {
                return timeslot;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Timeslot not found");
    }

    public List<Timeslot> addTimeslot(Timeslot timeslot) {
        timeslots.add(timeslot);
        return timeslots;
    }
    public List<Timeslot> getTimeslotByDate(LocalDate date) {
        List<Timeslot> filteredTimeslots = new ArrayList<>();
        for (Timeslot timeslot : timeslots) {
            if (timeslot.getDate().equals(date)) {
                filteredTimeslots.add(timeslot);
            }
        }
        if (filteredTimeslots.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No timeslots available on this date");
        }
        return filteredTimeslots;
    }
    public List<Timeslot> getTimeslotsByDayAndVacCenter(List<Timeslot> timeslotsByVacCenter ,LocalDate localDate){
        for (Timeslot timeslot : timeslotsByVacCenter) {
            if (timeslot.getDate().equals(localDate)) {
                timeslotsByVacCenter.add(timeslot);
            }
        }
        if (timeslotsByVacCenter.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No timeslots available on this date");
        }
        return timeslotsByVacCenter;
    }

    public Timeslot getTimeslotById(Long id){
        for(Timeslot timeslot: timeslots){
            if(timeslot.getId().equals(id)){
                return timeslot;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested timeslot does not exist.");
    }

}
