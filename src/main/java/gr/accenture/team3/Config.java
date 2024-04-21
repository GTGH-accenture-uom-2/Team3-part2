package gr.accenture.team3;

import gr.accenture.team3.models.Doctor;
import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Vaccination;
import gr.accenture.team3.services.DoctorService;
import gr.accenture.team3.services.InsuredService;
import gr.accenture.team3.services.VaccinationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Config {
    @Bean
    public CommandLineRunner commandLineRunner
            (InsuredService insuredService, DoctorService doctorService) {
        return args -> {
            insuredService.addInsured(
                    new Insured("123456789", "12345678901", "Nikos", "Nikolaidis", "12-34-90", "example@example.gr"));
            doctorService.addDoctor(
                    new Doctor("27059500515", "Leonidas", "Bozatzidis", LocalDate.of(1996, 10, 15)));
        };
    }
}

