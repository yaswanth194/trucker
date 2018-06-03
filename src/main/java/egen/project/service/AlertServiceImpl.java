package egen.project.service;

import egen.project.Repository.AlertRepository;
import egen.project.entity.Alerts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository alertRepository;

    @Transactional
    public List<Alerts> getAllAlerts(String vin){
        List<Alerts> alertsList= alertRepository.findByVin(vin);
        //List<Alerts> actualAlertsList=alertsList.get();
        return alertsList;


    }
}
