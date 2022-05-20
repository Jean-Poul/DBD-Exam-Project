package db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")

public class Customer {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)

    private String email;
    private String password;
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet();

    private Integer addressId;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "customerId")
    private List<Order> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(Integer addressId, String firstName, String lastName, List<Order> orders) {

        this.addressId = addressId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        if (order.getCustomerId() == null) {
            order.setCustomer(id);
        }
    }

    public int getId() {
        return id;
    }

    public Integer getAddressId() {
        return addressId;
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
}
