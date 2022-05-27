package db.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "Restaurant", timeToLive = 10)

public class Restaurant implements Serializable {
    private static final long serialVersionUID = -7792341923197594840L;

    @Id
    private int id;
    private String name;
    private Set<Item> menu;
    private Set<OpeningHours> openingHours;

    @Override
    public String toString() {
        return "Restaurant{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", menu=" + menu +
                ", openingHours=" + openingHours +
                '}';
    }
}

