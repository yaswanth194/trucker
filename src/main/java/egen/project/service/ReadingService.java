package egen.project.service;

import egen.project.entity.GeoPostion;
import egen.project.entity.Reading;

import java.util.List;
import java.util.Map;

public interface ReadingService {
    public void update(Reading read);
    public void checkAlerts(Reading read);

    List<GeoPostion> getAllReadings(String vin);
}
