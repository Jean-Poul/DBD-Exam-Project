package db.connectors;

import db.entities.Order;
import db.entities.OrderRequest;
import db.entities.Restaurant;

import java.net.URISyntaxException;
import java.util.List;

public interface DataConnector {
    Restaurant getRestaurantById(int id) throws URISyntaxException;

    List<Restaurant> getRestaurantListById(List<Integer> ids);

    List<Restaurant> getAllRestaurants();

    Order postNewOrder(OrderRequest request) throws URISyntaxException;

    Order senOrderWithCourier(OrderRequest request);

    List<Order> getOrdersForCourier(int id);

    List<Order> getOrdersForCustomer(int id);

    List<Order> getOrdersForRestaurant(int id);

}
