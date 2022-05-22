package db.repository;

import db.entity.Zipcode;
import org.springframework.data.repository.CrudRepository;

public interface ZipcodeRepo extends CrudRepository<Zipcode,Integer> {
}
