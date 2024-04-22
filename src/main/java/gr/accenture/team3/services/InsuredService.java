package gr.accenture.team3.services;

import gr.accenture.team3.models.Insured;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class InsuredService {
    List<Insured> insureds=new ArrayList<>();

    public List<Insured> getInsureds() {
        return insureds;
    }

    public Insured getInsuredByAmka(String amka){
        for(Insured insured: insureds){
            if(insured.getAmka().equals(amka)){
                return insured;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "This amka doesn't belong to anyone!");
    }

    public List<Insured> addInsured(Insured insured) {
        try {
            for (Insured existingInsured : insureds) {
                if (existingInsured.getAfm().equals(insured.getAfm())) {
                    throw new IllegalStateException("An insured with this AFM already exists.");
                }
            }
            insureds.add(insured);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return insureds;
    }

    public void deleteInsured(String afm) {
        Iterator<Insured> iterator = insureds.iterator();
        while (iterator.hasNext()) {
            Insured insured = iterator.next();
            if (insured.getAfm().equals(afm)) {
                iterator.remove();
                return;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insured with this AFM not found.");
    }

}
