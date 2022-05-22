package db.services;

import db.entity.*;
import db.repository.CustomerRepo;
import db.repository.OrderRepo;
import db.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderPopulator {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private CustomerRepo customerRepo;

    private LocalDate randomDate() {
        LocalDate startDate = LocalDate.of(2020, 1, 1); //start date
        long start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.now(); //end date
        long end = endDate.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return LocalDate.ofEpochDay(randomEpochDay);
    }

    public long populateOrders(int customer_quantity) {
        Random rand = new Random();

        List<Integer> rest_ids = restaurantRepo.getRestaurantsIds();
        List<Integer> cust_ids = customerRepo.getCustomersIds();
        List<Courier> couriers = restaurantRepo.getCouriers();
        List<Item> items = restaurantRepo.getMenu(1);

        Set<Integer> restNoMenu = new HashSet<>();
        for (int i = 0; i < customer_quantity; i++) {

            //Get random unique customer
            int randCustIndex = rand.nextInt(cust_ids.size());
            int customerId = cust_ids.get(randCustIndex);
            Customer customer = customerRepo.findById(customerId).get();
            cust_ids.remove(randCustIndex);

            //choose random quantity of orders to create for the customer
            int ordersQuantity = rand.nextInt(100) + 1;

            for (int j = 0; j < ordersQuantity; j++) {


                int randCourIndex = rand.nextInt(couriers.size());
                Courier courier = couriers.get(randCourIndex);
                Restaurant restaurant = null;

                List<Item> menu = new ArrayList<>();
                int menuSize = 0;
                while (menuSize == 0) {
                    int randRestIndx = rand.nextInt(rest_ids.size());
                    int restaurantId = rest_ids.get(randRestIndx);
                    restaurant = restaurantRepo.findById(restaurantId).get();
                    menu = restaurantRepo.getMenu(restaurantId);
                    menuSize = menu.size();
                    if (menuSize == 0) {
                        restNoMenu.add(restaurantId);
                    }
                }

                Order order = new Order(restaurant, customer);
                order.sendWithCourier(courier);

                for (int k = 0; k < rand.nextInt(8) + 1; k++) {
                    order.addItem(menu.get(rand.nextInt(menu.size())));

                    if (rand.nextInt(8) == 7) {
                        order.addItem(menu.get(rand.nextInt(menu.size())));
                    }
                }
                System.out.println("TOTAL PRICE: " + order.getTotalPrice());
                order.setOrderDate(randomDate());
                orderRepo.save(order);
            }
        }
        System.out.println("Restaurants with no items: ");
        restNoMenu.forEach(integer -> System.out.print(integer + ", "));
        return orderRepo.count();
    }
}
