package db.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street;
    @Column(name = "building_id")
    private String buildingIdentifier;
    @Column(name = "local_id")
    private String localIdentifier;
    @ManyToOne
    @JoinColumn(name = "zipcode")
    private Zipcode zipcode;
    private double x;
    private double y;

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingIdentifier() {
        return buildingIdentifier;
    }

    public String getLocalIdentifier() {
        return localIdentifier;
    }

    public Zipcode getZipcode() {
        return zipcode;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Address(String street, String buildingIdentifier, String localIdentifier, Zipcode zipcode, double x, double y) {
        this.street = street;
        this.buildingIdentifier = buildingIdentifier;
        this.localIdentifier = localIdentifier;
        this.zipcode = zipcode;
        this.x = x;
        this.y = y;
    }
}