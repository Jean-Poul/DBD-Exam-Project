package db.repository;

import db.entity.Courier;
import db.entity.Customer;
import db.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Integer> {
    @Query("SELECT i FROM Order c JOIN c.customer i WHERE c.id = ?1")
    Customer getOrderByCustomerId(int orderId);

    @Query("SELECT i FROM Order c JOIN c.courier i WHERE c.id = ?1")
    Courier getOrderByCourierId(int orderId);
}
