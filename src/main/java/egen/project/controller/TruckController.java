package egen.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TruckController {
    @RequestMapping("/vehicles")
    public String printController(){
        return "awesome";
    }
}
