package gr.accenture.team3.services;

import gr.accenture.team3.models.Doctor;
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
        doctors.add(doctor);
        return doctors;
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

