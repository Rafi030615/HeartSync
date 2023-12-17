package app.tubespbo;

import java.time.LocalDate;

public class Counseling {
    private LocalDate schedule;
    private String teman;
    private String status;
    private String curhat;
    private String location;
    private double price;

    public Counseling(LocalDate schedule, String location, double price, String teman, String curhat, String status) {
        this.schedule = schedule;
        this.location = location;
        this.price = price;
        this.teman = teman;
        this.curhat = curhat;
        this.status = status;

    }

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTeman() {
        return teman;
    }

    public void setTeman(String teman) {
        this.teman = teman;
    }

    public String getCurhat() {
        return curhat;
    }

    public void setCurhat(String curhat) {
        this.curhat = curhat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return schedule + "," + location + "," + price + "," + teman + "," + curhat + "," + status;
    }
}

