package db.dto;

import db.entity.Courier;
import db.entity.Item;

import java.util.Map;

public class CourierDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    Map<Item, Integer> customer_orders;

    public CourierDTO(Courier entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
        this.customer_orders = entity.getOrders().get(0).getItems();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Map<Item, Integer> getCustomer_orders() {
        return customer_orders;
    }
}
