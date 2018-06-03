package egen.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Alerts implements Serializable {
    @Id
    private String alertId;
    @Column(nullable = false)
    private String vin;
    private String priority;
    private Timestamp timestamp;

    public Alerts(){
        this.alertId=UUID.randomUUID().toString();
    }

    public Alerts(String vin, String priority, Timestamp timestamp) {
        this.alertId=UUID.randomUUID().toString();
        this.vin = vin;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "alertId='" + alertId + '\'' +
                ", vin='" + vin + '\'' +
                ", priority='" + priority + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
