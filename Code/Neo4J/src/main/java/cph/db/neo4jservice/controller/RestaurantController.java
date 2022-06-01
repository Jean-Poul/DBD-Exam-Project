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

    @GetMapping("/populate_db")
    String similarPopulate() {
        Driver driver = GraphDatabase
                .driver("bolt://host.docker.internal:7687", AuthTokens.basic("neo4j", ""));

        Neo4jClient client = Neo4jClient.create(driver);
        try {
            ResultSummary restaurants = client
                    .query("LOAD CSV WITH HEADERS FROM 'file:///restaurants_202205222339.csv'\n" +
                            "AS restaurants\n" +
                            "MERGE (r:Restaurant{restaurant_name:(restaurants.restaurant_name), pg_id:(restaurants.id), user_id:(restaurants.user_id), address_id:(restaurants.address_id)})\n" +
                            "MERGE (d:Delivery{delivery:(restaurants.delivery)})\n" +
                            "CREATE (r)-[rel:DELIVERS]->(d);")
                    .in("neo4j").run();
            System.out.println(restaurants);
            ResultSummary addresses = client
                    .query("LOAD CSV WITH HEADERS FROM 'https://raw.githubusercontent.com/Jean-Poul/DBD-Exam-Project/developer/data/addresses_202205222339.csv'\n" +
                            "AS addresses\n" +
                            "MATCH (r:Restaurant{address_id:(addresses.id)})\n" +
                            "CALL {\n" +
                            "    WITH addresses, r\n" +
                            "    MERGE (a:Address{id:(addresses.id), building_id:(addresses.building_id), local_id:(addresses.local_id), street:(addresses.street), x:(addresses.x), y:(addresses.y), zipcode:(addresses.zipcode)})\n" +
                            "    CREATE (r)-[rel:LOCATION]->(a)\n" +
                            "}\n")
                    .in("neo4j").run();
            System.out.println(addresses);
            ResultSummary zipcodes = client
                    .query("LOAD CSV WITH HEADERS FROM 'https://raw.githubusercontent.com/Jean-Poul/DBD-Exam-Project/developer/data/zipcode_clean.csv'\n" +
                            "AS zipcodes\n" +
                            "MERGE (zip:Zipcode{zipcode:(zipcodes.postnummer), city_name:(zipcodes.by)});")
                    .in("neo4j").run();
            System.out.println(zipcodes);
            ResultSummary zipcodessec = client
                    .query("MATCH\n" +
                            "  (zip:Zipcode),\n" +
                            "  (add:Address)\n" +
                            "WHERE zip.zipcode = add.zipcode\n" +
                            "CREATE (add)-[r:LOCATED_IN]->(zip)")
                    .in("neo4j").run();
            System.out.println(zipcodessec);
            ResultSummary items = client
                    .query("LOAD CSV WITH HEADERS FROM 'https://raw.githubusercontent.com/Jean-Poul/DBD-Exam-Project/developer/data/items.csv'\n" +
                            "AS items\n" +
                            "MATCH (r:Restaurant{pg_id:(items.restaurant_id)})\n" +
                            "CALL {\n" +
                            "    WITH items, r\n" +
                            "    MERGE (it:FoodCategory{category:(items.category)})\n" +
                            "    MERGE (r)-[rel:HAS]->(it)\n" +
                            "}")
                    .in("neo4j").run();
            System.out.println(items);
        }catch(Exception e){
            System.out.println(e);
        }
        return "Database populated succesfully";
    }

    @GetMapping("/get-similar-restaurants")
    Flux<RestaurantEntity> similarRestaurants(@RequestParam String id) {
            Driver driver = GraphDatabase
                    .driver("bolt://host.docker.internal:7687", AuthTokens.basic("neo4j", ""));

            Neo4jClient client = Neo4jClient.create(driver);
            try {
                Collection<Map<String, Object>> runGDS = client
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