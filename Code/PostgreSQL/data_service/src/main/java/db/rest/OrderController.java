package db.rest;

import db.dto.OrderDTO;
import db.requestmodel.OrderRequest;
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
    public List<OrderDTO> getForCustomer(@RequestParam("id") int id) {
        return orderService.getOrdersForCustomer(id);
    }
    @GetMapping("/courier")
    public List<OrderDTO> getForCourier(@RequestParam("id") int id) {
        return orderService.getOrdersForCourier(id);
    }
    @GetMapping("/restaurant")
    public List<OrderDTO> getRestaurant(@RequestParam("id") int id) {
        return orderService.getOrdersForRestaurant(id);
    }

    @PostMapping
    public OrderDTO saveNewOrder(@RequestBody OrderRequest orderRequest) {
        return  orderService.saveNewOrder(orderRequest);
    }

    @PutMapping
    public OrderDTO deliverOrder(@RequestBody OrderRequest orderRequest) {
        return  orderService.deliverOrder(orderRequest);
    }
}
