package db.repository;

import db.dto.CustomerDTO;
import db.entity.Customer;
import db.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    @Query("SELECT c.id FROM Customer c")
    List<Integer> getCustomersIds();

    @Query("SELECT c from Customer c")
    List<CustomerDTO> getAllCustomers();

}
