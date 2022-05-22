package db.repository;

import db.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
//
//
//    @Query("SELECT c.id FROM Customer c")
//    List<Integer> getCustomersIds();


}
