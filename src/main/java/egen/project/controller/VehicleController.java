package egen.project.controller;

import egen.project.entity.Vehicle;
import egen.project.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io")
@RequestMapping(value="/vehicles")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void printController(@RequestBody Vehicle each[]){
        vehicleService.update(each);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();

    }
}
