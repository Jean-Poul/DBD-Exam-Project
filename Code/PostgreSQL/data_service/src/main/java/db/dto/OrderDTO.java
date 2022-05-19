package db.dto;

import db.entity.Customer;
import db.entity.Item;
import db.entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OrderDTO {

    private int order_id;
    private LocalDate order_date;
    private String email;
    private long address_id;
    private String phone;
    private String firstName;
    private String lastName;
    private List<Order> customer_order_list;
    private double total_price;

    public OrderDTO(Customer entity) {
        this.order_id = entity.getOrders().get(0).getId();
        this.order_date = entity.getOrders().get(0).getOrder_date();
        this.email = entity.getEmail();
        this.address_id = entity.getAddress_id();
        this.phone = entity.getPhone();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.customer_order_list = entity.getOrders();
        this.total_price = entity.getOrders().get(0).getTotal_price();
    }

    public int getOrder_id() {
        return order_id;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public String getEmail() {
        return email;
    }

    public long getAddress_id() {
        return address_id;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Order> getCustomer_order_list() {
        return customer_order_list;
    }

    public double getTotal_price() {
        return total_price;
    }
}
