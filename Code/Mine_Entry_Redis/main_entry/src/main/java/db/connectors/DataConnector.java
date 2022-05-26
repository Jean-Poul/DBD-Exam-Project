package db.connectors;

import db.entities.Restaurant;

import java.net.URISyntaxException;
import java.util.List;

public interface DataConnector {
    Restaurant getRestaurantById(int id) throws URISyntaxException;

    List<Restaurant> getAllRestaurantsById(List<Integer> ids);

    List<Restaurant> getAllRestaurants() throws URISyntaxException;


}
