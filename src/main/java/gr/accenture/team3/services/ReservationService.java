package gr.accenture.team3.services;

import gr.accenture.team3.models.Doctor;
import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Reservation;
import gr.accenture.team3.models.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    List<Reservation> reservations=new ArrayList<>();
    @Autowired InsuredService insuredService;
    @Autowired TimeslotService timeslotService;
    @Autowired DoctorService doctorService;
    public List<Reservation> addReservation(Reservation reservation){
       reservations.add(reservation);
       return reservations;
    }
    public List<Reservation> getReservations(){
        return reservations;
    }

    public Reservation addNewReservation(String amka, Long id, String surname){
        for(Insured insured : insuredService.insureds){
            if(insured.getAmka().equals(amka)){
                for(Timeslot timeslot: timeslotService.timeslots){
                    if(timeslot.getId().equals(id)){
                        for(Doctor doctor : doctorService.doctors){
                            if (doctor.getSurname().equals(surname)){
                                timeslot.setDoctor(doctor);
                                Reservation reservation = new Reservation(insured,timeslot,timeslot.getDate());
                                reservations.add(reservation);
                                return reservation;
                            }
                        }
                    }
                }
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect data!");
    }

    public Reservation getAReservation(String amka){
        for(Reservation reservation: reservations){
            if(reservation.getInsured().getAmka().equals(amka)){
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This reservation is not found!");
    }

}
