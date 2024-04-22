package gr.accenture.team3.services;

import gr.accenture.team3.models.Timeslot;
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


    List<Timeslot> timeslots = new ArrayList<>();

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

    public void generateTimeslotsForPeriod(LocalDate startDate, int days) {
        DateTimeFormatter idFormatter = DateTimeFormatter.ofPattern("ddMMyy");
        LocalDate date = startDate;
        for (int i = 0; i < days; i++) {
            String baseId = date.format(idFormatter);
            LocalTime time = LocalTime.of(10, 0);
            for (int j = 0; j < 10; j++) { // 10 timeslots per day
                String timeId = String.format("%02d%02d", time.getHour(), time.getMinute());
                Long id = Long.parseLong(baseId + timeId);
                Timeslot timeslot = new Timeslot(id, date, time, time.plusMinutes(30), null);
                timeslots.add(timeslot);
                time = time.plusMinutes(30);
            }
            date = date.plusDays(1);
        }
    }

}
