package egen.project.service;

import egen.project.Repository.VehicleRepository;
import egen.project.entity.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class VehicleServiceImpleTest {

    @TestConfiguration
    static  class VehicleServiceImpleTestConfiguration{

        @Bean
        public VehicleService getService(){
            return new VehicleServiceImple();
        }
    }

    @Autowired
    VehicleService vehicleService;

    @MockBean
    VehicleRepository vehicleRepository;

    public List<Vehicle> tempList;

    @Before
    public void setUp(){
        Vehicle veh= new Vehicle();
        veh.setVin("1HGCR2F3XFA027534");
        veh.setMake("HONDA");
        veh.setModel("ACCORD");
        veh.setYear(2005);
        veh.setRedlineRpm(5500);
        veh.setMaxFuelVolume(15);
        Calendar calendar = Calendar.getInstance();
        Date now =calendar.getTime();
        veh.setLastServiceDate(new Timestamp(now.getTime()));

        tempList=Collections.singletonList(veh);


        Mockito.when(vehicleRepository.save(veh)).thenReturn(null);
        Mockito.when(vehicleRepository.findAll()).thenReturn(tempList);
    }

    @Test
    public void update() {

    }

    @Test
    public void getAllVehicles() {
        List<Vehicle> newList= vehicleService.getAllVehicles();
        assertEquals("Both should match",newList,tempList);
    }
}