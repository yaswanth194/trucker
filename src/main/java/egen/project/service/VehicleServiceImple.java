package egen.project.service;

import egen.project.Repository.VehicleRepository;
import egen.project.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
