package gr.accenture.team3.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Doctor {
    private String amka;
    private String name;
    private String surname;
    private LocalDate birthDate;

    public Doctor(String amka,String name,String surname,LocalDate birthDate){
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.birthDate=birthDate;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}