package db.wrapperclass;

import com.fasterxml.jackson.annotation.JsonCreator;
import db.entities.Restaurant;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

@Data
@RedisHash("Restaurant")
public class RestaurantList {

    private List<Restaurant> restaurants;

    @JsonCreator
    public RestaurantList() {
        this.restaurants = new ArrayList<>();
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
