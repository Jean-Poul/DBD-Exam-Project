package db.services;

import db.dto.CourierDTO;
import db.dto.OrderDTO;
import db.entity.Courier;
import db.entity.Customer;
import db.entity.Order;
import db.interfaces.OrderService;
import db.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public OrderDTO getOrderByCustomerId(int id) throws Exception {
        // ResponseStatusException e = new ResponseStatusException(HttpStatus.GONE, String.format("Project with id %s does not exist in DB", projectId));
        // Exception ex = new ClassNotFoundException();
        Customer order = orderRepo.getOrderByCustomerId(id);
        System.out.println("Order id: " + order.getOrders().get(0).getId());
        System.out.println("Customer name: " + order.getFirstName());
        System.out.println("Customer orders: " + order.getOrders().get(0).getItems());
        return new OrderDTO(order);
    }

    @Override
    public CourierDTO getCourierOrderById(int id) {
        Courier order = orderRepo.getOrderByCourierId(id);
        System.out.println("Courier id: " + order.getId());
        System.out.println("Courier name: " + order.getFirstName());
        System.out.println("Customer orders: " + order.getOrders());
        return new CourierDTO(order);
    }

    @Override
    public ResponseEntity<Order> postCustomerOrder(Order order) {
        try {
           Order newOrder = orderRepo.save(new Order(order.getFirstName(), order.getLastName()));
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
