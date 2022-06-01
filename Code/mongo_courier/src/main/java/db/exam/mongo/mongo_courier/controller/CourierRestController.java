package db.exam.mongo.mongo_courier.controller;

import db.exam.mongo.mongo_courier.model.Courier;
import db.exam.mongo.mongo_courier.populate.Connection;
import db.exam.mongo.mongo_courier.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couriers")
public class CourierRestController {

    @Autowired
    private CourierRepository courierRepository;
    @Autowired
    Connection conn;

    public CourierRestController(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @GetMapping("/nearest")
    @ResponseStatus(HttpStatus.OK)
    public String closestCourier(@RequestBody Point location) {
        Distance dist = new Distance(100000,Metrics.KILOMETERS);
        List<Courier> c = courierRepository.findByLocationNear(location, dist);
        return c.get(0).getId();
    }

    @GetMapping("/populate")
    @ResponseStatus(HttpStatus.OK)
    public String pupulateCouriers() {
       return conn.populate_Couriers();
    }


    @GetMapping("/courierlocation/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeoJsonPoint findCourierById(@PathVariable("id") String id) {
        System.out.println(courierRepository.findCourierById(id));
        return courierRepository.findCourierById(id).getLocation();
    }

    @DeleteMapping("/deletecourier/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourier(@PathVariable String id) {
        courierRepository.deleteById(id);
    }

    @PostMapping("/savecourier")
    @ResponseStatus(HttpStatus.OK)
    public void saveCourier(@RequestBody Courier courier) {
        courierRepository.save(courier);
    }
}
