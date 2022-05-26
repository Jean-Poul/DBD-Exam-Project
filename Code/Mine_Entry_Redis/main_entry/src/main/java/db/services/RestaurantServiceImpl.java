package db.services;

import db.connectors.DataConnectorImpl;
import db.entities.Restaurant;
import db.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    DataConnectorImpl connector;
    @Autowired
    RestaurantRepo restaurantRepo;


    @Override
    public Restaurant getRestaurantById(int id) {
        Restaurant restaurant;
        try {
            restaurant = restaurantRepo.findById(id).get();
        } catch (Exception e) {
            try {
                restaurant = connector.getRestaurantById(id);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        }
        return restaurant;
    }

    @Override
    @Cacheable(value = "Restaurant")
    public List<Restaurant> getAllRestaurantsById(List<Integer> ids) {
        //return restaurantRepo.getListOfRestaurantsById;
        return null;
    }

    @Override
    @Cacheable(value = "Restaurant")
    public List<Restaurant> getAllRestaurants() throws URISyntaxException {
        // data connector from here
        List<Restaurant> list = new ArrayList<>();
        for (Restaurant c : restaurantRepo.findAll()) {
            list.add(c);
        }
        //   List<Restaurant> list = restaurantRepo.findAll();
        if (list.isEmpty()) {
            list = connector.getAllRestaurants();
        }
        return list;
    }
}
