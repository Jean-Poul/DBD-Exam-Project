package db.rest;

import db.dto.RestaurantDTO;
import db.entity.Customer;
import db.entity.Order;
import db.services.OrderServiceImpl;
import db.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping("getorderbycustomer")
    public Customer get(@RequestParam("id") int id) throws Exception {
        System.out.println("order controller hit");
        return orderServiceImpl.getOrderByCustomerId(id);
    }



}
