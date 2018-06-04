package egen.project.service;

import egen.project.Exception.ResourceNotFoundException;
import egen.project.Repository.AlertRepository;
import egen.project.Repository.ReadingRepository;
import egen.project.Repository.VehicleRepository;
import egen.project.entity.Alerts;
import egen.project.entity.GeoPostion;
import egen.project.entity.Reading;
import egen.project.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;


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
        if(read.getEngineRpm()>temp.get().getRedlineRpm()){
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

    @Transactional
    public List<GeoPostion> getAllReadings(String vin){
        Calendar calendar = Calendar.getInstance();
        Date now =calendar.getTime();
        List<Reading> allAlerts= readingRepository.findCurrentTime(vin,new Timestamp(now.getTime()));
        if(allAlerts.isEmpty()){
            throw new ResourceNotFoundException("VIN "+vin+" doesn't exist");
        }
        List<GeoPostion> geoPostions=new ArrayList<GeoPostion>();
        for(Reading tempReading:allAlerts){
            GeoPostion geoPostion=new GeoPostion();
            geoPostion.setLatitude(tempReading.getLatitude());
            geoPostion.setLongitude(tempReading.getLongitude());
            geoPostion.setTimestamp(tempReading.getTimestamp());
            geoPostions.add(geoPostion);
        }
        return geoPostions;

    }
}
