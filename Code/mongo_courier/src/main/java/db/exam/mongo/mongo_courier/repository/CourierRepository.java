package db.exam.mongo.mongo_courier.repository;

import db.exam.mongo.mongo_courier.model.Courier;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourierRepository extends MongoRepository<Courier, String> {

    Courier findCourierById(String id);

    // { 'location' : { '$near' : [point.x, point.y], '$maxDistance' : distance}}
    List<Courier> findByLocationNear(Point location, Distance distance);
}
