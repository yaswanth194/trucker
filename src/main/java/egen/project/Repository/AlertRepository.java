package egen.project.Repository;

import egen.project.entity.Alerts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


public interface AlertRepository extends CrudRepository<Alerts,String> {
    List<Alerts> findAllByVin(String vin);

    @Query(value="select * from alerts where priority='HIGH' and timestamp >=(select date_sub(?1,interval 2 hour))",nativeQuery = true)
    List<Alerts> getAlertsForTwoHours(Timestamp st);
}
