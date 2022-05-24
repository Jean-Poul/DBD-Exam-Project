package db.interfaces;

import db.dto.CustomerDTO;
import db.dto.UserDTO;
import db.entity.Customer;
import db.requestmodel.CustomerRequest;
import db.requestmodel.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    CustomerDTO createCustomer(UserRequest request);

    List<CustomerDTO> getAllCustomers();

}
