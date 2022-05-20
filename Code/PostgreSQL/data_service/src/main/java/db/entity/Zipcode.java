package db.entity;

import javax.persistence.*;


@Entity
@Table(name = "zipcodes")
public class Zipcode {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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

    public Zipcode(int zipcode, String region, String commune, String city) {
        this.zipcode = zipcode;
        this.region = region;
        this.commune = commune;
        this.city = city;
    }

}
