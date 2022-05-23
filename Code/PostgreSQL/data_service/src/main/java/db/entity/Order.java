package db.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity(name = "Order")
@Table(name = "orders")
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    @ElementCollection(fetch = FetchType.EAGER)

    @CollectionTable(name = "order_items",
            joinColumns = {@JoinColumn(name = "order_id",
                    referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "item_id")
    @Column(name = "quantity")
    private Map<Item, Integer> items = new HashMap<>();
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "delivered_by")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {
    }

    public Order(Restaurant restaurant, Customer customer) {
        this.restaurant = restaurant;
        this.orderDate = LocalDate.now();
        this.customer = customer;
    }

    public void addItem(Item item) {
        int quantity = 1;
        if (this.items.containsKey(item)) {
            quantity = this.items.get(item) + 1;
        }
        this.items.put(item, quantity);
        setTotalPrice();
    }

    public void sendWithCourier(Courier courier) {
        this.courier = courier;
    }

    private void setTotalPrice() {
        double sum = 0.0;
        for (Item i : this.items.keySet()
        ) {
            for (int j = 0; j < items.get(i); j++) {
                sum += i.getPrice();
            }
        }
        this.totalPrice = sum;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Courier getCourier() {
        return courier;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

}
