package db.repository;

import db.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Integer> {

    @Query("SELECT o from Order o where o.customer.id = ?1")
    List<Order> getOrdersForCustomer(int id);

    @Query("SELECT o from Order o where o.courier.id = ?1")
    List<Order> getOrdersForCourier(int id);

    @Query("SELECT o from Order o where o.restaurant.id = ?1")
    List<Order> getOrdersForrestaurant(int id);

}
