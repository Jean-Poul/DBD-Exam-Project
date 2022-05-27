package db;

import db.entities.Item;
import db.entities.OpeningHours;
import db.entities.Restaurant;
import db.repo.RestaurantRepo;
import org.assertj.core.internal.Iterators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    RestaurantRepo repo;

    @BeforeEach
    void setup() {
        Item item = new Item("Boler i Karry", "middag", "Svinekøds boller", 59.0);
        Set<Item> menu = new HashSet<>();
        menu.add(item);

        Set<OpeningHours> openingHours = new HashSet();
        openingHours.add(new OpeningHours("Monday", "10:00", "22:00"));
        openingHours.add(new OpeningHours("Tuesday", "10:00", "22:00"));
        Restaurant restaurant = new Restaurant(1, "Pizza Mama Mia", menu, openingHours);

        repo.save(restaurant);
    }

    @AfterEach
    void cleanup() {
        repo.deleteAll();
    }

    @Test
    void GetRestaurantByIdTest() {
        assertEquals("Pizza Mama Mia", repo.findById(1).get().getName());
    }

    @Test
    void saveAllTest() {
        Set<OpeningHours> openingHours = new HashSet();
        openingHours.add(new OpeningHours("Monday", "10:00", "22:00"));
        openingHours.add(new OpeningHours("Tuesday", "10:00", "22:00"));
        Item item = new Item("Boler i Karry", "middag", "Svinekøds boller", 59.0);
        Set<Item> menu = new HashSet<>();
        menu.add(item);
        Restaurant restaurant1 = new Restaurant(2, "Pizza Mama", menu, openingHours);
        Restaurant restaurant2 = new Restaurant(3, "Mama Mia", menu, openingHours);
        Restaurant restaurant3 = new Restaurant(4, "Pizza Mia", menu, openingHours);
        Set<Restaurant> all = new HashSet<>();
        all.add(restaurant1);
        all.add(restaurant2);
        all.add(restaurant3);
        repo.saveAll(all);
        assertEquals(4l, repo.count());
    }

    @Test
    void findByIds() {
        Set<OpeningHours> openingHours = new HashSet();
        openingHours.add(new OpeningHours("Monday", "10:00", "22:00"));
        openingHours.add(new OpeningHours("Tuesday", "10:00", "22:00"));
        Item item = new Item("Boler i Karry", "middag", "Svinekøds boller", 59.0);
        Set<Item> menu = new HashSet<>();
        menu.add(item);
        Restaurant restaurant1 = new Restaurant(2, "Pizza Mama", menu, openingHours);
        Restaurant restaurant2 = new Restaurant(3, "Mama Mia", menu, openingHours);
        Restaurant restaurant3 = new Restaurant(4, "Pizza Mia", menu, openingHours);
        Set<Restaurant> all = new HashSet<>();
        all.add(restaurant1);
        all.add(restaurant2);
        all.add(restaurant3);
        repo.saveAll(all);
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(4);
        assertEquals(2,((List<Restaurant>) repo.findAllById(ids)).size());
    }

    @Test
    void givenNonExistingIdFIndByIds() {
        Set<OpeningHours> openingHours = new HashSet();
        openingHours.add(new OpeningHours("Monday", "10:00", "22:00"));
        openingHours.add(new OpeningHours("Tuesday", "10:00", "22:00"));
        Item item = new Item("Boler i Karry", "middag", "Svinekøds boller", 59.0);
        Set<Item> menu = new HashSet<>();
        menu.add(item);
        Restaurant restaurant1 = new Restaurant(2, "Pizza Mama", menu, openingHours);
        Restaurant restaurant2 = new Restaurant(3, "Mama Mia", menu, openingHours);
        Restaurant restaurant3 = new Restaurant(4, "Pizza Mia", menu, openingHours);
        Set<Restaurant> all = new HashSet<>();
        all.add(restaurant1);
        all.add(restaurant2);
        all.add(restaurant3);
        repo.saveAll(all);
        List<Integer> ids = new ArrayList<>();
        ids.add(6);
        ids.add(4);

        assertEquals(1,((List<Restaurant>) repo.findAllById(ids)).size());
    }


    @Test
    void getExpiredRestaurantTest() throws InterruptedException {
        Set<OpeningHours> openingHours = new HashSet();
        openingHours.add(new OpeningHours("Monday", "10:00", "22:00"));
        openingHours.add(new OpeningHours("Tuesday", "10:00", "22:00"));
        Item item = new Item("Boler i Karry", "middag", "Svinekøds boller", 59.0);
        Set<Item> menu = new HashSet<>();
        menu.add(item);
        Restaurant restaurant1 = new Restaurant(2, "Pizza Mama", menu, openingHours);
        repo.save(restaurant1);
        TimeUnit.SECONDS.sleep(6);
        assertThrows(NoSuchElementException.class, () -> {
            repo.findById(2).get();
        });
    }



}
