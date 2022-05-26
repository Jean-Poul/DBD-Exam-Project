package db.services;

import db.connectors.DataConnectorImpl;
import db.dto.RestaurantDTO;
import db.entities.Restaurant;
import db.exceptions.RestaurantNotFoundException;
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
    @Cacheable(value = "Restaurant::SimplyKey []", key = "#rKey", condition = "#rKey!=null")
    public Restaurant getRestaurantById(int id) throws URISyntaxException {
       /* Restaurant restaurant;
        try {
            Restaurant restaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant was not found"));
        } catch (Exception e) {
            try {
                restaurant = connector.getRestaurantById(id);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        }
        return restaurant;*/
        Restaurant restaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant was not found"));
        if (restaurant == null) {
            restaurant = connector.getRestaurantById(id);
            restaurantRepo.save(restaurant);
        }
        return restaurant;
    }

    @Override
    @Cacheable(value = "Restaurant")
    public List<RestaurantDTO> getAllRestaurantsById(List<Integer> ids) throws URISyntaxException {
        List<RestaurantDTO> list = new ArrayList<>(restaurantRepo.getAllRestaurantById(ids));
       /* for (Restaurant c : restaurantRepo.getAllRestaurantById(ids)) {
            list.add(c);
        }*/
        if (list.isEmpty()) {
            list = connector.getAllRestaurantsById(ids);
        }
        return list;
    }

    @Override
    @Cacheable(value = "Restaurant")
    public List<Restaurant> getAllRestaurants() throws URISyntaxException {
        // data connector from here
        List<Restaurant> list = new ArrayList<>();
        for (Restaurant r : restaurantRepo.findAll()) {
            list.add(r);
        }
        //   List<Restaurant> list = restaurantRepo.findAll();
        if (list.isEmpty()) {
            list = connector.getAllRestaurants();
            for (Restaurant r : connector.getAllRestaurants()) {
                list.add(r);
                restaurantRepo.save(r);
            }

        }
        return list;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }


}
