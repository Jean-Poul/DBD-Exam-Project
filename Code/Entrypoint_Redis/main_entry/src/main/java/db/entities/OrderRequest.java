package db.entities;

import java.util.HashMap;
import java.util.Map;

public class OrderRequest {
    private int orderId;
    private int restaurantId;
    private int customerId;
    private int courierId;
    private Map<Integer, Integer> items = new HashMap();

    public OrderRequest() {
    }

    public OrderRequest(int orderId, int restaurantId, int customerId, int courierId, Map<Integer, Integer> items) {
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.courierId = courierId;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getCourierId() {
        return courierId;
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }
}