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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;
    //private Integer restaurantId;

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
    private Restaurant restaurants;

    public Restaurant getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurant restaurants) {
        this.restaurants = restaurants;
    }
}
