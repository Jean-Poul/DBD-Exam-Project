package db.connectors;

import db.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class DataConnectorImpl implements DataConnector {


    private final String baseUrl = "localhost:9080/";
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Restaurant getRestaurantById(int id) throws URISyntaxException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI(baseUrl + "restaurant/get/restaurant/byId?id=" + id);
        ResponseEntity<Restaurant> result = restTemplate.getForEntity(uri, Restaurant.class);


        return result.getBody();
    }

    @Override
    public List<Restaurant> getRestaurantListById(List<Integer> ids) {
        return null;
    }
}