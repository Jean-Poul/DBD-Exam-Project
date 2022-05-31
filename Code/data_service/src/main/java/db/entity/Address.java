package db.entity;

import javax.persistence.*;
import java.io.Serializable;

//readonly
@Entity(name = "Address")
@Table(name = "addresses")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    @Column(name = "building_id")
    private String buildingIdentifier;
    @Column(name = "local_id")
    private String localIdentifier;

    private int zipcode;
    private double x;
    private double y;

    public Address() {
    }

    public Address(String street, String buildingIdentifier, String localIdentifier, int zipcode, double x, double y) {
        this.street = street;
        this.buildingIdentifier = buildingIdentifier;
        this.localIdentifier = localIdentifier;
        this.zipcode = zipcode;
        this.x = x;
        this.y = y;
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

    public int getZipcode() {
        return zipcode;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}