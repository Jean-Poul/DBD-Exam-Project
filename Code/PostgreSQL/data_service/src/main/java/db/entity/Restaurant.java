package db.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Restaurant")
@Table(name = "restaurants")
public class Restaurant {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "restaurant_name",
            columnDefinition = "TEXT",
            nullable = false)
    private String name;

    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Set<Item> menu = new HashSet<>();


    @OneToMany(targetEntity = OpeningHours.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Set<OpeningHours> openingHours = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Restaurant() {
    }

    public Restaurant(String name, Set<Item> menu, Set<OpeningHours> openingHours) {
        this.name = name;
        this.menu = menu;
        this.openingHours = openingHours;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Item> getMenu() {
        return menu;
    }

    public Collection<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public User getUser() {
        return user;
    }
}
