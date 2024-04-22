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
    public CommandLineRunner commandLineRunner
            (InsuredService insuredService,
             ReservationService reservationService,
             VaccinationService vaccinationService,
             DoctorService doctorService,
             TimeslotService timeslotService){
        return args -> {
//           timeslotService.addTimeslot(
//                    new Timeslot(1,LocalDate.of(2024,4,25), LocalTime.now(),LocalTime.now(),doctorService.getAllDoctors().get(0)));
//            timeslotService.addTimeslot(
//                    new Timeslot(2,LocalDate.of(2024,4,10)));
           insuredService.addInsured(
                    new Insured("123456789","12345678901","Nikos","Nikolaidis","12-34-90","example@example.gr"));
           reservationService.addReservation(
                    new Reservation(insuredService.getInsureds().get(0),null, LocalDate.of(2021,4,10)));
           vaccinationService.addVaccination(
                    new Vaccination(insuredService.getInsureds().get(0),null,null, LocalDate.of(2021,4,10)));
           doctorService.addDoctor(
                    new Doctor("27059500515", "Leonidas", "Bozatzidis", LocalDate.of(1996, 10, 15)));

            LocalDate today = LocalDate.now();
            timeslotService.generateTimeslotsForPeriod(today, 30);

        };


    };


}
