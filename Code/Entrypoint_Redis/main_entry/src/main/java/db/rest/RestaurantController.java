package db.rest;

import db.entities.Restaurant;
import db.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<Restaurant> getRestaurantById(@PathParam("id") int id) throws URISyntaxException {
        System.out.println(id);
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> getAllRestaurantsById(@RequestBody Set<Integer> idList) throws URISyntaxException {
        return ResponseEntity.ok(restaurantService.getAllRestaurantsById(idList));
    }
}
