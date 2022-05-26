package db.entities;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Set;

@RedisHash("Restaurant")
public class Restaurant implements Serializable {
    private Integer Id;
    private String name;
    private Set<Item> menu;
    private Set<OpeningHours> openingHours;

    public void addOpeningHours(OpeningHours openingHours){
        this.openingHours.add(openingHours);
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Set<Item> getMenu() {
        return menu;
    }

    public Set<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", menu=" + menu +
                ", openingHours=" + openingHours +
                '}';
    }
}

