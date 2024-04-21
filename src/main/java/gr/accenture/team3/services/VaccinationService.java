package gr.accenture.team3.services;

import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Timeslot;
import gr.accenture.team3.models.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VaccinationService {
    @Autowired
    InsuredService insuredService;
    @Autowired
    ReservationService reservationService;

    List<Vaccination> vaccinations = new ArrayList<>();
    Map<Insured, Timeslot> insuredTimeslotMap = new HashMap<>();


    public List<Vaccination> addVaccination(Vaccination vaccination) {
        vaccinations.add(vaccination);
        return vaccinations;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }
//    public List<Insured> addVaccinations(List<Insured> insureds, List<Timeslot> timeslots){ //kanonika edw thelei Reservation kai na pairnei orismata apo ekei
//    for(Insured ins: insureds){
//        vaccinations.add(new Vaccination(insureds(ins),))
//    }
// }



    public List<Vaccination> addVaccinations(List<Insured> insureds, List<Timeslot> timeslots) {
        insureds = reservationService.getAllInsured(); //insured που εκλεισαν ραντεβου
        timeslots = reservationService.getAllTimeslots(); //timeslots from reservation

        for(int i = 0; i < insureds.size(); i++) {
            insuredTimeslotMap.put(insureds.get(i), timeslots.get(i));
        }

        for(Map.Entry<Insured, Timeslot> entry : insuredTimeslotMap.entrySet()) {
            Insured insured = entry.getKey();
            Timeslot timeslot = entry.getValue();
            vaccinations.add(new Vaccination(insured,"", timeslot,"","","",));
        }

        return vaccinations;
    }
    public Vaccination getVaccinationStatus(String amka){
        for(Vaccination vaccination: vaccinations){
            if(vaccination.getInsured().equals(insuredService.getInsuredByAmka(amka))){
                return vaccination;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "This insured is not vaccinated!");
    }
}
