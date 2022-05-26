package db.connectors;

import com.sun.xml.bind.v2.model.core.TypeRef;
import db.dto.RestaurantDTO;
import db.entities.Order;
import db.entities.OrderRequest;
import db.entities.Restaurant;
import db.exceptions.RestaurantNotFoundException;
import db.wrapperclass.RestaurantList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class DataConnectorImpl implements DataConnector {


    private final String baseUrl = "http://localhost:9080/";
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Restaurant getRestaurantById(int id) throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI(baseUrl + "restaurant/restaurantbyid?id=" + id);
        ResponseEntity<Restaurant> result = restTemplate.getForEntity(uri, Restaurant.class);
        return result.getBody();
    }

    @Override
    public List<RestaurantDTO> getAllRestaurantsById(List<Integer> ids) throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI(baseUrl + "restaurant/allrestaurantsbyid");
        // RestaurantList response = restTemplate.getForObject(uri, RestaurantList.class);
        ResponseEntity<RestaurantDTO[]> response = restTemplate.getForEntity(uri, RestaurantDTO[].class);
        if (response != null) {
            // return response.getRestaurants();
            return Arrays.asList(Objects.requireNonNull(response.getBody()));
        }
        throw new RestaurantNotFoundException("No restaurants has been found");
    }


    @Override
    public List<Restaurant> getAllRestaurants() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI(baseUrl + "restaurant/idzipcode?zipcode=2860");
        // RestaurantList response = restTemplate.getForObject(uri, RestaurantList.class);
        ResponseEntity<Restaurant[]> response = restTemplate.getForEntity(uri, Restaurant[].class);
        System.out.println(response.getBody());
        if (response != null) {
            // return response.getRestaurants();
            return Arrays.asList(response.getBody());
        }
        throw new RestaurantNotFoundException("No restaurants has been found");
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
