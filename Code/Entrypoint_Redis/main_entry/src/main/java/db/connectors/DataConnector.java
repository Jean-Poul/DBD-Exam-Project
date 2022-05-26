package db.connectors;

import db.dto.RestaurantDTO;
import db.entities.Order;
import db.entities.OrderRequest;
import db.entities.Restaurant;

import java.net.URISyntaxException;
import java.util.List;

public interface DataConnector {
    Restaurant getRestaurantById(int id) throws URISyntaxException;

    List<RestaurantDTO> getAllRestaurantsById(List<Integer> ids) throws URISyntaxException;

    List<Restaurant> getAllRestaurants() throws URISyntaxException;

    Order postNewOrder(OrderRequest request) throws URISyntaxException;

    Order senOrderWithCourier(OrderRequest request);

    List<Order> getOrdersForCourier(int id);

    List<Order> getOrdersForCustomer(int id);

    List<Order> getOrdersForRestaurant(int id);


}
