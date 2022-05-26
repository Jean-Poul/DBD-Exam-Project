package db.services;

import db.connectors.DataConnectorImpl;
import db.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;


public interface RestaurantService {

    Restaurant getRestaurantById(int id);

    List<Restaurant> getAllRestaurantsById(List<Integer> ids);

    List<Restaurant> getAllRestaurants() throws URISyntaxException;

}

