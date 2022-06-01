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
@Node("Zipcode")
public class ZipcodeEntity {
    @Id
    private final String city;
    @Property("zipcode")
    private String zipcode;
    //@Relationship(type = "LOCATION", direction = INCOMING)
    //private Set<AddressEntity> addressEntities = new HashSet<>();

    public ZipcodeEntity(String city, String zipcode) {
        this.city = city;
        this.zipcode = zipcode;
    }
}