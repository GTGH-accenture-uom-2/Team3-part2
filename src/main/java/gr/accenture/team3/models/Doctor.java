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
    private List<Timeslot> timeSlots;
    private List<Vaccination> vaccinations;

    public Doctor(String amka,String name,String surname,LocalDate birthDate){
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.birthDate=birthDate;
//        this.timeSlots = new ArrayList<>();
//        vaccinations = new ArrayList<>();
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

    public List<Timeslot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<Timeslot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }
}