package gr.accenture.team3.services;

import gr.accenture.team3.models.Timeslot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService {


    List<Timeslot> timeslots = new ArrayList<>();

    public List<Timeslot> getAllTimeslots() {
        return timeslots;
    }

    public List<Timeslot> addTimeslot(Timeslot timeslot) {
        timeslots.add(timeslot);
        return timeslots;
    }

}
