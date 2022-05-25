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
@Node("Address")
public class AddressEntity {
    @Id
    private final String id;
    @Property("building_id")
    private String building_id;
    @Property("local_id")
    private String local_id;
    @Property("street")
    private String street;
    @Property("x")
    private String x;
    @Property("y")
    private String y;
    @Property("zipcode")
    private String zipcode;
    //@Relationship(type = "LOCATION", direction = INCOMING)
    //private Set<RestaurantEntity> restaurantEntities = new HashSet<>();
    @Relationship(type = "LOCATED_IN", direction = OUTGOING)
    private Set<ZipcodeEntity> zipcodeEntities = new HashSet<>();

    public AddressEntity(String id, String building_id, String local_id, String street, String x, String y, String zipcode) {
        this.id = id;
        this.building_id = building_id;
        this.local_id = local_id;
        this.street = street;
        this.x = x;
        this.y = y;
        this.zipcode = zipcode;
    }
}