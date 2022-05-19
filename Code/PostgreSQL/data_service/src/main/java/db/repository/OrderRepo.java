package db.repository;

import db.entity.Customer;
import db.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Integer> {
    //Query("SELECT i FROM Order o JOIN o.customer i WHERE o.id = ?1")
    @Query("SELECT i FROM Order c JOIN c.customer i WHERE c.id = ?1")
    Customer getOrderByCustomerId(int orderId);
}
