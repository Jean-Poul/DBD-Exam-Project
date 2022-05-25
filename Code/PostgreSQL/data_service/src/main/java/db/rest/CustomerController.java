package db.rest;

import db.dto.CustomerDTO;
import db.requestmodel.CustomerRequest;
import db.requestmodel.UserRequest;
import db.services.CustomerServiceImpl;
import db.services.UserServiceImpl;
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
}
