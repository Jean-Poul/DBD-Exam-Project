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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_items",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_id")
    @Column(name = "quantity")
    private Map<Item, Integer> items = new HashMap<>();

    private Integer customerId;

    private Integer courierId;

    private double totalPrice;

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public Order() {
    }

    public void addItem(Item item) {
        int quantity = 1;
        if (this.items.containsKey(item)) {
            quantity = this.items.get(item) + 1;
        }
        this.items.put(item, quantity);
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomer(Integer customer) {
        this.customerId = customer;
    }

    public int getId() {
        return id;
    }

    public Map<Item, Integer> getItems() {
        return this.items;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate order_date) {
        this.orderDate = order_date;
    }

    public void setTotalPrice() {
        double sum = 0.0;
        for (Item i : this.items.keySet()
        ) {
            sum = sum + i.getPrice();
        }
        this.totalPrice = sum;
    }

    public void setCustomerId(int customerId) {
    }
}
