package egen.project.Repository;

import egen.project.entity.Reading;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ReadingRepository extends CrudRepository<Reading,String> {

    @Query(value = "select * from reading where vin=?1 and timestamp>=(select date_sub(?2,interval 30 minute));",nativeQuery = true)
    List<Reading> findCurrentTime(String s, Timestamp ts);

}
