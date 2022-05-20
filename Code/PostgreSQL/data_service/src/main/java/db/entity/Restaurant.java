package db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Integer userId;
    @Column(name = "restaurants_name")
    private String name;

    private Integer addressId;
    private String phone;
    @OneToMany(mappedBy = "restaurantId")
    private List<Item> menu = new ArrayList<>();
    @OneToMany(mappedBy = "restaurantId")
    private List<OpeningHours> openingHours = new ArrayList<>();

    public Restaurant() {
    }

    public void addItemToMenu(Item item) {
        this.menu.add(item);
        if (item.getRestaurantId() == null) {
            item.setRestaurantId(id);
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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Restaurant(Integer userId, String name, int addressId, String phone, List<Item> menu, List<OpeningHours> openingHours) {

        this.userId = userId;
        this.name = name;
        this.addressId = addressId;
        this.phone = phone;
        this.menu = menu;
        this.openingHours = openingHours;
    }
}
