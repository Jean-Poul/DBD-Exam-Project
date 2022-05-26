package db.connectors;

import db.dto.RestaurantDTO;
import db.entities.Restaurant;

import java.net.URISyntaxException;
import java.util.List;

public interface DataConnector {
    Restaurant getRestaurantById(int id) throws URISyntaxException;

    List<RestaurantDTO> getAllRestaurantsById(List<Integer> ids) throws URISyntaxException;

    List<Restaurant> getAllRestaurants() throws URISyntaxException;


}
