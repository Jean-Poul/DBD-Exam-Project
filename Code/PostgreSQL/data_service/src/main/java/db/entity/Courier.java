package db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "couriers")
public class Courier extends User {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)

    private String email;
    private String password;
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet();

    //todo set index on user id
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "courierId")
    private List<Order> orders = new ArrayList<>();

    public Courier() {
    }
//
//    public void deliverOrder(Order order) {
//        this.orders.add(order);
//        if (order.getCourierId() == null) {
//            order.setCourierId(id);
//        }
//    }
//
//    public Integer getId() {
//        return id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Courier(String email, String password, String phone, Set<Role> roles, Integer userId, String firstName, String lastName, List<Order> orders) {
        super(email, password, phone, roles);

        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }
}