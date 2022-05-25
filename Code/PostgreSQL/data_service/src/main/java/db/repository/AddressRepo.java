package db.repository;

import db.entity.Address;
import db.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository <Address, Integer> {

    @Query("SELECT a FROM User a left Join fetch a.address m WHERE a.email = ?1")
    Address findAddressById(String name);

}
