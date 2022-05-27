package db;

import db.connectors.DataConnectorImpl;
import db.entities.Restaurant;
import db.exceptions.RestaurantNotFoundException;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

//    @Test
//    void getRestaurantById() throws URISyntaxException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        URI uri = new URI(baseUrl + "restaurant/restaurantbyid?id=" + 9);
//        ResponseEntity<Restaurant> result = restTemplate.getForEntity(uri, Restaurant.class);
//        System.out.println(result.getBody().toString());
//
//    }

//    @Test
//    void getRestaurantListByIds() throws URISyntaxException {
//     Set<Integer> ids =  new HashSet();
//     ids.add(1);
//     ids.add(11);
//     ids.add(10);
//     ids.add(111);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        String requestParameter = "?ids=";
//        for (Integer i: ids ){
//            requestParameter+=i+",";
//        }
//        URI uri = new URI(baseUrl + "restaurant/list"+requestParameter);
//        // RestaurantList response = restTemplate.getForObject(uri, RestaurantList.class);
//        ResponseEntity<Restaurant[]> response = restTemplate.getForEntity(uri, Restaurant[].class);
//        if (response != null) {
//            // return response.getRestaurants();
//            Arrays.asList(Objects.requireNonNull(response.getBody())).forEach(r-> System.out.println(r.getName()+", items: "+ r.getMenu().size()));
//
//        }else {
//            throw new RestaurantNotFoundException("No restaurants has been found");
//
//        }
//    }

}