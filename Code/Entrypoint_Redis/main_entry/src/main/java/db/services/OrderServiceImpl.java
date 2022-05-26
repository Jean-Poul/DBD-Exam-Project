package db.services;

import db.entities.Order;
import db.entities.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements Orderservice {
    public List<Order> getOrdersForCustomer(int id) {
        return null;
    }

    public List<Order> getOrdersForCourier(int id) {
        return null;
    }

    public List<Order> getOrdersForRestaurant(int id) {
        return null;
    }

    public Order saveNewOrder(OrderRequest orderRequest) {
        return null;
    }

    public Order deliverOrder(OrderRequest orderRequest) {
        return null;
    }
}
