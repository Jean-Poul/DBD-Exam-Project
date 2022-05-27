package db.connectors;

import db.entities.Order;
import db.entities.OrderRequest;
import db.entities.Restaurant;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

public interface DataConnector {
    Restaurant getRestaurantById(int id) throws URISyntaxException;

    List<Restaurant> getAllRestaurantsById(Set<Integer> ids) throws URISyntaxException;

    Order postNewOrder(OrderRequest request) throws URISyntaxException;

    Order sendOrderWithCourier(OrderRequest request);

    List<Order> getOrdersForCourier(int id);

    List<Order> getOrdersForCustomer(int id);

    List<Order> getOrdersForRestaurant(int id);


}