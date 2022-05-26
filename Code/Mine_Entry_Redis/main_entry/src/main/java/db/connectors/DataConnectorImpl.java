package db.connectors;

import db.entities.Order;
import db.entities.OrderRequest;
import db.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class DataConnectorImpl implements DataConnector {


    private final String baseUrl = "localhost:9080/";
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Restaurant getRestaurantById(int id) throws URISyntaxException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI(baseUrl + "restaurant/byId?id=" + id);
        ResponseEntity<Restaurant> result = restTemplate.getForEntity(uri, Restaurant.class);
        return result.getBody();
    }

    @Override
    public List<Restaurant> getRestaurantListById(List<Integer> ids) {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return null;
    }

    @Override
    public Order postNewOrder(OrderRequest orderRequest) throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI(baseUrl + "order");
        HttpEntity<OrderRequest> request =
                new HttpEntity<>(orderRequest, headers);
        Order result = restTemplate.postForObject(uri, request, Order.class);
        return result;
    }

    @Override
    public Order senOrderWithCourier(OrderRequest request) {
        return null;
    }

    @Override
    public List<Order> getOrdersForCourier(int id) {
        return null;
    }

    @Override
    public List<Order> getOrdersForCustomer(int id) {
        return null;
    }

    @Override
    public List<Order> getOrdersForRestaurant(int id) {
        return null;
    }
}
