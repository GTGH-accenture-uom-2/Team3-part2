package gr.accenture.team3.models;


import gr.accenture.team3.validators.AmkaValidator;
import gr.accenture.team3.validators.NameSurnameValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Doctor {
    private AmkaValidator amka;
    private NameSurnameValidator name;
    private NameSurnameValidator surname;
    private LocalDate birthdate;

    public Doctor(String amka,String name,String surname,LocalDate birthdate){
        this.amka = new AmkaValidator(amka, birthdate);
        this.name = new NameSurnameValidator(name);
        this.surname = new NameSurnameValidator(surname);
        this.birthdate=birthdate;
    }

    public String getAmka() {
        return amka.getAmka();
    }

    public void setAmka(String amka) {
        this.amka = new AmkaValidator(amka, this.birthdate);
    }

    public String getName() {
        return name.getNameOrSurname();
    }

    public void setName(String name) {
        this.name = new NameSurnameValidator(name);
    }

    public String getSurname() {
        return surname.getNameOrSurname();
    }

    public void setSurname(String surname) {
        this.surname = new NameSurnameValidator(surname);
    }

    public LocalDate getBirthday() {
        return birthdate;
    }

    public void setBirthday(LocalDate birthday) {
        this.amka = new AmkaValidator(this.amka.getAmka(), birthdate);
        this.birthdate = birthdate;
    }

}