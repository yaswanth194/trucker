package egen.project.service;

import egen.project.entity.Reading;
import org.springframework.stereotype.Service;

public interface ReadingService {
    public void update(Reading read);
    public void checkAlerts(Reading read);

}
