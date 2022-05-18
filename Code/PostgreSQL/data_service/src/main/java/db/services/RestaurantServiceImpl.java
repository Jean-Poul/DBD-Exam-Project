package db.services;

import db.dto.RestaurantDTO;
import db.dto.RestaurantsDTO;
import db.entity.Restaurant;
import db.interfaces.RestaurantService;
import db.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    @Override
    public RestaurantDTO getRestaurantById(int id) throws Exception {
           // ResponseStatusException e = new ResponseStatusException(HttpStatus.GONE, String.format("Project with id %s does not exist in DB", projectId));
        Exception ex = new ClassNotFoundException();
        Restaurant restaurant = restaurantRepo.findById(id).orElseThrow(() -> ex);
        System.out.println("Restaurant " + restaurant.getMenu().size());
        return new RestaurantDTO();
    }

    @Override
    public RestaurantsDTO getAllRestaurants(Collection<Integer> ids) {

        return null;
    }

}
