package egen.project.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Reading {
    @Id
    private String id;
    private String vin;
    private double latitude;
    private double longitude;
    private Timestamp timestamp;
    private double fuelVolume;
    private float speed;
    private float engineHp;
    private boolean checkEngineLightOn;
    private boolean cruiseControlOn;
    private boolean engineCoolantLow;
    private float engineRpm;
    private Tires tires;

    public Reading() {
        this.id=UUID.randomUUID().toString();

    }

    public Reading(String id, String vin, double latitude, double longitude, Timestamp timestamp, double fuelVolume, float speed, float engineHp, boolean checkEngineLightOn, boolean cruiseControlOn, boolean engineCoolantLow, float engineRpm, Tires tires) {
        this.id = id;
        this.vin = vin;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.fuelVolume = fuelVolume;
        this.speed = speed;
        this.engineHp = engineHp;
        this.checkEngineLightOn = checkEngineLightOn;
        this.cruiseControlOn = cruiseControlOn;
        this.engineCoolantLow = engineCoolantLow;
        this.engineRpm = engineRpm;
        this.tires = tires;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(float engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public float getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(float engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }
}
