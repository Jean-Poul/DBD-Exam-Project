package db.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany()
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id")
    )
    private Set<Item> item_list;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date order_date;
    private Long picked_up_by; // Courier ID
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

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

    public void addItem(Item item) {
        this.item_list.add(item);
    }

    public double getTotal_price() {
        double sum = 0.0;
        for (Item i : this.item_list
        ) {
            sum = sum + i.getPrice();
        }
        return sum;
    }

    public void setTotal_price() {
        this.total_price = getTotal_price();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public Set<Item> getItem_list() {
        return item_list;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Long getPicked_up_by() {
        return picked_up_by;
    }
}
