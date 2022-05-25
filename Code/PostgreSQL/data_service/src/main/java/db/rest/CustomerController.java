package db.rest;

import db.dto.CustomerDTO;
import db.entity.Customer;
import db.services.CustomerServiceImpl;
import db.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping(path = "/createcustomer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> createOrder(@RequestBody Customer customer) {
        System.out.println("customer controller hit (post customer)");
        return customerServiceImpl.createCustomer(customer);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CustomerDTO createuUserLogin(@RequestBody Customer user) {
        Customer us = customerServiceImpl.registerUser(user);
        CustomerDTO customerDTO = new CustomerDTO(us.getFirstName(), us.getLastName());
        return customerDTO;
    }
}
