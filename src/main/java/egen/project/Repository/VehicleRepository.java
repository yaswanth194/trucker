package egen.project.Repository;

import egen.project.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle,String> {
}
