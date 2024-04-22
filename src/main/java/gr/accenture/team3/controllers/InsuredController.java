package gr.accenture.team3.controllers;

import gr.accenture.team3.models.Insured;
import gr.accenture.team3.services.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/insured")
public class InsuredController {
    @Autowired
    InsuredService insuredService;

    @GetMapping("/all")
    public List<Insured> getInsureds() {
        return insuredService.getInsureds();
    }

    @GetMapping("/getInsuredByAmka")
    public Insured getInsuredByAmka(@RequestParam String amka){
        return insuredService.getInsuredByAmka(amka);
    }

    @PostMapping
    public List<Insured> addInsured(@RequestBody Insured insured) {
        return insuredService.addInsured(insured);
    }

    @DeleteMapping("/{afm}") //example http://localhost:8080/insured/123456789
    public HttpStatus deleteInsured(@PathVariable String afm) {
        insuredService.deleteInsured(afm);
        return HttpStatus.OK;
    }



}
