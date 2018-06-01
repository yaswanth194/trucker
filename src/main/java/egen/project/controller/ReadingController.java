package egen.project.controller;

import egen.project.entity.Reading;
import egen.project.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io")
@RequestMapping(value="/readings")
public class ReadingController {
    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void saveReadings(@RequestBody Reading read){
        readingService.update(read);

        readingService.checkAlerts(read);



    }
}
