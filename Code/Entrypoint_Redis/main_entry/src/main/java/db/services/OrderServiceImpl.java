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

@Service
public class OrderServiceImpl implements Orderservice {
    @Autowired
    CartRepo repo;
    @Autowired
    DataConnectorImpl connector;

    public List<Order> getOrdersForCustomer(int id) {
        return null;
    }

    public List<Order> getOrdersForCourier(int id) {
        return null;
    }

    public List<Order> getOrdersForRestaurant(int id) {
        return null;
    }

    public Order saveNewOrder(OrderRequest orderRequest) throws URISyntaxException {
        Order order = connector.postNewOrder(orderRequest);
        return null;
    }

    public Order deliverOrder(OrderRequest orderRequest) {
        return null;
    }

    public OrderRequest getCart(int id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Empty cart"));
    }

    @Override
    public OrderRequest updateCart(OrderRequest request) {
        OrderRequest present = repo.findById(request.getCustomerId()).orElseThrow(() -> new EntityNotFoundException("Empty cart"));
        present.setItems(request.getItems());
        repo.save(present);
        return present;
    }

    @Override
    public void emptyCart(OrderRequest request) {
        OrderRequest present = repo.findById(request.getCustomerId()).orElseThrow(() -> new EntityNotFoundException("Empty cart"));
        repo.delete(present);
    }
}
