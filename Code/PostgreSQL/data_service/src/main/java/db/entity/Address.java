package db.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "building_id")
    private String building_identifier;
    @Column(name = "local_id")
    private String local_identifier;
    @Column(name = "zipcode")
    private int zipcode;

    private double x;
    private double y;




    public Address() {
    }




}