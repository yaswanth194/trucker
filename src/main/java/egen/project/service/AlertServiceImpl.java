package egen.project.service;

import egen.project.Exception.NoContentFoundException;
import egen.project.Exception.ResourceNotFoundException;
import egen.project.Repository.AlertRepository;
import egen.project.entity.Alerts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository alertRepository;

    @Transactional
    public List<Alerts> getAllAlerts(String vin){
        List<Alerts> alertsList= alertRepository.findAllByVin(vin);
        if(alertsList.isEmpty()){
            throw new ResourceNotFoundException("Vin "+vin+" Not Found");
        }
        return alertsList;


    }

    @Transactional
    public List<Alerts> getAllAlertsForTwoHours() {
        Calendar calendar = Calendar.getInstance();
        Date now =calendar.getTime();
        List<Alerts> allAlerts= alertRepository.getAlertsForTwoHours(new Timestamp(now.getTime()));
        if(allAlerts.isEmpty()){
            throw new NoContentFoundException("No Alerts for last two hours");
        }
        return allAlerts;

    }
}
