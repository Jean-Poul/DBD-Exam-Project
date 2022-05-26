package db.wrapperclass;

import db.entities.Restaurant;

import java.util.ArrayList;
import java.util.List;


public class RestaurantList {

    private List<Restaurant> restaurants;

    public RestaurantList() {
        this.restaurants = new ArrayList<>();
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
