package db.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Set;

/*
@Data
@AllArgsConstructor
@AllArgsConstructor
@Entity*/

@RedisHash("Restaurant")
public class Restaurant implements Serializable {

    private static final long serialVersionUID = -7792341923197594840L;
    /*
        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue*/
    @Id
    private int id;

    public Restaurant(int id) {
        this.id = id;
    }
    public Restaurant() {
    }


    private String name;
    private Set<Item> menu;
    private Set<OpeningHours> openingHours;


/*
    public Restaurant(int id, String name, Set<Item> menu, Set<OpeningHours> openingHours) {
        this.id = id;
        this.name = name;
        this.menu = menu;this.openingHours = openingHours;
    }
    */


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getMenu() {
        return menu;
    }

    public void setMenu(Set<Item> menu) {
        this.menu = menu;
    }

    public Set<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Set<OpeningHours> openingHours) {
        this.openingHours = openingHours;
    }

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

