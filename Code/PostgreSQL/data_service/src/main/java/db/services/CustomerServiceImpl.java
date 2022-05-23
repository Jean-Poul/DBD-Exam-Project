package db.services;

import db.entity.Customer;
import db.entity.User;
import db.interfaces.CustomerService;
import db.repository.CustomerRepo;
import db.repository.UserRepo;
import db.requestmodel.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public ResponseEntity<Customer> createCustomer(CustomerRequest request) {
        /*try {
            Customer newCustomer = customerRepo.save(new Customer(customer.getUser().getEmail(), customer.getFirstName(), customer.getLastName()));
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } */
        // create user return user id
        User user = new User();
        // find user by id
        User userId = userRepo.findById(request.getUserId()).get();
        // set user id on request (this customer) (a whole user on a customer)
        request.setUserId(userId.getId());
        // use this request to customer service to create customer
        Customer createCustomer = service
        // Now i have customer id for making new customer
        Customer customer = new Customer(request.getFirstName(), request.getLastName(), request)
    }

}
