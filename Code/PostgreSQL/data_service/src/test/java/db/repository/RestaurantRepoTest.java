//package db.repository;
//
//import db.entity.*;
//import org.checkerframework.checker.units.qual.A;
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//
//
//@TestPropertySource(locations = {"classpath:testapp.properties"})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class RestaurantRepoTest {
//    @Autowired
//    RestaurantRepo sut;
//    @Autowired
//    UserRepo userSut;
//
//    @BeforeEach
//    public void init() {
//
//        Zipcode zipcode = new Zipcode(2860, "TestRegion", "TectCommune", "Søborg");
//        Address address = new Address("Gildbrovej", "52", "st.th", zipcode, 12.47309358, 55.75520606);
//        Restaurant restaurant = new Restaurant();
//        Role role = new Role("Customer");
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//      //  User user = new User("Magda", "WAWRZAK", "phonr", roles);
//        //  User u =userSut.save(user);
//        //System.out.println(u.getEmail());
//        System.out.println("AAAAAAAA");
//        restaurant.addItemToMenu(new Item());
//      //  restaurant.setAddressId(1);
//        restaurant.setName("nsaædnm");
//        restaurant.setPhone("dfgdf");
//        Restaurant r = sut.save(restaurant);
//        System.out.println(r.getId());
//        r = sut.save(new Restaurant());
//        System.out.println(r.getId());
//        r = sut.save(new Restaurant());
//        System.out.println(r.getId());
//        r = sut.save(new Restaurant());
//        System.out.println(r.getId());
//        r = sut.save(new Restaurant());
//        System.out.println(r.getId());
//
//        System.out.println(sut.findById(2).get().getId());
//    }
//
//    @Test
//    void getRestaurantsIds() {
//        sut.save(new Restaurant());
//        sut.save(new Restaurant());
//        System.out.println(sut.count());
//        System.out.println(sut.count());
//        System.out.println("TEST TEST");
//    }
//
//    @Test
//    void getMenuItemIndexes() {
//    }
//
//    @Test
//    void getMenu() {
//    }
//
//    @Test
//    void getCouriersIds() {
//    }
//
//    @Test
//    void getCouriers() {
//    }
//
//    @Test
//    void getCustomerById() {
//    }
//}