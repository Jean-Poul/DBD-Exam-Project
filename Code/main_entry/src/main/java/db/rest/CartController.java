package db.rest;

import db.entities.Order;
import db.entities.OrderRequest;
import db.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("")
    public OrderRequest getCart(@RequestParam("customerid") int id) {
        return orderService.getCart(id);
    }

    @PutMapping("")
    public OrderRequest UpdateCart(@RequestBody OrderRequest orderRequest)  {
        return orderService.updateCart(orderRequest);
    }

    @DeleteMapping
    public void EmptyCart(@RequestBody OrderRequest orderRequest)  {
        orderService.emptyCart(orderRequest);
    }

}
