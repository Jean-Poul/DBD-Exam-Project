package db.services;

import db.dto.OrderDTO;
import db.requestmodel.OrderRequest;
import db.entity.*;
import db.interfaces.OrderService;
import db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CourierRepo courierRepo;


    @Override
    public List<OrderDTO> getOrdersForCustomer(int id) {
        List<OrderDTO> ordersDTO = new ArrayList<>();
        for (Order o : orderRepo.getOrdersForCustomer(id)
        ) {
            OrderDTO dto = new OrderDTO(o);
            ordersDTO.add(dto);
        }
        return ordersDTO;
    }

    @Override
    public List<OrderDTO> getOrdersForCourier(int id) {
        List<OrderDTO> ordersDTO = new ArrayList<>();
        for (Order o : orderRepo.getOrdersForCourier(id)
        ) {
            OrderDTO dto = new OrderDTO(o);
            ordersDTO.add(dto);
        }
        return ordersDTO;
    }

    @Override
    public List<OrderDTO> getOrdersForRestaurant(int id) {
        List<OrderDTO> ordersDTO = new ArrayList<>();
        for (Order o : orderRepo.getOrdersForrestaurant(id)
        ) {
            ordersDTO.add(new OrderDTO(o));
        }
        return ordersDTO;
    }

    @Override
    public OrderDTO saveNewOrder(OrderRequest request) {
        Restaurant restaurant = restaurantRepo.findById(request.getRestaurantId()).get();
        Customer customer = customerRepo.findById(request.getCustomerId()).get();
        Order newOrder = new Order(restaurant, customer);
        List<Item> itemList = new ArrayList<>();
        itemRepo.findAllById(request.getItems().keySet()).forEach(itemList::add);
        for (Integer i : request.getItems().keySet()) {
            Item item = itemRepo.findById(i).get();

            for (int q = 0; q < request.getItems().get(i); q++) {
                newOrder.addItem(item);
            }
        }
        newOrder = orderRepo.save(newOrder);
        return new OrderDTO(newOrder);
    }

    @Override
    public OrderDTO deliverOrder(OrderRequest request) {
        Order order = orderRepo.findById(request.getOrderId()).get();
        Courier courier = courierRepo.findById(request.getCourierId()).get();
        order.sendWithCourier(courier);
        order = orderRepo.save(order);
        return new OrderDTO(order);
    }
}
