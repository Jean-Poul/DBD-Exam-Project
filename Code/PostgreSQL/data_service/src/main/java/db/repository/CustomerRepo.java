package db.repository;

import db.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    @Query("SELECT c.id FROM Customer c")
    List<Integer> getCustomersIds();


}
