package db.services;

import db.entities.Order;
import db.entities.OrderRequest;

import java.net.URISyntaxException;
import java.util.List;

public interface Orderservice {

    List<Order> getOrdersForCustomer(int id) throws URISyntaxException;

    List<Order> getOrdersForCourier(int id) throws URISyntaxException;

    public List<Order> getOrdersForRestaurant(int id) throws URISyntaxException;

    public OrderRequest saveNewOrder(OrderRequest orderRequest) throws URISyntaxException;

    Order deliverOrder(OrderRequest orderRequest) throws URISyntaxException;

    OrderRequest getCart(int id);
    OrderRequest updateCart(OrderRequest request);
    void emptyCart(OrderRequest orderRequest);

}
