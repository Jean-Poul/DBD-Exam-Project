package db.exam.mongo.mongo_courier;

import db.exam.mongo.mongo_courier.populate.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoCourierApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoCourierApplication.class, args);
        //Connection.connectToMongo();
    }

}
