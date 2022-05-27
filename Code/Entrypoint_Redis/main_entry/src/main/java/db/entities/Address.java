package db.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String building;
    private String local;
    private String street;
    private int zipcode;

    private double x;
    private double y;

    public String getBuilding() {
        return building;
    }

    public String getLocal() {
        return local;
    }

    public String getStreet() {
        return street;
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
