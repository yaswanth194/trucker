package egen.project.controller;

import egen.project.entity.GeoPostion;
import egen.project.entity.Reading;
import egen.project.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @GetMapping(value="/{vin}")
    public List<GeoPostion> getReadingsForThirtyMinutes(@PathVariable("vin") String vin){
        return readingService.getAllReadings(vin);

    }
}
