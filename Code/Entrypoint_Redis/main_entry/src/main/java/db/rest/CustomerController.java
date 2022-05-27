package db.rest;

import db.entities.Customer;
import db.entities.CustomerRequest;
import db.entities.User;
import db.entities.UserRequest;
import db.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public User loginUser(@RequestBody UserRequest request) throws URISyntaxException {
        return userService.login(request);
    }

    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public Customer createUser(@RequestBody CustomerRequest request) throws URISyntaxException {
        System.out.println(request.toString());
        return userService.createCustomer(request);
    }
}
