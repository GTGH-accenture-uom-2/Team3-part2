package gr.accenture.team3.services;

import gr.accenture.team3.models.Timeslot;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService {


    List<Timeslot> timeslots = new ArrayList<>();

    public List<Timeslot> getAllTimeslots() {
        return new ArrayList<>(timeslots);
    }

    public List<Timeslot> addTimeslot(Timeslot timeslot) {
        timeslots.add(timeslot);
        return timeslots;
    }

    public void generateTimeslotsForPeriod(LocalDate startDate, int days) {
        DateTimeFormatter idFormatter = DateTimeFormatter.ofPattern("ddMMyy");
        LocalDate date = startDate;
        for (int i = 0; i < days; i++) {
            String baseId = date.format(idFormatter); // Formats the date part for the ID
            LocalTime time = LocalTime.of(10, 0);
            for (int j = 0; j < 10; j++) { // 10 timeslots per day
                String timeId = String.format("%02d%02d", time.getHour(), time.getMinute());
                Long id = Long.parseLong(baseId + timeId); // Concatenate and parse to long
                Timeslot timeslot = new Timeslot(id, date, time, time.plusMinutes(30), null);
                timeslots.add(timeslot);
                time = time.plusMinutes(30);
            }
            date = date.plusDays(1);
        }
    }

}
