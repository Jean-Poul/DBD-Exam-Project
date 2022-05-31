package db.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "Cart", timeToLive = 30)
public class OrderRequest {
    private static final long serialVersionUID = -7792341923197594840L;
    @Id
    private int id;
    private int orderId;
    private int restaurantId;
    private int customerId;
    private int courierId;
    private Map<Integer, Integer> items = new HashMap();
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public void setItems(Map<Integer, Integer> items) {
        this.items = items;
    }
}