package gr.accenture.team3.services;

import gr.accenture.team3.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    List<Reservation> reservations=new ArrayList<>();
    @Autowired InsuredService insuredService;
    @Autowired TimeslotService timeslotService;
    @Autowired DoctorService doctorService;
    @Autowired VaccinationCenterService vaccinationCenterService;

    public List<Reservation> getReservations(int page, int size){
        int start = page * size;
        return reservations.stream()
                .skip(start)
                .limit(size)
                .collect(Collectors.toList());
    }

    public List<Reservation> getReservationsForDay(LocalDate date) {
        List<Reservation> reservationsForDay = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getTimeslot().getDate().isEqual(date)) {
                reservationsForDay.add(reservation);
            }
        }
        return reservationsForDay;
    }

    public List<Reservation> addReservation(Reservation reservation){
       reservations.add(reservation);
       return reservations;
    }

    public List<Timeslot> getAvailableTimeslotforDay(LocalDate localDate) {
        List<Timeslot> availableTimeslots = new ArrayList<>();
        List<Timeslot> timeslotsByDate = timeslotService.getTimeslotByDate(localDate);

        // Check each timeslot to see if it is free
        for (Timeslot timeslot : timeslotsByDate) {
            boolean isReserved = false;
            for (Reservation reservation : reservations) {
                if (reservation.getTimeslot() != null && reservation.getTimeslot().equals(timeslot)) {
                    isReserved = true;
                    break; // This timeslot is reserved, break out of the inner loop
                }
            }
            if (!isReserved) {
                availableTimeslots.add(timeslot); // This timeslot is available, add to list
            }
        }

        if (availableTimeslots.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No available timeslots on this date");
        }
        return availableTimeslots;
    }


    public Reservation addNewReservation(String amka, Long id, String surname,Integer code){
        Integer centerCode = 1;
        if(code==null){
            VaccinationCenter center = vaccinationCenterService.getVaccinationCenterByCode(1);
            timeslotService.initializeTimeslots(center.getCode());
        }else{
            VaccinationCenter center = vaccinationCenterService.getVaccinationCenterByCode(code);
            timeslotService.initializeTimeslots(center.getCode());
            centerCode = code;
        }


        Insured insured = insuredService.getInsuredByAmka(amka);
        for(Reservation reservation: reservations){
            if(reservation.getInsured().equals(insured)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can book only one reservation!");
            }
        }
        Timeslot timeslot = timeslotService.getTimeslotById(id);
        Doctor doctor = doctorService.getDoctorBySurname(surname);
        if(timeslot.getDoctor()==null && checkAvailabilityOfTheDoctor(centerCode,doctor)){
            timeslot.setDoctor(doctor);
            Reservation reservation = new Reservation(insured,timeslot,timeslot.getDate());
            reservation.setVaccinationCenterCode(centerCode);
            reservations.add(reservation);
            return reservation;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The requested timeslot is not free.");
    }

    public Reservation changeReservation(String amka, Long id){
        //search in the list of reservations for the old reservation
        Reservation reservation = reservations.stream()
                .filter(r -> r.getInsured().getAmka().equals(amka))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no booking with this amka!"));

        //check whether the insured has made up to two changes
        Insured insured = reservation.getInsured();
        insured.increaseChangeReservationCounter();
        if(insured.getChangeReservationsCounter()>2)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can make up to two changes.");

        //find the old timeslot and the new timeslot
        Timeslot oldReservationTimeslot = reservation.getTimeslot();
        Timeslot newTimeslot = timeslotService.getTimeslotById(id);
        //check if the new timeslot is free
        if(newTimeslot.getDoctor() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The requested timeslot is not free.");

        //update the doctor to the new timeslot
        newTimeslot.setDoctor(oldReservationTimeslot.getDoctor());
        oldReservationTimeslot.setDoctor(null);

        //create a new reservation and delete the old one from the list reservations
        Reservation changedReservation = new Reservation(insured,newTimeslot,newTimeslot.getDate());
        changedReservation.setVaccinationCenterCode(reservation.getVaccinationCenterCode());
        reservations.add(changedReservation);
        reservations.remove(reservation);
        return changedReservation;

    }

    public Reservation getAReservation(String amka){
        for(Reservation reservation: reservations){
            if(reservation.getInsured().getAmka().equals(amka)){
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This reservation is not found!");
    }

    public Reservation getReservationByAmka(String amka,Long id){
        for (Reservation reservation: reservations){
            if (reservation.getInsured().getAmka().equals(amka) && reservation.getTimeslot().getId().equals(id)){
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Invalid amka or id");
    }

    public Boolean checkAvailabilityOfTheDoctor(Integer code, Doctor doctor) {
        for (VaccinationCenter vaccinationCenter : vaccinationCenterService.vaccinationCenters) {
            if (!vaccinationCenter.getCode().equals(code)) {
                List<Timeslot> otherCenterTimeslots = vaccinationCenter.getTimeslots();
                for (Timeslot centerTimeslot : otherCenterTimeslots) {
                    Doctor timeslotDoctor = centerTimeslot.getDoctor();
                    if (timeslotDoctor != null && timeslotDoctor.equals(doctor)) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The requested doctor is not available at this center.");
                    }
                }
            }
        }
        return true;
    }


}
