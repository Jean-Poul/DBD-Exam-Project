package db.interfaces;

import db.dto.CourierDTO;
import db.dto.OrderDTO;
import db.entity.Order;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    public OrderDTO getOrderByCustomerId(int id) throws Exception;

    public CourierDTO getCourierOrderById(int id);

    public ResponseEntity<Order> postCustomerOrder(Order order);

}
