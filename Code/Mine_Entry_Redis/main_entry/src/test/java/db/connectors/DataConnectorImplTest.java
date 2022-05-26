package db.connectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

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