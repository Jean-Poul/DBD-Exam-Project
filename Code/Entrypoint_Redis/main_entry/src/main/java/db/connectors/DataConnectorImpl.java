package db.connectors;

import com.sun.xml.bind.v2.model.core.TypeRef;
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

@Component
public class DataConnectorImpl implements DataConnector {


    private final String baseUrl = "http://localhost:9080/";
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
    public List<Restaurant> getAllRestaurantsById(List<Integer> ids) {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurants() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI(baseUrl + "restaurant/idzipcode?zipcode=2860");
       // RestaurantList response = restTemplate.getForObject(uri, RestaurantList.class);
        ResponseEntity<Restaurant[]> response = restTemplate.getForEntity(uri, Restaurant[].class);
        if (response != null) {
           // return response.getRestaurants();
            return Arrays.asList(response.getBody());
        }
        throw new RestaurantNotFoundException("No restaurants has been found");
    }
}
