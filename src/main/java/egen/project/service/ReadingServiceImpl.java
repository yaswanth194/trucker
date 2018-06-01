package egen.project.service;

import egen.project.Repository.AlertRepository;
import egen.project.Repository.ReadingRepository;
import egen.project.Repository.VehicleRepository;
import egen.project.entity.Alerts;
import egen.project.entity.Reading;
import egen.project.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    AlertRepository alertRepository;
    @Transactional
    public void update(Reading read) {
        readingRepository.save(read);

    }

    @Transactional
    @Async
    public void checkAlerts(Reading read) {
        Optional<Vehicle> temp=vehicleRepository.findById(read.getVin());
        Calendar calendar = Calendar.getInstance();
        Date now =calendar.getTime();
        if(read.getEngineRpm()>temp.get().getReadlineRpm()){
            alertRepository.save(new Alerts(read.getVin(),"HIGH",new Timestamp(now.getTime())));
        }
        if(read.getFuelVolume()<((10*temp.get().getMaxFuelVolume())/100)){
            alertRepository.save(new Alerts(read.getVin(),"MEDIUM",new Timestamp(now.getTime())));
        }
        if((read.getTires().getFrontLeft()<32 ||read.getTires().getFrontLeft()>36)||(read.getTires().getFrontRight()<32 ||read.getTires().getFrontRight()>36)){
            alertRepository.save(new Alerts(read.getVin(),"LOW",new Timestamp(now.getTime())));
        }
        if((read.getTires().getRearLeft()<32 ||read.getTires().getRearLeft()>36)||(read.getTires().getRearRight()<32 ||read.getTires().getRearRight()>36)){
            alertRepository.save(new Alerts(read.getVin(),"LOW",new Timestamp(now.getTime())));
        }
        if(read.isEngineCoolantLow()||read.isCheckEngineLightOn()){
            alertRepository.save(new Alerts(read.getVin(),"LOW",new Timestamp(now.getTime())));
        }



    }
}
