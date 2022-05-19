package db.rest;


import db.dto.RestaurantDTO;
import db.dto.RestaurantsDTO;
import db.entity.Restaurant;
import db.services.OrderPopulator;
import db.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;

    // localhost:9081/restaurant/getrestaurant?id=9
    @GetMapping("getrestaurant")
    public RestaurantDTO get(@RequestParam("id") int id) throws Exception {
        return restaurantServiceImpl.getRestaurantById(id);
    }

    @GetMapping("getallrestaurant")
    public List<RestaurantDTO> get(@RequestBody List<Integer> list) {
        return restaurantServiceImpl.getAllRestaurants(list);
    }

  /*  @PostMapping
    public ProjectDTO uploadFileToCleardox(@RequestHeader("user") String userId,
                                           @RequestHeader("x_top_session_id") String itgSession,
                                           @RequestBody Foid foid) {
        return userUtils.uploadNewProject(userId, itgSession, foid);
    } */


}
