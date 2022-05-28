package db.exam.mongologging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoLoggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoLoggingApplication.class, args);
        Connection.connectToMongo();
    }

}
