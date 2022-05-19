package db.interfaces;

import db.dto.RestaurantDTO;
import db.dto.RestaurantsDTO;
import db.entity.Restaurant;

import java.util.Collection;
import java.util.List;

public interface RestaurantService {

    public RestaurantDTO getRestaurantById(int id) throws Exception;
    //public RestaurantsDTO getAllRestaurants(List<Integer> ids);

    List<RestaurantDTO> getAllRestaurants(Collection<Integer> ids);


}
