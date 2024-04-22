package gr.accenture.team3.services;

import gr.accenture.team3.models.Doctor;
import gr.accenture.team3.models.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
     InsuredService insuredService;
    @Autowired
    VaccinationService vaccinationService;
    @Autowired
     TimeslotService timeslotService;
    List<Doctor> doctors = new ArrayList<>();
    public List<Doctor> getAllDoctors(){
        return doctors;
    }

    public List<Doctor> addDoctor(Doctor doctor){
        doctors.add(doctor);
        return doctors;
    }



}

