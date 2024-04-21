package gr.accenture.team3.models;

public class Insured {
    private String afm;
    private String amka;
    private String name;
    private String surname;
    private String birthday;
    private String email;
    private int changeReservationsCounter;

    public Insured(String afm, String amka, String name, String surname, String birthday, String email) {
        this.afm = afm;
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        changeReservationsCounter=0;
    }

    public void increaseChangeReservationCounter(){ changeReservationsCounter++;}
    public int getChangeReservationsCounter(){ return changeReservationsCounter;}

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
