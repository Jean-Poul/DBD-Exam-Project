package db.repository;

import db.dto.CourierDTO;
import db.dto.CustomerDTO;
import db.entity.Courier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourierRepo extends CrudRepository<Courier, Integer> {
    @Query("SELECT c from Courier c")
    List<Courier> getAllCouriers();


}
