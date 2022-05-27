package db.dto;

import db.entity.Address;

public class AddressDTO {
    private String building;
    private String local;
    private String street;
    private int zipcode;

    private double x;
    private double y;

    public AddressDTO(String building, String local, String street, int zipcode, double x, double y) {
        this.building = building;
        this.local = local;
        this.street = street;
        this.zipcode = zipcode;
        this.x = x;
        this.y = y;
    }

    public AddressDTO(Address address) {
        this.building = address.getBuildingIdentifier();
        this.local = address.getLocalIdentifier();
        this.street = address.getStreet();
        this.zipcode = address.getZipcode();
    }

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
