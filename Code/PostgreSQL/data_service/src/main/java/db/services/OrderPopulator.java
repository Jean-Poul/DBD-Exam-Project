//package db.services;
//
//import db.dto.OrderDTO;
//import db.entity.Courier;
//import db.entity.Item;
//import db.entity.Order;
//import db.repository.CourierRepo;
//import db.repository.CustomerRepo;
//import db.repository.OrderRepo;
//import db.repository.RestaurantRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;
//
//@Service
//public class OrderPopulator {
//    @Autowired
//    private OrderRepo orderRepo;
//    @Autowired
//    private RestaurantRepo restaurantRepo;
//    @Autowired
//    private CustomerRepo customerRepo;
//
//    private LocalDate randomDate() {
//        LocalDate startDate = LocalDate.of(2020, 1, 1); //start date
//        long start = startDate.toEpochDay();
//        LocalDate endDate = LocalDate.now(); //end date
//        long end = endDate.toEpochDay();
//        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
//        return LocalDate.ofEpochDay(randomEpochDay);
//    }
//
//    public List<OrderDTO> populateOrders(int customer_quantity) {
//        Random rand = new Random();
//
//        List<Integer> rest_ids = restaurantRepo.getRestaurantsIds();
//        List<Integer> cust_ids = customerRepo.getCustomersIds();
//        List<Courier> couriers = restaurantRepo.getCouriers();
//        List<Item> items = restaurantRepo.getMenu(1);
//
//        Set<Integer> restNoMenu = new HashSet<>();
//        for (int i = 0; i < customer_quantity; i++) {
//
//            int randCustIndex = rand.nextInt(cust_ids.size());
//            int customerId = cust_ids.get(randCustIndex);
//            cust_ids.remove(randCustIndex);
//            int ordersQuantity = rand.nextInt(100) + 1;
//
//            for (int j = 0; j < ordersQuantity; j++) {
//
//
//                int randCourIndex = rand.nextInt(couriers.size());
//                Courier courier = couriers.get(randCourIndex);
//
//                List<Item> menu = new ArrayList<>();
//                int menuSize = 0;
//                while (menuSize == 0) {
//                    int randRestIndx = rand.nextInt(rest_ids.size());
//                    int restaurantId = rest_ids.get(randRestIndx);
//                    menu = restaurantRepo.getMenu(restaurantId);
//                    menuSize = menu.size();
//                    if (menuSize == 0) {
//                        restNoMenu.add(restaurantId);
//                    }
//                }
//
//                Order order = new Order();
//                order.setOrder_date(randomDate());
//                order.setCourier(courier);
//                order.setCustomer(restaurantRepo.getCustomerById(customerId));
//                for (int k = 0; k < rand.nextInt(8) + 1; k++) {
//                    order.addItem(menu.get(rand.nextInt(menu.size())));
//
//                    if (rand.nextInt(8) == 7) {
//                        order.addItem(menu.get(rand.nextInt(menu.size())));
//                    }
//                }
//                order.setTotal_price();
//                orderRepo.save(order);
//            }
//        }
//        System.out.println("Restaurants with no items: ");
//        restNoMenu.forEach(integer -> System.out.print(integer + ", "));
//        List<OrderDTO> dtos = new ArrayList<>();
//        return dtos;
//    }
//}
