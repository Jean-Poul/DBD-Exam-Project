package db.dto;

import db.entity.Address;

public class AddressDTO {
    private String building;
    private String local;
    private String street;
    private int zipcode;

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
}
