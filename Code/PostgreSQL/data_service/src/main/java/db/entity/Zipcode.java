package db.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

//readonly
@Entity
@Table(name = "zipcodes")
public class Zipcode {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
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
