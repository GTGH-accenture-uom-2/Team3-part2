package gr.accenture.team3.services;

import gr.accenture.team3.models.Doctor;
import gr.accenture.team3.models.Insured;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    List<Doctor> doctors = new ArrayList<>();
    public List<Doctor> getAllDoctors(){
        return doctors;
    }

    public List<Doctor> addDoctor(Doctor doctor){
        try {
            for (Doctor existingdoctor : doctors) {
                if (existingdoctor.getAmka().equals(doctor.getAmka())) {
                    throw new IllegalStateException("A Doctor with this AMKA already exists.");
                }
            }
            doctors.add(doctor);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return doctors;
    }

    public Doctor getDoctorByAMKA(String amka) {
        try {
            for (Doctor doctor : doctors) {
                if (doctor.getAmka().equals(amka)) {
                    return doctor;
                }
            }
            throw new Exception("Doctor not found with the specified AMKA.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    public List<Doctor> deleteDoctorByAMKA(String amka) {
        Doctor doctorTodelete = null;
        for (Doctor doctor : doctors) {
            if (doctor.getAmka().equals(amka)) {
                doctorTodelete = doctor;
                break;
            }
        }
        if (doctorTodelete != null) {
            doctors.remove(doctorTodelete);
            return doctors;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with the specified AMKA.");
        }
    }

    public Doctor getDoctorBySurname(String surname){
        for(Doctor doctor:doctors){
            if(doctor.getSurname().equals(surname)){
                return doctor;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested doctor does not exist.");
    }
}

