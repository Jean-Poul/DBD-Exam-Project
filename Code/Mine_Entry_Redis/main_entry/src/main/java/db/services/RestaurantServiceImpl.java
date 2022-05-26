package db.services;

import db.connectors.DataConnectorImpl;
import db.entities.Restaurant;
import db.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URISyntaxException;
import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    DataConnectorImpl connector;
    @Autowired
    RestaurantRepo restaurantRepo;


    @Override
    public Restaurant getRestaurantById(int id) {
        Restaurant restaurant;
        try{
             restaurant = restaurantRepo.findById(id).get();
        } catch (Exception e ){
            try {
                restaurant = connector.getRestaurantById(id);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    @Override
    public List<Restaurant> getRestaurantListByIds(List<Integer> ids) {
        return null;
    }
}
