package egen.project.service;

import egen.project.entity.Alerts;

import java.util.List;

public interface AlertService {
    public List<Alerts> getAllAlerts(String vin);
}
