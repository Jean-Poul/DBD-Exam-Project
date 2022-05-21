package db.entity;

import javax.persistence.*;

@Entity
@Table(name = "items", indexes = {
        @Index(name = "id_index", columnList = "id")
})
public class Item {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String category;
    @Column(columnDefinition = "TEXT")
    private String description;
    private double price;

    public Item() {
    }

    public int getId() {
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


    @ManyToOne(optional = false)
    private Restaurant restaurant;

    public Restaurant getRestaurants() {
        return restaurant;
    }

    public void setRestaurants(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
