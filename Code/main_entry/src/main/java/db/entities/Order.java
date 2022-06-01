package db.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private String date;
    private Map<String, Integer> items = new HashMap<>();
    private double totalPrice;
    private String restaurant;
    private String customer;
    private String courier;
    private double x;
    private double y;

    public void setId(int id) {
        this.id = id;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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

    public void setDate(String date) {
        this.date = date;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }
}
