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

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ReservationService {
    List<Reservation> reservations=new ArrayList<>();
    @Autowired InsuredService insuredService;
    @Autowired TimeslotService timeslotService;
    @Autowired DoctorService doctorService;
//    public List<Reservation> addReservation(Reservation reservation){
//       reservations.add(reservation);
//       return reservations;
//    }
    public List<Reservation> getReservations(){
        return reservations;
    }

    public Reservation addNewReservation(String amka, Long id, String surname){
        for(Insured insured : insuredService.insureds){
            if(insured.getAmka().equals(amka)){
                for(Timeslot timeslot: timeslotService.timeslots){
                    if(timeslot.getId().equals(id)){
                        for(Doctor doctor : doctorService.doctors){
                            if (doctor.getSurname().equals(surname) && timeslot.getDoctor()==null){
                                timeslot.setDoctor(doctor);
                                Reservation reservation = new Reservation(insured,timeslot,timeslot.getDate());
                                reservations.add(reservation);
                                return reservation;
                            }else if(doctor.getSurname().equals(surname) && timeslot.getDoctor()!=null){
                                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The requested timeslot is not free.");
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

    public Reservation changeReservation(String amka, Long id){
        //search in the list of reservations for the old reservation
        Reservation reservation = reservations.stream()
                .filter(r -> r.getInsured().getAmka().equals(amka))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "This amka doesn't belong to anyone!"));
        //check whether the insured has made up to two changes
        Insured insured = reservation.getInsured();
        insured.increaseChangeReservationCounter();
        if(insured.getChangeReservationsCounter()>2)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can make up to two changes.");

        //find the old timeslot and the new timeslot
        Timeslot oldReservationTimeslot = reservation.getTimeslot();
        Timeslot newTimeslotReservation = timeslotService.timeslots.stream()
                .filter(t->t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested timeslot does not exist."));
        //check if the new timeslot is free
        if(newTimeslotReservation.getDoctor() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The requested timeslot is not free.");

        //update the doctor to the new timeslot
        newTimeslotReservation.setDoctor(oldReservationTimeslot.getDoctor());
        oldReservationTimeslot.setDoctor(null);

        //create a new reservation and delete the old one from the list reservations
        Reservation changedReservation = new Reservation(insured,newTimeslotReservation,newTimeslotReservation.getDate());
        reservations.add(changedReservation);
        reservations.remove(reservation);
        return changedReservation;
    }



}
