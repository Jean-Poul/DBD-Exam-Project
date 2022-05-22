package db.entity;

import javax.persistence.*;

@Entity(name="Item")
@Table(name = "items")
public class Item {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String category;
    @Column(columnDefinition="TEXT")
    private String description;
    private double price;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "restaurant_id")
 //  private Restaurant restaurant;


    public Item(String name, String category, String description, double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

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

//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }
}
