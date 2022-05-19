package db.entity;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;
    @Column(columnDefinition="TEXT")
    private String description;
    private double price;
    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
