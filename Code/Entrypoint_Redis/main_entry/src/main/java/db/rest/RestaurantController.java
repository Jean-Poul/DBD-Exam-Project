package db.rest;

import db.dto.RestaurantDTO;
import db.entities.Restaurant;
import db.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantServiceImpl restaurantService;

    @GetMapping("/restaurantbyid/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id) throws URISyntaxException {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @GetMapping("/allrestaurantsbyid")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurantsById(@RequestBody List<Integer> idList) throws URISyntaxException {
        return ResponseEntity.ok(restaurantService.getAllRestaurantsById(idList));
    }

    @GetMapping("/allrestaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() throws URISyntaxException {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PostMapping("/saverestaurant")
    public Restaurant saveInvoice(@RequestBody Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }
}
