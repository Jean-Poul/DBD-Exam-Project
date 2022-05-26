package db.services;

import db.connectors.DataConnectorImpl;
import db.dto.RestaurantDTO;
import db.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;


public interface RestaurantService {

    Restaurant getRestaurantById(int id) throws URISyntaxException;

    List<RestaurantDTO> getAllRestaurantsById(List<Integer> ids) throws URISyntaxException;

    List<Restaurant> getAllRestaurants() throws URISyntaxException;

    Restaurant saveRestaurant(Restaurant restaurant);

}

