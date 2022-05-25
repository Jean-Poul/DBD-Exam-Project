package db.interfaces;

import db.dto.CustomerDTO;
import db.entity.Customer;
import db.entity.User;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<Customer> createCustomer(Customer customer);

    Customer registerUser(Customer user);

}
