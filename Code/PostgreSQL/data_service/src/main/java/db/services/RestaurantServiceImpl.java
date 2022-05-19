package db.services;

import db.dto.RestaurantDTO;
import db.dto.RestaurantsDTO;
import db.entity.Restaurant;
import db.interfaces.RestaurantService;
import db.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    @Override
    public RestaurantDTO getRestaurantById(int id) throws Exception {
        // ResponseStatusException e = new ResponseStatusException(HttpStatus.GONE, String.format("Project with id %s does not exist in DB", projectId));
        Exception ex = new ClassNotFoundException();
          Restaurant restaurant = restaurantRepo.findById(id).orElseThrow(() -> ex);
        //List<Restaurant> restaurant = restaurantRepo.getRestaurantWithItems(id);
        System.out.println("Restaurant id: " + restaurant.getId());
        System.out.println("Restaurant name: " + restaurant.getName());
        System.out.println("Menu size: " + restaurant.getMenu().size());
        System.out.println("Opening hours: " + restaurant.getOpeningHours().size());
        RestaurantDTO responseDTO = new RestaurantDTO(restaurant);
        return responseDTO;
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants(Collection<Integer> ids) {
        List<RestaurantDTO> responseList = new ArrayList<>();
        restaurantRepo.findAllById(ids).forEach((restaurant) -> {
            responseList.add(new RestaurantDTO(restaurant));
        });
        return responseList;
    }

}
