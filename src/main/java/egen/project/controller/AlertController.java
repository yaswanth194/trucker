package egen.project.controller;

import egen.project.entity.Alerts;
import egen.project.service.AlertService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io")
@RequestMapping("/alerts")
public class AlertController {
    @Autowired
    AlertService alertService;

    @ApiOperation(value = "Returns all alerts with in last two hours")
    @GetMapping()
    public List<Alerts> getAlertsForTwoHours(){
        return alertService.getAllAlertsForTwoHours();

    }

    @ApiOperation(value = "Lists a vehicles all historic alerts")
    @RequestMapping(method = RequestMethod.GET,value="/{vin}")
    public List<Alerts> listAllAlerts(@PathVariable("vin") String vin){
        List<Alerts> returnAlerts= alertService.getAllAlerts(vin);
        return returnAlerts;
    }
}
