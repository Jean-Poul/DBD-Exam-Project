package db.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value ="Item", timeToLive = 5)
public class Item implements Serializable {
    private static final long serialVersionUID = -7792341923197594840L;
    @Id
    private Integer id;
    private String name;
    private String category;
    private String description;
    private double price;

    public Item(String name, String category, String description, double price) {

        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

}
