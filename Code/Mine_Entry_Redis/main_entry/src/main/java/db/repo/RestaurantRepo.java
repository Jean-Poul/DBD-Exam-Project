package db.repo;

import db.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {
     //   Restaurant getAllRestaurantByIds(List<Integer> list);

      //  Restaurant getAllResturants();
}
