package db.services;

import db.connectors.DataConnectorImpl;
import db.entities.Order;
import db.entities.OrderRequest;
import db.exceptions.EntityNotFoundException;
import db.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements Orderservice {
    @Autowired
    CartRepo repo;
    @Autowired
    DataConnectorImpl connector;

    public List<Order> getOrdersForCustomer(int id) throws URISyntaxException {
        return connector.getOrdersForCustomer(id);
    }

    public List<Order> getOrdersForCourier(int id) throws URISyntaxException {
        return connector.getOrdersForCourier(id);
    }

    public List<Order> getOrdersForRestaurant(int id) throws URISyntaxException {
        return connector.getOrdersForRestaurant(id);
    }

    public OrderRequest saveNewOrder(OrderRequest orderRequest) throws URISyntaxException {
        Order order = connector.postNewOrder(orderRequest);
        int courierId = connector.getNearestCourierId(order.getX(), order.getY());
        orderRequest.setCourierId(courierId);
        /*
        We do not have any implementation for informing Restaurant about new orders
         */
        return orderRequest;
    }

    public Order deliverOrder(OrderRequest orderRequest) throws URISyntaxException {
        return connector.sendOrderWithCourier(orderRequest);
    }

    public OrderRequest getCart(int id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Empty cart"));
    }

    @Override
    public OrderRequest updateCart(OrderRequest request) {
        OrderRequest present;
        try {
            present = repo.findById(request.getCustomerId()).get();
            present.setItems(request.getItems());
        } catch (NoSuchElementException e) {
            request.setId(request.getCustomerId());
            present = request;
        }
        repo.save(present);
        return present;
    }

    @Override
    public void emptyCart(OrderRequest request) {
        try {
            OrderRequest present = repo.findById(request.getCustomerId()).get();
            present.setItems(request.getItems());
            repo.delete(present);
        } catch (NoSuchElementException e) {
        }
    }
}
