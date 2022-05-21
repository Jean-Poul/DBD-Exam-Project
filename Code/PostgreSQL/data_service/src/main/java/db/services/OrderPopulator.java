package db.services;

import com.google.gson.Gson;
import db.dto.OrderDTO;
import db.entity.Courier;
import db.entity.Customer;
import db.entity.Item;
import db.entity.Order;
import db.repository.OrderRepo;
import db.repository.RestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderPopulator {
    private final Gson GSON = new Gson();
    @Autowired
    private RestRepo repo;
    @Autowired
    private OrderRepo orderRepo;

    private LocalDate randomDate() {
        LocalDate startDate = LocalDate.of(2020, 1, 1); //start date
        long start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.now(); //end date
        long end = endDate.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return LocalDate.ofEpochDay(randomEpochDay);
    }

    public void populateOrders(int customer_quantity) {
        Random rand = new Random();
     //   System.out.println(11111111);
        List<Integer> rest_ids = repo.getRestaurantsIds();
        List<Integer> cust_ids = repo.getCustomersIds();
        List<Courier> couriers = repo.getCouriers();

        Set<Integer> restNoMenu = new HashSet<>();
        for (int i = 0; i < customer_quantity; i++) {
//            System.out.println(20000 + i);
            int randCustIndex = rand.nextInt(cust_ids.size());
            cust_ids.remove(randCustIndex);
            Customer randCustomer = repo.getCustomerById(randCustIndex);
            int ordersQuantity = rand.nextInt(100) + 1;

            for (int j = 0; j < ordersQuantity; j++) {

                //   System.out.println(30000+j);

                int randCourIndex = rand.nextInt(couriers.size());
                Courier courier = couriers.get(randCourIndex);
                Order order = new Order();

                List<Item> menu = new ArrayList<>();
                int menuSize = 0;
                while (menuSize == 0) {
                    //  System.out.println(40000);

                    int randRestIndx = rand.nextInt(rest_ids.size());
                    int restaurantId = rest_ids.get(randRestIndx);
                    menu = repo.getMenu(restaurantId);
                    menuSize = menu.size();
                    if (menuSize == 0) {
                        restNoMenu.add(restaurantId);
                    } else {
                        order.setRestaurant(repo.findById(restaurantId).get());
                    }
                }

                order.setOrderDate(randomDate());
                order.setCourier(courier);
                order.setCustomer(randCustomer);

                for (int k = 0; k < rand.nextInt(8) + 1; k++) {
                    //  System.out.println(50000+k);

                    order.addItem(menu.get(rand.nextInt(menu.size())));

                    if (rand.nextInt(8) == 7) {
                        order.addItem(menu.get(rand.nextInt(menu.size())));
                    }
                }
                order.setTotalPrice();
              //  System.out.println(order.toString());
                try {
                    Order saved = orderRepo.save(order);
                   // System.out.println("Saved order: id=" + saved.getId());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(orderRepo.count());
            System.out.println(orderRepo.findById(1).get().getCourier().getLastName());
            System.out.println(orderRepo.findById(1).get().getRestaurant().getMenu().size());
            System.out.println("Restaurants with no items: ");
            restNoMenu.forEach(integer -> System.out.print(integer + ", "));

        }

        Order extra = orderRepo.findById(1).get();
        extra.setTotalPrice();
        Order saved = orderRepo.save(extra);
                System.out.println("SAVED FROM EXTRA: "+saved.getTotalPrice());

    }
}
