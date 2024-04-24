package gr.accenture.team3.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VaccinationCenter {
    private Integer code;
    private String address;
    private List<Timeslot> timeslots = new ArrayList<>();

    public VaccinationCenter(Integer code, String address) {
        this.code = code;
        this.address = address;
        generateTimeslotsForPeriod(LocalDate.now(), 30);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(List<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }

    
}
