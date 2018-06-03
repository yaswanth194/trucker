package egen.project.service;

import egen.project.Repository.AlertRepository;
import egen.project.entity.Alerts;
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
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class AlertServiceImplTest {

    @TestConfiguration
    static class AlertServiceImplTestConfiguration{

        @Bean
        public AlertService getService(){
            return new AlertServiceImpl();
        }
    }

    @Autowired
    AlertService alertService;

    @MockBean
    AlertRepository alertRepository;

    private List<Alerts> allAlerts;
    @Before
    public void setUp(){
        Alerts aler= new Alerts();
        aler.setAlertId(UUID.randomUUID().toString());
        aler.setPriority("HIGH");
        aler.setVin("1HGCR2F3XFA027534");
        Calendar calendar = Calendar.getInstance();
        Date now =calendar.getTime();
        aler.setTimestamp(new Timestamp(now.getTime()));

        allAlerts=Collections.singletonList(aler);

        Mockito.when(alertRepository.findAllByVin(aler.getVin())).thenReturn(allAlerts);
        Mockito.when(alertRepository.getAlertsForTwoHours(aler.getTimestamp())).thenReturn(allAlerts);

    }



    @Test
    public void getAllAlerts() {
        List<Alerts> all= alertService.getAllAlerts("1HGCR2F3XFA027534");
        assertEquals("Should Match",allAlerts,all);
    }

    @Test
    public void getAllAlertsForTwoHours() {
        List<Alerts> all=alertService.getAllAlertsForTwoHours();
        assertEquals("Should Match",allAlerts,all);
    }
}