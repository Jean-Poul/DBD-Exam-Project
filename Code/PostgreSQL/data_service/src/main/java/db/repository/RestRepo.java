package db.repository;

import db.entity.Courier;
import db.entity.Customer;
import db.entity.Item;
import db.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

@Repository
public interface RestRepo extends CrudRepository<Restaurant, Integer> {
    @Query("SELECT i FROM Item i WHERE i.restaurant.id = ?1")
    List<Item> getMenu(int id);
//    @Query("SELECT i.id FROM Restaurant r JOIN r.menu i WHERE r.id = ?1")

    //not working
    @Query("SELECT items from Restaurant r JOIN r.menu items WHERE items.restaurant = r")
    List<Item> _getMenu(int id);

    @Query("SELECT r.id FROM Restaurant r")
    List<Integer> getRestaurantsIds();

    @Query("SELECT c.id from Courier c")
    List<Integer> getCouriersIds();

    @Query("SELECT c from Courier c")
    List<Courier> getCouriers();

    @Query("SELECT c FROM Customer c where c.id = ?1")
    Customer getCustomerById(int id);
    @Query("SELECT c.id from Customer c")
    List<Integer> getCustomersIds();


}
