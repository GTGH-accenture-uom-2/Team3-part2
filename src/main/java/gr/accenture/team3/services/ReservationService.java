package gr.accenture.team3.services;

import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    List<Reservation> reservations=new ArrayList<>();
    public List<Reservation> addReservation(Reservation reservation){
       reservations.add(reservation);
       return reservations;
    }

}
