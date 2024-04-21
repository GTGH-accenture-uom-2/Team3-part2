package gr.accenture.team3.services;

import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Reservation;
import gr.accenture.team3.models.Timeslot;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    List<Reservation> reservations=new ArrayList<>();
    public List<Reservation> addReservation(Reservation reservation){
       reservations.add(reservation);
       return reservations;
    }
    public List<Reservation> getReservations(){
        return reservations;
    }

    public List<Timeslot> getAllTimeslots() {
        return reservations.stream()
                .map(Reservation::getTimeslot)
                .collect(Collectors.toList());
    }

    public List<Insured> getAllInsured() {
        return reservations.stream()
                .map(Reservation::getInsured)
                .collect(Collectors.toList());
    }

}
