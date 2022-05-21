package db.entity;

import org.hibernate.annotations.Fetch;
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
    private LocalDate orderDate;

    @ElementCollection
    @CollectionTable(name = "order_items",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_id")
    @Column(name = "quantity")

    private Map<Item, Integer> items = new HashMap<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private double totalPrice;

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}



//package db.entity;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.Map;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//  //  @Column(nullable = false)
//    private LocalDate orderDate;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "order_items",
//            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
//    @MapKeyColumn(name = "item_id")
//    @Column(name = "quantity")
//    private Map<Item, Integer> items = new HashMap<>();
//
//    @Column(nullable = false)
//    private Integer customerId;
//
//
//    private Integer courierId;
//
// //   @Column(nullable = false)
//    private Integer restaurantId;
//
////    @Column(nullable = false)
//    private double totalPrice;
//
//    public Order() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//
//    public LocalDate getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(LocalDate orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public Map<Item, Integer> getItems() {
//        return items;
//    }
//
//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public Integer getCourierId() {
//        return courierId;
//    }
//
//    public void setCourierId(int courierId) {
//        this.courierId = courierId;
//    }
//
//    public Integer getRestaurantId() {
//        return restaurantId;
//    }
//
//    public void setRestaurantId(int restaurantId) {
//        this.restaurantId = restaurantId;
//    }
//
//    public double getTotalPrice() {
//        setTotalPrice();
//        return totalPrice;
//    }
//
//
//    public void addItem(Item item) {
//        int quantity = 1;
//        if (this.items.containsKey(item)) {
//            quantity = this.items.get(item) + 1;
//        }
//        this.items.put(item, quantity);
//    }
//
//    public void setTotalPrice() {
//        double sum = 0.0;
//        for (Item i : this.items.keySet()
//        ) {
//            sum = sum + i.getPrice();
//        }
//        this.totalPrice = sum;
//    }
//
//    @Override
//    public String toString() {
//        String items = "[";
//        for (Item i : this.items.keySet()){
//            items += i.getId()+", ";
//
//        }
//        items += "]\n";
//        return "Order{" +
//                "id=" + id +
//                ", orderDate=" + orderDate +
//                ", \nitems=" + items +
//                ", customerId=" + customerId +
//                ", courierId=" + courierId +
//                ", restaurantId=" + restaurantId +
//                ", totalPrice=" + totalPrice +
//                '}';
//    }
//}
