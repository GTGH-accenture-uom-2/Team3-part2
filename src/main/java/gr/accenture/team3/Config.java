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
            TimeslotService timeslotService)
    {

        return args -> {
            // Add a sample doctor
            Doctor sampleDoctor = new Doctor("27059500515", "Leonidas", "Bozatzidis", LocalDate.of(1996, 10, 15));
            doctorService.addDoctor(sampleDoctor);

            // Add a sample insured
            Insured sampleInsured1 = new Insured("123456789","12345678901","Nikos","Nikolaidis","12-34-90","example@example.gr");
            Insured sampleInsured2 = new Insured("123456789","12345678902","Leonidas","Bozatzidis","12-34-90","example@example.gr");
            insuredService.addInsured(sampleInsured1);
            insuredService.addInsured(sampleInsured2);

            // Generate timeslots for a period
            LocalDate today = LocalDate.now();
            timeslotService.generateTimeslotsForPeriod(today, 30);

            // Assume the first timeslot of today for simplicity
//            Timeslot sampleTimeslot = timeslotService.getAllTimeslots().stream().findFirst().orElse(null);
//            if (sampleTimeslot != null) {
//                sampleTimeslot.setDoctor(sampleDoctor);  // Assign the doctor to the timeslot
//            }

            // Create a reservation for the sample insured, timeslot, and doctor
//            if (sampleTimeslot != null) {
//                Reservation newReservation = reservationService.addNewReservation(
//                        sampleInsured1.getAmka(),
//                        sampleTimeslot.getId(),
//                        sampleDoctor.getSurname());
//            }
        };
    }
}




