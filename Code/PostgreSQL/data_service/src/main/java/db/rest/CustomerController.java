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

    @PostMapping(path = "/createcustomer", consumes = "application/json", produces = "application/json")
    // public ResponseEntity<CustomerDTO> createOrder(@RequestBody Customer customer) {
    public CustomerDTO createOrder(@RequestBody CustomerRequest customer) {
        System.out.println("customer controller hit (post customer)");
        System.out.println("CUSTOMER FROM CONTROLLER id: " + customer.getUserId());
        System.out.println("CUSTOMER FROM CONTROLLER fN: " + customer.getFirstName());
        System.out.println("CUSTOMER FROM CONTROLLER lN: " + customer.getLastName());
        System.out.println("CUSTOMER FROM CONTROLLER email: " + customer.getEmail());
        System.out.println("CUSTOMER FROM CONTROLLER pass: " + customer.getPassword());
        System.out.println("CUSTOMER FROM CONTROLLER phone: " + customer.getPhone());
        int id = userServiceImpl.createUser(customer);
        UserRequest userRequest = new UserRequest(customer.getEmail(), customer.getPassword(), customer.getPhone(), customer.getAddressId());
        userRequest.setUserId(id);
        CustomerDTO customerDTO = customerServiceImpl.createCustomer(userRequest);
        return customerDTO;
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
