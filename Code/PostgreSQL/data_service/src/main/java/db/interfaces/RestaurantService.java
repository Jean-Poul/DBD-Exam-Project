package db.interfaces;

import db.dto.RestaurantDTO;
import db.dto.RestaurantsDTO;

import java.util.Collection;

public interface RestaurantService {

    public RestaurantDTO getRestaurantById(int id) throws Exception;
    public RestaurantsDTO getAllRestaurants(Collection<Integer> ids);

}
