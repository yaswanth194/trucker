package egen.project.service;

import egen.project.entity.Reading;

import java.util.List;

public interface ReadingService {
    public void update(Reading read);
    public void checkAlerts(Reading read);

    List<Reading> getAllReadings(String vin);
}
