package egen.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import egen.project.Repository.VehicleRepository;
import egen.project.entity.Vehicle;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("integrationtest")
public class VehicleControllerTest {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mvc;

    @Autowired
    VehicleRepository vehicleRepository;

    @After
    public void breakDown(){
        vehicleRepository.deleteAll();
    }

    @Test
    public void printController() throws Exception {
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

        vehicleRepository.save(veh);
        mvc.perform(MockMvcRequestBuilders.get("/vehicles/")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].make",Matchers.is("HONDA")));
    }

    @Test
    public void getAllVehicles() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/vehicles/")).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testPost() throws Exception{
        Vehicle[] each;
        each= new Vehicle[2];
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

        Vehicle veh1= new Vehicle();
        veh.setVin("1HGCR2F3XFA027534");
        veh.setMake("HONDA");
        veh.setModel("ACCORD");
        veh.setYear(2005);
        veh.setRedlineRpm(5500);
        veh.setMaxFuelVolume(15);
        veh.setLastServiceDate(new Timestamp(now.getTime()));

        each[0]=veh;
        each[1]=veh1;
        mvc.perform(MockMvcRequestBuilders.put("/vehicles").content(mapper.writeValueAsBytes(each)))
                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
    }
}