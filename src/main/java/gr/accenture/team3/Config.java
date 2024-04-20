package gr.accenture.team3;

import gr.accenture.team3.models.Insured;
import gr.accenture.team3.models.Vaccination;
import gr.accenture.team3.services.InsuredService;
import gr.accenture.team3.services.VaccinationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public CommandLineRunner commandLineRunner
            (InsuredService insuredService){
        return args -> {
            insuredService.addInsured(
                    new Insured("123456789","12345678901","Nikos","Nikolaidis","12-34-90","example@example.gr"));

        };
    }

}
