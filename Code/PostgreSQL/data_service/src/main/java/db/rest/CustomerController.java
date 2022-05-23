package db.rest;

import db.dto.CustomerDTO;
import db.dto.UserDTO;
import db.entity.Customer;
import db.requestmodel.CustomerRequest;
import db.requestmodel.UserRequest;
import db.services.CustomerServiceImpl;
import db.services.RestaurantServiceImpl;
import db.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(path = "/createcustomer", consumes = "application/json", produces = "application/json")
   // public ResponseEntity<CustomerDTO> createOrder(@RequestBody Customer customer) {
    public CustomerDTO createOrder(@RequestBody Customer customer) {
        System.out.println("customer controller hit (post customer)");
        // return customerServiceImpl.createCustomer(customer);

        // take a customer request as the (requestbody) body
        // call user service to create user and make it return a userid
        int userId = userServiceImpl.createUser(new UserRequest(customer.getUser().getEmail(), customer.getUser().getPassword(), customer.getUser().getPhone(), customer.getUser().getAddress().getId()));
        // add a setter in user request to set the id from the returned id
        // then use customer request to create a new customer
        //String email, String password, String phone, int addressId, String firstName, String lastName
        CustomerRequest customerRequest = new CustomerRequest(customer.getUser().getEmail(), customer.getUser().getPassword(), customer.getUser().getPhone(), customer.getUser().getAddress().getId(), customer.getFirstName(), customer.getLastName());
        // make user return userDTO
        CustomerDTO customerDTO = customerServiceImpl.createCustomer(new CustomerRequest(customer.getUser().getEmail(), customer.getUser().getPassword(), customer.getUser().getPhone(), customer.getUser().getAddress().getId(), customer.getFirstName(), customer.getLastName()));
        // Customer service should also return customerDTO
        return customerDTO;
    }
}
