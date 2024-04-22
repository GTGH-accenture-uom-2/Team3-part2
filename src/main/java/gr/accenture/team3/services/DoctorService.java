package gr.accenture.team3.services;

import gr.accenture.team3.models.Doctor;
import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Timeslot;
import gr.accenture.team3.models.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {
    @Autowired
    ReservationService reservationService;
    @Autowired
    VaccinationService vaccinationService;

    List<Doctor> doctors = new ArrayList<>();
    public List<Doctor> getAllDoctors(){
        return doctors;
    }

    public List<Doctor> addDoctor(Doctor doctor){
        doctors.add(doctor);
        return doctors;
    }


//    public boolean isIdPresentInInsured(String amka) {
//        //List<Insured> insuredList = reservationService.getAllInsured();
//        for (Insured insured : reservationService.getAllInsured()) {
//            if (insured.getAmka() == amka) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public Long insertTimeslotId(Long id){
//        for (Timeslot t: reservationService.getAllTimeslots()){
//            if (t.getId()==id){
//                return id;
//            }
//        }
//        return null;
//    }
}

