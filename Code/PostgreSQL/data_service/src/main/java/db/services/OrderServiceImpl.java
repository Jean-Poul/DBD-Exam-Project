package db.services;

import db.dto.RestaurantDTO;
import db.entity.Customer;
import db.entity.Order;
import db.entity.Restaurant;
import db.interfaces.OrderService;
import db.repository.OrderRepo;
import db.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

// @Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public Customer getOrderByCustomerId(int id) throws Exception {
        // ResponseStatusException e = new ResponseStatusException(HttpStatus.GONE, String.format("Project with id %s does not exist in DB", projectId));
        Exception ex = new ClassNotFoundException();
        Customer order = orderRepo.getOrderByCustomerId(id);
        System.out.println("Order id: " + order.getId());
        System.out.println("Customer name: " + order.getFirstName());
        System.out.println("Customer orders: " + order.getOrders());

        return order;
    }

    @Override
    public Order getCourierOrderById(int id) {
        return null;
    }
}
