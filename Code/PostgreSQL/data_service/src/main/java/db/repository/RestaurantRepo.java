package db.repository;
//
//import db.entity.Restaurant;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {
//
//    @Query("SELECT r.id FROM Restaurant r")
//    List<Integer> getRestaurantsIds();
//
//    @Query("SELECT i.id FROM Restaurant r JOIN r.menu i WHERE r.id = ?1")
//    List<Integer> getMenuItemIndexes(int restaurantID);
//
////    @Query("SELECT i FROM Restaurant r JOIN r.menu i WHERE r.id = ?1")
////    List<Item> getMenu(int restaurantId);
////
////    @Query("SELECT c.id from Courier c")
////    List<Integer> getCouriersIds();
////
////    @Query("SELECT c from Courier c")
////    List<Courier> getCouriers();
////
////    @Query("SELECT c FROM Customer c where c.id = ?1")
////    Customer getCustomerById(int id);
//
//}
//

import db.entity.Courier;
import db.entity.Item;
import db.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {

    @Query("SELECT r FROM Restaurant r left JOIN FETCH r.openingHours oh left Join fetch r.menu m WHERE r.name = ?1")
    Restaurant findByNameWithOpeningHoursAndMenu(String name);

    @Query("SELECT r FROM Restaurant r left JOIN FETCH r.openingHours oh left Join fetch r.menu m WHERE r.id = ?1")
    Restaurant findByIdWithOpeningHoursAndMenu(int id);

    @Query("SELECT r FROM Restaurant r left Join fetch r.menu m WHERE r.name = ?1")
    Restaurant findByNameWithMenu(String name);

    @Query("SELECT r.id FROM Restaurant r")
    List<Integer> getRestaurantsIds();

    @Query("SELECT c from Courier c")
    List<Courier> getCouriers();

    @Query("SELECT i FROM Restaurant r JOIN r.menu i WHERE r.id = ?1")
    List<Item> getMenu(int restaurantId);

    @Query("SELECT r FROM Restaurant r left JOIN FETCH r.openingHours oh left Join fetch r.menu m WHERE r.id in ?1")
    Set<Restaurant> findListByIdWithOpeningHoursAndMenu(List<Integer> ids);

    @Query("SELECT r.id FROM Restaurant r WHERE r.user.address.zipcode = ?1")
    List<Integer> getRestaurantIdListByZipcode(int zipcode);
}
