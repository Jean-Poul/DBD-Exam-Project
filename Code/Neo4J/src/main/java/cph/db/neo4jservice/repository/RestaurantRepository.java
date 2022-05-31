package cph.db.neo4jservice.repository;


import cph.db.neo4jservice.entities.RestaurantEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface RestaurantRepository extends ReactiveNeo4jRepository<RestaurantEntity, String> {
    @Query("MATCH (r:Restaurant)-[rel:LOCATION]->(a:Address)-[rr:LOCATED_IN]->(z:Zipcode{zipcode:$zipCode}) return r, a, z")
    Flux<RestaurantEntity> findRestaurantsByzipcode(String zipCode);

    @Query("MATCH (r:Restaurant)-[rel:LOCATION]->(a:Address)-[rr:LOCATED_IN]->(z:Zipcode{city_name:$cityName}) return r, a, z")
    Flux<RestaurantEntity> findRestaurantsByCityName(String cityName);

    @Query("MATCH (r:Restaurant)-[rel:DELIVERS]->(d:Delivery{delivery:$delivery}) return r")
    Flux<RestaurantEntity> findRestaurantsByDelivery(String delivery);

    @Query("MATCH (r:Restaurant)-[rel:HAS]->(d:FoodCategory{category:$foodCategory}) return r")
    Flux<RestaurantEntity> findRestaurantsByFoodCategory(String foodCategory);


    @Query("CALL gds.nodeSimilarity.stream('restaurantSimilarity')\n" +
            "YIELD node1, node2, similarity\n" +
            "WHERE gds.util.asNode(node1).pg_id = $id\n" +
            "RETURN gds.util.asNode(node2) AS restaurant\n" +
            "ORDER BY similarity DESCENDING, restaurant\n" +
            "LIMIT 5;")
    Flux<RestaurantEntity> findSimilarRestaurants(String id);
}

