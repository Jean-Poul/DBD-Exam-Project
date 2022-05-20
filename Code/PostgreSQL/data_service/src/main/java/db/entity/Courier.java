package db.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Courier extends User {
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "courierId")
    private List<Order> orders = new ArrayList<>();

    public Courier() {
    }

    public Courier(String email, String password, String phone, Integer addressId, Set<Role> roles, String firstName, String lastName, List<Order> orders) {
        super(email, password, phone, addressId, roles);
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order) {
        this.orders.add(order);
        if (order.getCourierId() == null) {
            order.setCourierId(this.getEmail());
        }
    }
}