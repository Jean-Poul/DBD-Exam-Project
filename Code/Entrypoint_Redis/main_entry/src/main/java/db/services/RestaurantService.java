package db.services;

import db.entities.Restaurant;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;


public interface RestaurantService {

    Restaurant getRestaurantById(int id) throws URISyntaxException;
    List<Restaurant> getAllRestaurantsById(Set<Integer> ids) throws URISyntaxException;
}