package gr.accenture.team3.models;

public class VaccinationCenter {
    private Long code;
    private String address;
    private Timeslot timeslots;

    public VaccinationCenter(Long code, String address, Timeslot timeslots) {
        this.code = code;
        this.address = address;
        this.timeslots = timeslots;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timeslot getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(Timeslot timeslots) {
        this.timeslots = timeslots;
    }
}
