package egen.project.Repository;

import egen.project.entity.Alerts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface AlertRepository extends CrudRepository<Alerts,String> {
    List<Alerts> findALLByVin(String vin);


}
