package db.dto;

import db.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsDTO {
    List<RestaurantDTO> allRestaurants = new ArrayList();

    public RestaurantsDTO(List<Restaurant> restaurantListEntities) {
        restaurantListEntities.forEach((restaurant) -> {
            allRestaurants.add(new RestaurantDTO(restaurant));
        });
    }

    public List<RestaurantDTO> getAllRestaurants() {
        return allRestaurants;
    }
}
