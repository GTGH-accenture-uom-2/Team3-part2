package gr.accenture.team3;

import gr.accenture.team3.models.*;
import gr.accenture.team3.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class Config {
    @Bean
    public CommandLineRunner commandLineRunner(
            InsuredService insuredService,
            ReservationService reservationService,
            VaccinationService vaccinationService,
            DoctorService doctorService,
            TimeslotService timeslotService,
            VaccinationCenterService vaccinationCenterService)
    {

        return args -> {

            Doctor sampleDoctor1 = new Doctor("15108608516", "Giorgos", "Papadopoulos", LocalDate.of(1986, 10, 15));
            Doctor sampleDoctor2 = new Doctor("11059019501", "Maria", "Nikolinakou", LocalDate.of(1990, 05, 11));

            doctorService.addDoctor(sampleDoctor1);
            doctorService.addDoctor(sampleDoctor2);

            Insured sampleInsured1 = new Insured("160244981","27059500515","Leonidas","Bozatzidis","leonidas@gmail.com",LocalDate.of(1995,05,27));
            Insured sampleInsured2 = new Insured("222134112","16069851985","Vasiliki","Kopetsidou","vasilikikoupe@gmail.com",LocalDate.of(1998,06,16));
            Insured sampleInsured3 = new Insured("532952922","25019859151","Kiriaki","Diggelidou","kiriaki@gmail.com",LocalDate.of(1998,01,25));
            Insured sampleInsured4 = new Insured("348838588","21069856514","Vasiliki","Karouta","vasilikikarouta@gmail.com",LocalDate.of(1998,06,21));
            Insured sampleInsured5 = new Insured("348818588","22029512345","Nikos","Nikolaidis","Nikos@gmail.com",LocalDate.of(1995,02,22));
            Insured sampleInsured6 = new Insured("123456789","03069701567","Marios","Nikolaidis","marios@gmail.com",LocalDate.of(1997,06,03));
            Insured sampleInsured7 = new Insured("358838588","21029856514","Maria","Papadopoulou","maria@gmail.com",LocalDate.of(1998,02,21));
            Insured sampleInsured8 = new Insured("348818555","22119512345","Eleni","Nikolaidou","eleni@gmail.com",LocalDate.of(1995,11,22));
            Insured sampleInsured9 = new Insured("348818577","12034512345","Maria","Papadopoulou","papadopoulou@gmail.com",LocalDate.of(1945,03,12));
            Insured sampleInsured10 = new Insured("348818578","03069712345","Vaso","Papadopoulou","papadopoulou@gmail.com",LocalDate.of(1997,06,03));

            insuredService.addInsured(sampleInsured1);
            insuredService.addInsured(sampleInsured2);
            insuredService.addInsured(sampleInsured3);
            insuredService.addInsured(sampleInsured4);
            insuredService.addInsured(sampleInsured5);
            insuredService.addInsured(sampleInsured6);
            insuredService.addInsured(sampleInsured7);
            insuredService.addInsured(sampleInsured8);
            insuredService.addInsured(sampleInsured9);
            insuredService.addInsured(sampleInsured10);

            VaccinationCenter firstCenter = new VaccinationCenter(1,"Delfon 124");
            VaccinationCenter secondCenter = new VaccinationCenter(2, "Konstantinoupoleos 49");

            vaccinationCenterService.addVaccinationCenter(firstCenter);
            vaccinationCenterService.addVaccinationCenter(secondCenter);

            Reservation newReservation1 = reservationService.addNewReservation(sampleInsured1.getAmka(),2704241000L,sampleDoctor1.getSurname(),1);
            Reservation newReservation2 = reservationService.addNewReservation(sampleInsured2.getAmka(),2704241030L,sampleDoctor1.getSurname(),1);
            Reservation newReservation3 = reservationService.addNewReservation(sampleInsured3.getAmka(),2704241100L,sampleDoctor1.getSurname(),1);
            Reservation newReservation4 = reservationService.addNewReservation(sampleInsured4.getAmka(),2804241000L,sampleDoctor1.getSurname(),1);
            Reservation newReservation5 = reservationService.addNewReservation(sampleInsured5.getAmka(),2904241000L,sampleDoctor2.getSurname(),2);
            Reservation newReservation6 = reservationService.addNewReservation(sampleInsured6.getAmka(),2904241030L,sampleDoctor2.getSurname(),2);
            Reservation newReservation7 = reservationService.addNewReservation(sampleInsured7.getAmka(),2904241100L,sampleDoctor2.getSurname(),2);
            Reservation newReservation8 = reservationService.addNewReservation(sampleInsured8.getAmka(),2904241130L,sampleDoctor2.getSurname(),2);

            Vaccination vaccination1 = new Vaccination(insuredService.getInsuredByAmka(sampleInsured3.getAmka()),sampleDoctor1,timeslotService.getTimeslotById(2704241100L),timeslotService.getTimeslotById(2704241100L).getDate());
            Vaccination vaccination2 = new Vaccination(insuredService.getInsuredByAmka(sampleInsured4.getAmka()),sampleDoctor1,timeslotService.getTimeslotById(2804241000L),timeslotService.getTimeslotById(2704241100L).getDate());
            Vaccination vaccination3 = new Vaccination(insuredService.getInsuredByAmka(sampleInsured5.getAmka()),sampleDoctor2,timeslotService.getTimeslotById(2704241000L),timeslotService.getTimeslotById(2704241100L).getDate());
            Vaccination vaccination4 = new Vaccination(insuredService.getInsuredByAmka(sampleInsured6.getAmka()),sampleDoctor2,timeslotService.getTimeslotById(2804241030L),timeslotService.getTimeslotById(2704241100L).getDate());
            Vaccination vaccination5 = new Vaccination(insuredService.getInsuredByAmka(sampleInsured7.getAmka()),sampleDoctor2,timeslotService.getTimeslotById(2804241100L),timeslotService.getTimeslotById(2704241100L).getDate());

            vaccinationService.addVaccination(vaccination1);
            vaccinationService.addVaccination(vaccination2);
            vaccinationService.addVaccination(vaccination3);
            vaccinationService.addVaccination(vaccination4);
            vaccinationService.addVaccination(vaccination5);


        };
    }
}




