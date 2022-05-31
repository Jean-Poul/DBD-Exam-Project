package db.exam.mongo.mongo_courier.populate;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {

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
}
