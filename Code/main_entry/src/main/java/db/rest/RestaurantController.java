package db.rest;

import db.entities.Restaurant;
import db.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantServiceImpl restaurantService;

    @GetMapping
    public ResponseEntity<Restaurant> getRestaurantById(@RequestParam("id") int id) throws URISyntaxException {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Restaurant>> getAllRestaurantsById(@RequestParam("ids") Set<Integer> idList) throws URISyntaxException {
        return ResponseEntity.ok(restaurantService.getAllRestaurantsById(idList));
    }
}
