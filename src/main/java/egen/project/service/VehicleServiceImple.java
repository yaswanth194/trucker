package egen.project.service;

import egen.project.Repository.AlertRepository;
import egen.project.Repository.VehicleRepository;
import egen.project.entity.Alerts;
import egen.project.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImple implements VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional
    public void update(Vehicle[] each) {
        for(Vehicle v:each){
            vehicleRepository.save(v);
        }
    }

    @Transactional
    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

}
