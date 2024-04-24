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

    public void generateTimeslotsForPeriod(LocalDate startDate, int days) {
        DateTimeFormatter idFormatter = DateTimeFormatter.ofPattern("ddMMyy");
        LocalDate date = startDate;
        for (int i = 0; i < days; i++) {
            String baseId = date.format(idFormatter);
            LocalTime time = LocalTime.of(10, 0);
            for (int j = 0; j < 10; j++) { // 10 timeslots per day
                String timeId = String.format("%02d%02d", time.getHour(), time.getMinute());
                Long id = Long.parseLong(baseId + timeId);
                Timeslot timeslot = new Timeslot(id, date, time, time.plusMinutes(30), null);
                timeslots.add(timeslot);
                time = time.plusMinutes(30);
            }
            date = date.plusDays(1);
        }
    }
}
