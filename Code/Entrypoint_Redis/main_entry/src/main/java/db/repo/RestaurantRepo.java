package db.repo;

import db.entities.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {

    List<Restaurant> getAllRestaurantById(Set<Integer> list);

}
