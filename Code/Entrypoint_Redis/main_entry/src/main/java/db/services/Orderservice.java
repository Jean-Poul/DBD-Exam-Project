package db.services;

import db.entities.Order;
import db.entities.OrderRequest;

import java.util.List;

public interface Orderservice {

    List<Order> getOrdersForCustomer(int id) ;

    List<Order> getOrdersForCourier(int id);

    public List<Order> getOrdersForRestaurant(int id);

    public Order saveNewOrder(OrderRequest orderRequest);

    Order deliverOrder(OrderRequest orderRequest);

    OrderRequest getCart(int id);
    OrderRequest updateCart(OrderRequest request);
    void emptyCart(OrderRequest orderRequest);

}
