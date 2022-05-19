package db.interfaces;

import db.entity.Customer;
import db.entity.Order;

import java.util.List;

public interface OrderService {

    public Customer getOrderByCustomerId(int id) throws Exception;

    public Order getCourierOrderById(int id);


}
