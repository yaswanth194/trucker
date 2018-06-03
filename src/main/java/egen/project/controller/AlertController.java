package egen.project.controller;

import egen.project.entity.Alerts;
import egen.project.service.AlertService;
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

    @RequestMapping(method = RequestMethod.GET,value="/{vin}")
    public List<Alerts> listAllAlerts(@PathVariable("vin") String vin){
        List<Alerts> returnAlerts= alertService.getAllAlerts(vin);
        System.out.println(returnAlerts);
        return returnAlerts;
    }
}
