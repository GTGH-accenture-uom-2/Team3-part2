package gr.accenture.team3.services;

import gr.accenture.team3.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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



    public Vaccination getVaccinationStatus(String amka){
        for(Vaccination vaccination: vaccinations){
            if(vaccination.getInsured().equals(insuredService.getInsuredByAmka(amka))){
                return vaccination;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "This insured is not vaccinated!");
    }

    public Vaccination declareVaccination(String amka,Long idTimeslot,LocalDate expDate){
        Reservation res=reservationService.getReservationByAmka(amka,idTimeslot);
        Vaccination vaccination=new Vaccination(res.getInsured(),res.getTimeslot().getDoctor(),
                res.getTimeslot(),res.getTimeslot().getDate());
        vaccination.setExpirationDate(expDate);
        vaccinations.add(vaccination);

        return vaccination;
    }

//    //!expdate?
//    public String declareVaccinationAmkaInsured(String insuredAmka){
//        List<Insured> insureds= reservationService.getAllInsured();
//        for (Insured insured: insureds){
//            if (insuredAmka == insured.getAmka()){
//                return insuredAmka;
//            }
//        }
//        return null;
//    }
//
//    public Long declareVaccinationIdTimeslot(Long idTimeslot){
//        List<Timeslot> timeslots=reservationService.getAllTimeslots();
//        for (Timeslot timeslot:timeslots){
//            if (timeslot.getId()==idTimeslot){
//                return idTimeslot;
//            }
//        }
//        return null;
//    }
}
