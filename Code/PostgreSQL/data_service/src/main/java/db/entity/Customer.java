package db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
public class Customer extends User {
    private static final long serialVersionUID = 1L;

    private Integer addressId;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "customerId")
    private List<Order> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(String email, String password, String phone, Integer addressId, Set<Role> roles, Set<Role> roles1, Integer addressId1, String firstName, String lastName, List<Order> orders) {
        super(email, password, phone, addressId, roles);
        this.addressId = addressId1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    @Override
    public Integer getAddressId() {
        return addressId;
    }

    @Override
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        if (order.getCustomerId() == null) {
            order.setCustomerId(this.getEmail());
        }
    }

}
