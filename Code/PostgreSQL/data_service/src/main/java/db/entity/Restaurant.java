package db.entity;

import javax.persistence.*;
import java.util.ArrayList;
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
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private List<Item> menu = new ArrayList<>();
    @OneToMany(mappedBy = "restaurant")
    private List<OpeningHours> openingHours = new ArrayList<>();

    public Restaurant() {
    }

    public void addItemToMenu(Item item) {
        this.menu.add(item);
        if (item.getRestaurant() == null) {
            item.setRestaurant(this);
        }
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

    public List<Item> getMenu() {
        return menu;
    }

    public List<OpeningHours> getOpeningHours() {
        return openingHours;
    }

}
