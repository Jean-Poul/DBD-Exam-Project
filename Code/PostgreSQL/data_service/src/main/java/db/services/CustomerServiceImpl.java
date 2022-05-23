package db.services;

import db.dto.CustomerDTO;
import db.dto.UserDTO;
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
    //public ResponseEntity<Customer> createCustomer(CustomerRequest request) {
    public CustomerDTO createCustomer(CustomerRequest request) {
        /*try {
            Customer newCustomer = customerRepo.save(new Customer(customer.getUser().getEmail(), customer.getFirstName(), customer.getLastName()));
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } */
        // create user return user id
        // find user by id
        User userId = userRepo.findById(request.getUserId()).get();
        // set user id on request (this customer) (a whole user on a customer)
        request.setUserId(userId.getId());
        // use this request to customer service to create customer
        // Customer createCustomer = .createCustomer(new CustomerRequest(customer.getUser().getEmail(), customer.getUser().getPassword(), customer.getUser().getPhone(), customer.getUser().getAddress().getId(), customer.getFirstName(), customer.getLastName()));

        // Now i have customer id for making new customer
        //createCustomer(new CustomerRequest(customer.getUser().getEmail(), customer.getUser().getPassword(), customer.getUser().getPhone(), customer.getUser().getAddress().getId(), customer.getFirstName(), customer.getLastName()));
        CustomerDTO customerDTO = null;
        return customerDTO;
    }

}
