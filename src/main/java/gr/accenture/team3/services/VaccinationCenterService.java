package gr.accenture.team3.services;

import gr.accenture.team3.models.Timeslot;
import gr.accenture.team3.models.Vaccination;
import gr.accenture.team3.models.VaccinationCenter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterService {
    List<VaccinationCenter> vaccinationCenters = new ArrayList<>();
    List<Timeslot> timeslots =new ArrayList<>();
    public List<VaccinationCenter> addVaccinationCenter( VaccinationCenter vaccinationCenter){
        vaccinationCenters.add(vaccinationCenter);
        return vaccinationCenters;
    }

    public List<VaccinationCenter> getVaccinationCenters(){
        return vaccinationCenters;
    }

    public VaccinationCenter getVaccinationCenterByCode(Integer code){
        for(VaccinationCenter center: vaccinationCenters){
            if(center.getCode().equals(code)){
                return center;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested center does not exist.");
    }
    public List<Timeslot> getAllTimeslotsPerVacCenter(Integer code) {
        VaccinationCenter center = getVaccinationCenterByCode(code);
        timeslots = center.getTimeslots();
        return timeslots;
    }
}
