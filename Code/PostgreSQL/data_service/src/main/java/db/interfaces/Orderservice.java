package db.interfaces;

import db.dto.OrderDTO;
import db.requestmodel.OrderRequest;

import java.util.List;

public interface Orderservice {
    List<OrderDTO> getOrdersForCustomer(int id);

    List<OrderDTO> getOrdersForCourier(int id);

    List<OrderDTO> getOrdersForRestaurant(int id);

    OrderDTO saveNewOrder(OrderRequest orderReqest);

    OrderDTO deliverOrder(OrderRequest request);


}
