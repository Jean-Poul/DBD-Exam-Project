package db.repo;

import db.entities.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public class RestaurantRepo {

    @Repository
    public interface StudentRepository extends CrudRepository<Restaurant, String> {}


}
