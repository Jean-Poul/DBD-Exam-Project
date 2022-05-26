package db.services;

import db.entities.Restaurant;

import java.util.List;

public interface RestaurantService {


    Restaurant getRestaurantById(int id);
    List<Restaurant> getRestaurantListByIds(List<Integer> ids);

}

