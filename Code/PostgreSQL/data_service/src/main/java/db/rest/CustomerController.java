package db.rest;

import db.dto.CustomerDTO;
import db.dto.UserDTO;
import db.requestmodel.CustomerRequest;
import db.requestmodel.UserRequest;
import db.services.CustomerServiceImpl;
import db.services.UserServiceImpl;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public CustomerDTO createCustomer(@RequestBody CustomerRequest request) {
        return userServiceImpl.createCustomer(request);
    }

    @GetMapping(path = "/allcustomers")
    public List<CustomerDTO> getAllCustomers() {
        return customerServiceImpl.getAllCustomers();
    }

    @GetMapping(path = "/customerbyid")
    public CustomerDTO getCustomerById(@RequestParam("id") int id) throws Exception {
        return customerServiceImpl.getCustomerById(id);
    }

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public UserDTO loginUser(@RequestBody UserRequest request) throws AuthenticationException {
        String password = request.getPassword();
        String userEmail = request.getEmail();
// find user by email
        return userServiceImpl.verifyUser(userEmail, password);
    }
}
