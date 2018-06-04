package egen.project.service;

import egen.project.entity.Alerts;

import java.sql.Timestamp;
import java.util.List;

public interface AlertService {
    public List<Alerts> getAllAlerts(String vin);
    public List<Alerts> getAllAlertsForTwoHours();
}
