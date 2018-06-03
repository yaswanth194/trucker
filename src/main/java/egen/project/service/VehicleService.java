package egen.project.service;

import egen.project.entity.Alerts;
import egen.project.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public void update(Vehicle each[]);
    public List<Vehicle> getAllVehicles();

}
