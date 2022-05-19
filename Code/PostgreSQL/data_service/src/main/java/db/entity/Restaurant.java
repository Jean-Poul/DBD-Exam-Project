package db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "restaurants_name")
    private String name;
    private int address_id;
    // private String opening_hours;
    private String phone;
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private Collection<Item> menu = new ArrayList<>();
    @OneToMany(mappedBy = "restaurant")
    private Collection<OpeningHours> openingHours = new ArrayList<>();

    public Restaurant() {
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Item> getMenu() {
        return menu;
    }

    public Collection<OpeningHours> getOpeningHours() {
        return openingHours;
    }

}
