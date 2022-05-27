package db.repo;

import db.dto.RestaurantDTO;
import db.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {
    List<RestaurantDTO> getAllRestaurantById(List<Integer> list);

}
