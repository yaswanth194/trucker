package egen.project.controller;

import egen.project.entity.Alerts;
import egen.project.entity.Vehicle;
import egen.project.service.VehicleService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Add Vehicle data into the database")
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void printController(@RequestBody Vehicle each[]){
        vehicleService.update(each);
    }


    @ApiOperation(value = "Returns data of all Vehicles")
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();

    }

}
