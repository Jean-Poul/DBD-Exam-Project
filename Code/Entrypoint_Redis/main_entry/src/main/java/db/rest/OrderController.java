package db.rest;

import db.entities.Order;
import db.entities.OrderRequest;
import db.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("/customer")
    public List<Order> getForCustomer(@RequestParam("id") int id) {
        return orderService.getOrdersForCustomer(id);
    }

    @GetMapping("/courier")
    public List<Order> getForCourier(@RequestParam("id") int id) {
        return orderService.getOrdersForCourier(id);
    }

    @GetMapping("/restaurant")
    public List<Order> getRestaurant(@RequestParam("id") int id) {
        return orderService.getOrdersForRestaurant(id);
    }

    @PostMapping
    public Order saveNewOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.saveNewOrder(orderRequest);
    }

    @PutMapping
    public Order deliverOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.deliverOrder(orderRequest);
    }
}