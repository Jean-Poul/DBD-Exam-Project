package db.repository;

import db.entity.Address;
import db.entity.Zipcode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZipcodeRepo extends CrudRepository<Zipcode,Integer> {

    @Query("SELECT z from Zipcode z where z.zipcode= ?1")
    List<Zipcode> getForAddress(int zipcode);
}
