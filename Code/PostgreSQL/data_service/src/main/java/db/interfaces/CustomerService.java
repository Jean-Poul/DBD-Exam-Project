package db.interfaces;

import db.dto.CustomerDTO;
import db.dto.UserDTO;
import db.entity.Customer;
import db.requestmodel.CustomerRequest;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    CustomerDTO createCustomer(CustomerRequest request);

}
