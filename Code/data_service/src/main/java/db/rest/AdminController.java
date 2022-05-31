package db.rest;

import db.repository.OrderRepo;
import db.repository.RestaurantRepo;
import db.services.OrderPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    OrderPopulator populator;

    @GetMapping("/orders/populate")
    public String getById(@RequestParam("quantity") int quantity) {

        return "Total amount of orders in database : "+ populator.populateOrders(quantity);
    }
}
