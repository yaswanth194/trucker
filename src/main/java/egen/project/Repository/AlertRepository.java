package egen.project.Repository;

import egen.project.entity.Alerts;
import org.springframework.data.repository.CrudRepository;

public interface AlertRepository extends CrudRepository<Alerts,String> {
}
