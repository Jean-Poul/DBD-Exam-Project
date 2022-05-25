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

    @Query("MATCH (r:Restaurant)-[rel:LOCATION]->(a:Address)-[rr:LOCATED_IN]->(z:Zipcode{city:$cityName}) return r, a, z")
    Flux<RestaurantEntity> findRestaurantsByCityName(String cityName);

    @Query("MATCH (n) DETACH DELETE n")
    void populateDatabase();
}

