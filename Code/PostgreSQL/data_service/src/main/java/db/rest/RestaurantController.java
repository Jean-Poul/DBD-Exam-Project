package db.rest;


import db.repository.OrderRepo;
import db.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantRepo restRepo;

    @Autowired
    OrderRepo orderRepo;

    @GetMapping("")
    public String getById() {
        return "HELLLLLLLLLLLLO";
    }


}
