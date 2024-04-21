package gr.accenture.team3.services;

import gr.accenture.team3.models.Vaccination;
import gr.accenture.team3.models.VaccinationCenter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterService {
    List<VaccinationCenter> vaccinationCenters = new ArrayList<>();
    public List<VaccinationCenter> addVaccinationCenter( VaccinationCenter vaccinationCenter){
        vaccinationCenters.add(vaccinationCenter);
        return vaccinationCenters;
    }

    public List<VaccinationCenter> getVaccinationCenters(){
        return vaccinationCenters;
    }
}
