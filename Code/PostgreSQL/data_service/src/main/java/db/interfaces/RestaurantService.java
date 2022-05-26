package db.interfaces;

import db.dto.RestaurantDTO;

import java.util.List;
import java.util.Set;

public interface RestaurantService {

    RestaurantDTO getRestaurantById(int id) throws Exception;
    Set<RestaurantDTO> getAllRestaurantsById(List<Integer> ids);
    List<Integer> getRestaurantIdListByZipcode(int zipcode);

}
