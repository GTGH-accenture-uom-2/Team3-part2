package gr.accenture.team3.models;

import gr.accenture.team3.validators.AFMValidator;
import gr.accenture.team3.validators.AmkaValidator;
import gr.accenture.team3.validators.EmailValidator;
import gr.accenture.team3.validators.NameSurnameValidator;

import java.time.LocalDate;


public class Insured {
    private AFMValidator afm;
    private AmkaValidator amka;
    private NameSurnameValidator name;
    private NameSurnameValidator surname;
    private LocalDate birthdate;
    private EmailValidator email;
    private int changeReservationsCounter;

    public Insured(String afm, String amka, String name, String surname, String email, LocalDate birthdate) {
        this.afm = new AFMValidator(afm);
        this.amka = new AmkaValidator(amka, birthdate);
        this.name = new NameSurnameValidator(name);
        this.surname = new NameSurnameValidator(surname);
        this.email = new EmailValidator(email);
        this.birthdate = birthdate;
        changeReservationsCounter=0;
    }
    public void increaseChangeReservationCounter(){
        changeReservationsCounter++;
    }

    public int getChangeReservationsCounter(){
        return changeReservationsCounter;
    }

    public String getAfm() {
        return afm.getAfm();
    }

    public void setAfm(String afm) {
        this.afm = new AFMValidator(afm);
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

    public String getEmail() {
        return email.getEmailAddress();
    }

    public void setEmail(String email) {
        this.email = new EmailValidator(email);
    }
}
