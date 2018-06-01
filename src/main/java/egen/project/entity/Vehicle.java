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
    private int readlineRpm;
    private float maxFuelVolume;
    private Timestamp lastServiceDate;

    protected Vehicle(){

    }
    Vehicle(String vin, String make, String model, int year, int readlineRpm, float maxFuelVolume, Timestamp lastServiceDate){
        this.vin=vin;
        this.make=make;
        this.model=model;
        this.year=year;
        this.readlineRpm=readlineRpm;
        this.maxFuelVolume=maxFuelVolume;
        this.lastServiceDate=lastServiceDate;
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

    public int getReadlineRpm() {
        return readlineRpm;
    }

    public void setReadlineRpm(int readlineRpm) {
        this.readlineRpm = readlineRpm;
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
