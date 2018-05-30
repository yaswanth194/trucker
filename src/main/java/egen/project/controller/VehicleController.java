package egen.project.controller;

import egen.project.entity.Vehicle;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value="/vehicles")
public class VehicleController {
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void printController(@RequestBody Vehicle each[]){


    }
}
