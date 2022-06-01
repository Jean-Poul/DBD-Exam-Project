package db.connectors;

import db.entities.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

public interface DataConnector {
    Restaurant getRestaurantById(int id) throws URISyntaxException;

    List<Restaurant> getAllRestaurantsById(Set<Integer> ids) throws URISyntaxException;

    Order postNewOrder(OrderRequest request) throws URISyntaxException;

    Order sendOrderWithCourier(OrderRequest request) throws URISyntaxException;

    List<Order> getOrdersForCourier(int id) throws URISyntaxException;

    List<Order> getOrdersForCustomer(int id) throws URISyntaxException;

    List<Order> getOrdersForRestaurant(int id) throws URISyntaxException;

    int getNearestCourierId(double x, double y) throws URISyntaxException;

    User login(UserRequest request) throws URISyntaxException;

    Customer createCustomer(CustomerRequest request) throws URISyntaxException;
}
