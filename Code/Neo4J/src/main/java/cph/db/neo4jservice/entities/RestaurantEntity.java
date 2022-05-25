package cph.db.neo4jservice.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;
import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Data
@Node("Restaurant")
public class RestaurantEntity {
    @Id
    private final String pg_id;
    @Property("restaurant_name")
    private String restaurant_name;
    @Property("user_id")
    private String user_id;
    @Relationship(type = "LOCATION", direction = OUTGOING)
    private Set<AddressEntity> addresses = new HashSet<>();


    public RestaurantEntity(String pg_id, String restaurant_name, String user_id) {
        this.pg_id = pg_id;
        this.restaurant_name = restaurant_name;
        this.user_id = user_id;
    }

}