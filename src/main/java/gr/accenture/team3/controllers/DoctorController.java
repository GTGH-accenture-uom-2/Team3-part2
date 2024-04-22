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
    @PostMapping
    public List<Doctor> addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

//    @PutMapping
//    public Long TimeslotId(@RequestParam Long id){
//        return doctorService.insertTimeslotId(id);
//    }




}
