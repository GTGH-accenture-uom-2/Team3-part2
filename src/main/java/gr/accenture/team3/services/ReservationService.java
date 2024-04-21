package gr.accenture.team3.services;

import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Reservation> getTodayReservations(int page, int size) {
        LocalDate today = LocalDate.now();
        List<Reservation> todayReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getVaccinationDate().isEqual(today)) {
                todayReservations.add(reservation);
            }
        }
        int start = page * size;
        int end = Math.min((start + size), todayReservations.size());
        return todayReservations.subList(start, end);
    }

}
