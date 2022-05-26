package db.repo;

import db.entities.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {}
