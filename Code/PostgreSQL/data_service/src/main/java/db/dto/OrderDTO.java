package db.dto;

import db.entity.Item;
import db.entity.Order;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.HashMap;
import java.util.Map;

public class OrderDTO {

    private int id;
    private String date;
    private Map<String, Integer> items = new HashMap<>();
    private double totalPrice;
    private String restaurant;
    private String customer;
    private String courier;

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.date = entity.getOrderDate().toString();
        this.totalPrice = entity.getTotalPrice();
        if (entity.getRestaurant() != null) {
            this.restaurant = entity.getRestaurant().getName();
        }
        if (entity.getCustomer() != null) {
            this.customer = entity.getCustomer().getFirstName() + " " + entity.getCustomer().getLastName();
        }
        if (entity.getCourier() != null) {
            this.courier = entity.getCourier().getFirstName() + " " + entity.getCourier().getLastName();
        }
        transferItems(entity);
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCourier() {
        return courier;
    }

    private void transferItems(Order entity) {
        for (Item i : entity.getItems().keySet()) {
            this.items.put(i.getName(), entity.getItems().get(i));
        }


    }
}
