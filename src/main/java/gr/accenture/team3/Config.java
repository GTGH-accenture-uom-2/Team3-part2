package gr.accenture.team3;

import gr.accenture.team3.models.Doctor;
import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Reservation;
import gr.accenture.team3.models.Vaccination;
import gr.accenture.team3.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

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
           insuredService.addInsured(
                    new Insured("123456789","12345678901","Leonidas","Nikolaidis","12-34-90","example@example.gr"));
           insuredService.addInsured(
                    new Insured("123456789","12345678901","Vasiliki","Nikolaidis","12-34-90","example@example.gr"));
           insuredService.addInsured(
                    new Insured("123456789","12345678901","Kiki","Nikolaidis","12-34-90","example@example.gr"));
           insuredService.addInsured(
                    new Insured("123456789","12345678901","Vaso","Nikolaidis","12-34-90","example@example.gr"));
           reservationService.addReservation(
                    new Reservation(insuredService.getInsureds().get(0),null, LocalDate.of(2024,06,10)));
           reservationService.addReservation(
                    new Reservation(insuredService.getInsureds().get(1),null, LocalDate.of(2024,04,21)));
           reservationService.addReservation(
                    new Reservation(insuredService.getInsureds().get(2),null, LocalDate.of(2024,04,21)));
           reservationService.addReservation(
                    new Reservation(insuredService.getInsureds().get(3),null, LocalDate.of(2024,04,21)));
           doctorService.addDoctor(
                    new Doctor("27059500515", "Leonidas", "Bozatzidis", LocalDate.of(1996, 10, 15)));
           LocalDate today = LocalDate.now();
           timeslotService.generateTimeslotsForPeriod(today, 30);
        };
    };


}
