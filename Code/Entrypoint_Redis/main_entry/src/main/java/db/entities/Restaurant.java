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
@Entity*/
@Data
@Entity
@RedisHash("Restaurant")
public class Restaurant implements Serializable {

    /*    private static final long serialVersionUID = 1L; */

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private int id;

    public Restaurant(int id) {
        this.id = id;
    }

    /*
    private String name;
    private Set<Item> menu;
    private Set<OpeningHours> openingHours;*/

/*
    public Restaurant() {
    }*/
/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    }*/
}

