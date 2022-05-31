package db.dto;

import db.entity.Item;
import db.entity.OpeningHours;
import db.entity.Restaurant;
import db.entity.User;

import java.util.Set;

public class RestaurantDTO {

    private int Id;
    private String name;
    private Set<Item> menu;
    private Set<OpeningHours> openingHours;

    public RestaurantDTO(Restaurant entity) {
        this.Id = entity.getId();
        this.name = entity.getName();
        this.menu = entity.getMenu();
        this.openingHours = entity.getOpeningHours();
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Set<Item> getMenu() {
        return menu;
    }

    public Set<OpeningHours> getOpeningHours() {
        return openingHours;
    }

}
