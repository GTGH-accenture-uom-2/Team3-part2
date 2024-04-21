package gr.accenture.team3.services;

import gr.accenture.team3.models.Doctor;
import org.springframework.stereotype.Service;

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
}
