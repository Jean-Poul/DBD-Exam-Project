package db.exam.mongo.mongo_courier.populate;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import db.exam.mongo.mongo_courier.model.Courier;
import db.exam.mongo.mongo_courier.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class Connection {
    @Autowired
    CourierRepository repo;

    public static void connectToMongo() {
        String uri = "mongodb://localhost:27017";
        MongoClient mongoClient = null;
        try {
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("DBExamMongo");
            //MongoCollection<Document> collection = database.createCollection("Logging");

            System.out.println("Connected to MongoDB!");
        } catch (MongoException e) {
            e.printStackTrace();
        } /*finally {
            if (mongoClient != null)
                mongoClient.close();
        }*/
    }

    public String populate_Couriers() {
        for (int i = 3; i < 503; i++) {
            double x = ThreadLocalRandom.current().nextDouble(54.72, 58.0);
            double y = ThreadLocalRandom.current().nextDouble(7.4, 12.875);
            GeoJsonPoint p = new GeoJsonPoint(x, y);
            Courier c = new Courier();
            c.setId("" + i);
            c.setLocation(p);
            repo.save(c);
        }


        return "Populated";

    }
}
