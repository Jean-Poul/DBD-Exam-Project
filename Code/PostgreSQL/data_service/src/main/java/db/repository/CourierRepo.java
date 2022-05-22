package db.repository;

import db.entity.Courier;
import org.springframework.data.repository.CrudRepository;

public interface CourierRepo extends CrudRepository<Courier, Integer> {
}
