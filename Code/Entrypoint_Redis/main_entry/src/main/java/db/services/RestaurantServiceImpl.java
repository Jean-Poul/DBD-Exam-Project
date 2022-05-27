package db.services;

import db.connectors.DataConnectorImpl;
import db.entities.Restaurant;
import db.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.*;

@Service
@EnableCaching
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    DataConnectorImpl connector;
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    RedisTemplate redisTemplate;


    @Override
 //   @Cacheable(value = "Restaurant")

    public Restaurant getRestaurantById(int id) throws URISyntaxException {
        Restaurant restaurant;
        try {
            restaurant = restaurantRepo.findById(id).get();
        } catch (NoSuchElementException e) {
            restaurant = connector.getRestaurantById(id);
            System.out.println(restaurant.toString());
        }
        Restaurant r = restaurantRepo.save(restaurant);
        System.out.println(r.toString());

        return restaurant;
    }

    @Override
    @Cacheable(value = "Restaurant")
    public List<Restaurant> getAllRestaurantsById(Set<Integer> ids) throws URISyntaxException {
        List<Restaurant> list = new ArrayList(restaurantRepo.getAllRestaurantById(ids));

        Set<Integer> presentIds = new HashSet<>();
        for (Restaurant r : list) {
            presentIds.add(r.getId());
        }
        if (presentIds.equals(ids)) {
            restaurantRepo.saveAll(list);
            return list;
        } else {
            for (Integer i : presentIds) {
                ids.remove(i);
            }
            list.addAll(connector.getAllRestaurantsById(ids));
            restaurantRepo.saveAll(list);
        }
        return list;
    }
}
