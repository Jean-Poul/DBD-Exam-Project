package cph.db.neo4jservice.controller;

import cph.db.neo4jservice.entities.MovieEntity;
import cph.db.neo4jservice.entities.RestaurantEntity;
import cph.db.neo4jservice.repository.MovieRepository;
import cph.db.neo4jservice.repository.RestaurantRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @GetMapping("/populate-database")
    void populateDB() {
       restaurantRepository.populateDatabase();
    }
    /*@DeleteMapping("/\{id\}")
    Mono<Void> delete(@PathVariable String id) {
        return movieRepository.deleteById(id);
    }*/
}