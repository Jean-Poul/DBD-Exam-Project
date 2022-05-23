package db.services;

import db.entity.Customer;
import db.interfaces.CustomerService;
import db.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public ResponseEntity<Customer> createCustomer(Customer customer) {
        try {
            Customer newCustomer = customerRepo.save(new Customer(customer.getUser().getEmail(), customer.getFirstName(), customer.getLastName()));
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
