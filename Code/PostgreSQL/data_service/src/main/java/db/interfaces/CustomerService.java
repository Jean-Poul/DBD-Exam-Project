package db.interfaces;

import db.entity.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    public ResponseEntity<Customer> createCustomer(Customer customer);

}
