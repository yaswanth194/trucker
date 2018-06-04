package egen.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Vehicle {
    @Id
    private String vin;
    private String make;
    private String model;
    private int year;
    private float redlineRpm;
    private float maxFuelVolume;
    private Timestamp lastServiceDate;

    public Vehicle(){

    }

    public Vehicle(String vin, String make, String model, int year, float redlineRpm, float maxFuelVolume, Timestamp lastServiceDate) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.redlineRpm = redlineRpm;
        this.maxFuelVolume = maxFuelVolume;
        this.lastServiceDate = lastServiceDate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(float redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public float getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(float maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
