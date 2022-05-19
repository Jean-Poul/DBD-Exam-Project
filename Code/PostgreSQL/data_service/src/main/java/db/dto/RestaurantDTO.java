package db.dto;

import db.entity.Item;
import db.entity.OpeningHours;
import db.entity.Restaurant;
import java.util.Collection;

public class RestaurantDTO {

    // TODO MISSING ADDRESS AND THE NESTED RESTAURANT FROM RESPONSE

    private final String name;
    private final String phone;
    private final int restaurant_id;

    private final Collection<Item> listOfMenu;

    private final Collection<OpeningHours> listOfOpeningHours;

    //private Address addres;

    public RestaurantDTO(Restaurant entity) {
        this.restaurant_id = entity.getAddress_id();
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.listOfOpeningHours = entity.getOpeningHours();
        this.listOfMenu = entity.getMenu();
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Collection<Item> getListOfMenu() {
        return listOfMenu;
    }
    public Collection<OpeningHours> getListOfOpeningHours() {
        return listOfOpeningHours;
    }
}
