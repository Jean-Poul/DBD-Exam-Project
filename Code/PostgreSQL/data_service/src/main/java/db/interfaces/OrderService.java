package db.interfaces;

import db.dto.OrderDTO;
import db.dto.OrderRequest;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrdersForCustomer(int id);

    List<OrderDTO> getOrdersForCourier(int id);

    List<OrderDTO> getOrdersForRestaurant(int id);

    OrderDTO saveNewOrder(OrderRequest orderReqest);

    OrderDTO deliverOrder(OrderRequest request);


}
