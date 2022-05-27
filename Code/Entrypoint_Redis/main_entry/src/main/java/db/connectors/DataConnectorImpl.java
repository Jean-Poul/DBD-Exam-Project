package db.connectors;

import com.sun.xml.bind.v2.model.core.TypeRef;
import db.dto.RestaurantDTO;
import db.entities.Address;
import db.entities.Restaurant;
import db.exceptions.RestaurantNotFoundException;
import db.wrapperclass.RestaurantList;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final String DATA_SERVICE_URL = "http://localhost:9080/";
    private final String RESTAURANT_SERVICE_URL = "";
    private final String COURIER_SERVICE_URL = "";
    private final String LOGGING_SERVICE_URL = "";
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Restaurant getRestaurantById(int id) throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI(DATA_SERVICE_URL + "restaurant/restaurantbyid?id=" + id);
        ResponseEntity<Restaurant> result = restTemplate.getForEntity(uri, Restaurant.class);
        return result.getBody();
    }

    @Override
    public List<RestaurantDTO> getAllRestaurantsById(List<Integer> ids) throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI(DATA_SERVICE_URL + "restaurant/allrestaurantsbyid");
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
        URI uri = new URI(DATA_SERVICE_URL + "restaurant/idzipcode?zipcode=2860");
        // RestaurantList response = restTemplate.getForObject(uri, RestaurantList.class);
        ResponseEntity<Restaurant[]> response = restTemplate.getForEntity(uri, Restaurant[].class);
        System.out.println(response.getBody());
        if (response != null) {
            // return response.getRestaurants();
            return Arrays.asList(response.getBody());
        }
        throw new RestaurantNotFoundException("No restaurants has been found");
    }
}
