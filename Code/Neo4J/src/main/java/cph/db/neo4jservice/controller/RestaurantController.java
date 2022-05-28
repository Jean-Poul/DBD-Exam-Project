package cph.db.neo4jservice.controller;

import cph.db.neo4jservice.entities.RestaurantEntity;
import cph.db.neo4jservice.repository.RestaurantRepository;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.summary.ResultSummary;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.ReactiveNeo4jClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    /*@PutMapping
    Mono<MovieEntity> createOrUpdateMovie(@RequestBody MovieEntity newMovie) {
        return movieRepository.save(newMovie);
    }*/
    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<RestaurantEntity> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/by-zipcode")
    Flux<RestaurantEntity> byZipcode(@RequestParam String zipcode) {
        return restaurantRepository.findRestaurantsByzipcode(zipcode);
    }
    @GetMapping("/by-cityName")
    Flux<RestaurantEntity> byCityName(@RequestParam String cityName) {
        return restaurantRepository.findRestaurantsByCityName(cityName);
    }
    @GetMapping("/by-delivery")
    Flux<RestaurantEntity> byDelivery(@RequestParam String delivery) {
        return restaurantRepository.findRestaurantsByDelivery(delivery);
    }
    @GetMapping("/by-food")
    Flux<RestaurantEntity> byFoodType(@RequestParam String foodCategory) {
        return restaurantRepository.findRestaurantsByFoodCategory(foodCategory);
    }

    @GetMapping("/get-similar-restaurants")
    Flux<RestaurantEntity> similarRestaurants(@RequestParam String id) {
            Driver driver = GraphDatabase
                    .driver("bolt://localhost:7687", AuthTokens.basic("neo4j", ""));

            Neo4jClient client = Neo4jClient.create(driver);
            try {
                Collection<Map<String, Object>> allActors = client
                        .query("CALL gds.graph.project(\n" +
                                "    'restaurantSimilarity',\n" +
                                "    ['Restaurant', 'FoodCategory', 'Delivery', 'Address' ],\n" +
                                "    {\n" +
                                "        HAS: {\n" +
                                "            type: 'HAS',\n" +
                                "            properties: {\n" +
                                "                strength: {\n" +
                                "                    property: 'category',\n" +
                                "                    defaultValue: 0.2\n" +
                                "                }\n" +
                                "            }\n" +
                                "        },\n" +
                                "        LOCATION: {\n" +
                                "            type: 'LOCATION',\n" +
                                "            properties: {\n" +
                                "                strength: {\n" +
                                "                    property: 'zipcode',\n" +
                                "                    defaultValue: 1.0\n" +
                                "                }\n" +
                                "            }\n" +
                                "        },\n" +
                                "        DELIVERS: {\n" +
                                "            type: 'DELIVERS',\n" +
                                "            properties: {\n" +
                                "                strength: {\n" +
                                "                    property: 'delivery',\n" +
                                "                    defaultValue: 1.0\n" +
                                "                }\n" +
                                "            }\n" +
                                "        }\n" +
                                "    }\n" +
                                ")\n" +
                                "YIELD nodeCount\n" +
                                "RETURN nodeCount")
                        .in("neo4j")
                        .fetch()
                        .all();
            }catch(Exception e){
                System.out.println(e);
            }
        return restaurantRepository.findSimilarRestaurants(id);
    }

}