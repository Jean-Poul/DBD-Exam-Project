package db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Orders")
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate order_date;

    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_items",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_id")
    @Column(name = "quantity")
    private Map<Item, Integer> items = new HashMap<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private Courier courier;

    private double total_price;

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Order() {
    }

    public Order(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addItem(Item item) {
        int quantity = 1;
        if (this.items.containsKey(item)) {
            quantity = this.items.get(item) + 1;

        }
        this.items.put(item, quantity);
    }

    public double getTotal_price() {
        return this.total_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Map<Item, Integer> getItems() {
        return this.items;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public void setTotal_price() {
        double sum = 0.0;
        for (Item i : this.items.keySet()
        ) {
            sum = sum + i.getPrice();
        }
        this.total_price = sum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
