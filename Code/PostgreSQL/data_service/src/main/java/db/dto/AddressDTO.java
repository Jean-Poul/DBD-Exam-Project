package db.dto;

public class AddressDTO {
    private String buildindId;
    private String localId;
    private String street;
    private int zipcode;

    public AddressDTO(String buildindId, String localId, String street, int zipcode) {
        this.buildindId = buildindId;
        this.localId = localId;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getBuildindId() {
        return buildindId;
    }

    public String getLocalId() {
        return localId;
    }

    public String getStreet() {
        return street;
    }

    public int getZipcode() {
        return zipcode;
    }
}
