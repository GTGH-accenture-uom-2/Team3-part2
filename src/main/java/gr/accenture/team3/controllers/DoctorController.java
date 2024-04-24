package gr.accenture.team3.controllers;

import gr.accenture.team3.models.Doctor;
import gr.accenture.team3.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{amka}")
    public Doctor getDoctorByAMKA(@PathVariable String amka) {
        return doctorService.getDoctorByAMKA(amka);
    }

    @PostMapping
    public List<Doctor> addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/{amka}")
    public List<Doctor> deleteDoctorByAMKA(@PathVariable String amka) {
        return doctorService.deleteDoctorByAMKA(amka);
    }
}
