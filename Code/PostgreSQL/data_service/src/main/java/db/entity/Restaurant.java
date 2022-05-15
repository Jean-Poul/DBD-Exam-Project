package db.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long address_id;
    private String opening_hours;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "restaurant")
    private Set<Item> menu;

    public Restaurant() {
    }

    public void addItemToMenu(Item item) {
        this.menu.add(item);
        if(item.getRestaurant() == null) {
            item.setRestaurant(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
