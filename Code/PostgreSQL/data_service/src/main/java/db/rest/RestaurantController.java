package db.rest;


import db.dto.RestaurantDTO;

import db.entity.Restaurant;
import db.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;

    @GetMapping("test")
    public String getEndpoint() {
        return "Hello World!";
    }

    @GetMapping("restaurantbyid")
    public RestaurantDTO get(@RequestParam("id") int id) throws Exception {
        return restaurantServiceImpl.getRestaurantById(id);
    }

    @GetMapping("allrestaurantsbyid")
    public Set<RestaurantDTO> getAll(@RequestBody List<Integer> list) throws Exception {
        return restaurantServiceImpl.getAllRestaurantsById(list);
    }
    @GetMapping("idzipcode")
    public List<Integer> getRestaurantsIdsByZipcode(@RequestParam("zipcode") int zipcode) {
        return restaurantServiceImpl.getRestaurantIdListByZipcode(zipcode);
    }
}
