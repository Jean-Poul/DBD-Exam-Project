package db.entity;

import javax.persistence.*;
import java.io.Serializable;

//readonly
@Entity
@Table(name = "addresses")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    @Column(name = "building_id")
    private String building_identifier;
    @Column(name = "local_id")
    private String local_identifier;
    private int zipcode;
    private double x;
    private double y;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding_identifier() {
        return building_identifier;
    }

    public String getLocal_identifier() {
        return local_identifier;
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