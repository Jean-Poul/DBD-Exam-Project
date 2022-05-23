package db.services;

import db.dto.RestaurantDTO;
import db.entity.Restaurant;
import db.interfaces.RestaurantService;
import db.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    @Override
    public RestaurantDTO getRestaurantById(int id) throws Exception {
        Restaurant restaurant = restaurantRepo.findByIdWithOpeningHoursAndMenu(id);
        return new RestaurantDTO(restaurant);
    }

    @Override
    public Set<RestaurantDTO> getAllRestaurantsById(List<Integer> ids) {
        Set<RestaurantDTO> restaurantDTOs = new HashSet<>();
        for (Restaurant r : restaurantRepo.findListByIdWithOpeningHoursAndMenu(ids)
        ) {
            restaurantDTOs.add(new RestaurantDTO(r));
        }
        return restaurantDTOs;
    }


}
