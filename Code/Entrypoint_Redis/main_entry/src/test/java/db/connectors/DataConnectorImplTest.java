package db.connectors;

import db.entities.Restaurant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class DataConnectorImplTest {

    RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:9080/";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRestaurantById() throws URISyntaxException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        URI uri = new URI(baseUrl + "restaurant/restaurantbyid?id=" + 9);
//        ResponseEntity<Restaurant> result = restTemplate.getForEntity(uri, Restaurant.class);
//        System.out.println(result.getBody().toString());

    }

    @Test
    void getRestaurantListById() {
    }
}