package db.entity;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Restaurant extends User {

    private static final long serialVersionUID = 1L;

    @Column(name = "restaurants_name")
    private String name;
   // @OneToMany(mappedBy = "restaurantId" ,fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    // @Fetch(FetchMode.JOIN)

  //  @JoinColumn(name = "restaurant_id")
    private Set<Item> menu = new HashSet<>();
    @OneToMany(mappedBy = "restaurantId")
    private Set<OpeningHours> openingHours = new HashSet<>();
    @OneToMany(mappedBy = "restaurantId")
    private Set<Order> orders = new HashSet<>();

    public Restaurant() {
    }

    public Restaurant(String email, String password, String phone, Integer addressId, Set<Role> roles, String name, Set<Item> menu, Set<OpeningHours> openingHours, Set<Order> orders) {
        super(email, password, phone, addressId, roles);
        this.name = name;
        this.menu = menu;
        this.openingHours = openingHours;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public Set<Item> getMenu() {
        return menu;
    }

    public Set<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        if (order.getRestaurantId() == null) {
            order.setRestaurantId(this.getEmail());
        }
    }

    @Override
    public String toString() {

        String ordersStr = "";
        for (Order o : orders) {
            ordersStr += o.toString();
        }
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                ", openingHours=" + openingHours +
                ", orders=" + orders +
                '}';
    }
}
