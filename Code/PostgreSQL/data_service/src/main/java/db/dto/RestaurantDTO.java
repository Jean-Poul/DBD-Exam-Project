package db.dto;

import db.entity.Item;
import db.entity.OpeningHours;
import db.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDTO {

    // TODO ALT INFO HER ELLER I EN DTO FRA ADDRESS ADDRESS DTO?
    // Hvad vil vi vise til en user og hvad vil vi gemme fra en user? (overvej)
    private String street;
    private String name;
    private String phone;
    //private String menu;

    private Restaurant restaurant;

    private Item item;
    private List<Item> listOfMenu = new ArrayList<>();

    private OpeningHours openingHours;
    private List<OpeningHours> listOfOpeningHours = new ArrayList<>();

    //private AdresDTO adres;

    public RestaurantDTO(Restaurant entity) {
        this.name = entity.getName();
        this.phone = entity.getPhone();
       // this.listOfMenu = entity.getMenu();
       // this.listOfOpeningHours = entity.getOpeningHours();
    }

    public String getStreet() {
        return street;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<Item> getListOfMenu() {
        return listOfMenu;
    }

    public List<OpeningHours> getListOfOpeningHours() {
        return listOfOpeningHours;
    }
}
