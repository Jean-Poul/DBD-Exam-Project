package db.rest;

import db.dto.CourierDTO;
import db.dto.OrderDTO;
import db.dto.RestaurantDTO;
import db.entity.Courier;
import db.entity.Customer;
import db.entity.Order;
import db.services.OrderServiceImpl;
import db.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping("getorderbycustomer")
    public OrderDTO getOrder(@RequestParam("id") int id) throws Exception {
        System.out.println("order controller hit (customer)");
        return orderServiceImpl.getOrderByCustomerId(id);
    }

    @GetMapping("getorderbycourier")
    public CourierDTO getCourier(@RequestParam("id") int id) {
        System.out.println("order controller hit (courier)");
        return orderServiceImpl.getCourierOrderById(id);
    }

    @PostMapping(path = "/postorder", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        System.out.println("order controller hit (post order)");
        return orderServiceImpl.postCustomerOrder(order);
    }


}
