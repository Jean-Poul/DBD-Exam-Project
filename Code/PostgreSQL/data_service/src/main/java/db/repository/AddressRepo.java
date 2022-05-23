package db.repository;

import db.entity.Address;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository <Address, Integer> {
}
