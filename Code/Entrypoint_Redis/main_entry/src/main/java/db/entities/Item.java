package db.entities;


import org.springframework.data.redis.core.RedisHash;

@RedisHash("Item")
public class Item {

    private static final long serialVersionUID = 1L;

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

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

}
