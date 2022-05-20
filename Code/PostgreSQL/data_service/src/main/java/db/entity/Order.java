package db.entity;

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
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate orderDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_items",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_id")
    @Column(name = "quantity")
    private Map<Item, Integer> items = new HashMap<>();

    @Column(nullable = false)
    private String customerId;

    //@Column(nullable = false)
    private String courierId;

    @Column(nullable = false)
    private String restaurantId;

    @Column(nullable = false)
    private double totalPrice;

    public Order() {
    }

    public Integer getId() {
        return id;
    }


    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getTotalPrice() {
        setTotalPrice();
        return totalPrice;
    }


    public void addItem(Item item) {
        int quantity = 1;
        if (this.items.containsKey(item)) {
            quantity = this.items.get(item) + 1;
        }
        this.items.put(item, quantity);
    }

    public void setTotalPrice() {
        double sum = 0.0;
        for (Item i : this.items.keySet()
        ) {
            sum = sum + i.getPrice();
        }
        this.totalPrice = sum;
    }

}
