package egen.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Alerts {
    @Id
    private String alertId;
    private String vin;
    private String priority;
    private Timestamp timestamp;

    protected Alerts(){
        this.alertId=UUID.randomUUID().toString();
    }

    public Alerts(String vin, String priority, Timestamp timestamp) {
        this.alertId=UUID.randomUUID().toString();
        this.vin = vin;
        this.priority = priority;
        this.timestamp = timestamp;
    }
}
