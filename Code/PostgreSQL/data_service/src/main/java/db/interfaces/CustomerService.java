package db.interfaces;

import db.entity.Customer;
import db.requestmodel.CustomerRequest;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    public ResponseEntity<Customer> createCustomer(CustomerRequest request);

}
