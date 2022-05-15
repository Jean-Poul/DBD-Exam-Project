package db.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

//readonly
@Table(name = "zipcodes")
public class Zipcode {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "zipcode")
    private int zipcode;
    private String region;
    private String commune;
    private String city;

    public Zipcode() {
    }

    public String getRegion() {
        return region;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getCommune() {
        return commune;
    }

    public String getCity() {
        return city;
    }
}
