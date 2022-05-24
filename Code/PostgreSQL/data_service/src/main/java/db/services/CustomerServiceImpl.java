package db.services;

import db.dto.AddressDTO;
import db.dto.CustomerDTO;
import db.dto.UserDTO;
import db.entity.Customer;
import db.entity.User;
import db.interfaces.CustomerService;
import db.repository.AddressRepo;
import db.repository.CustomerRepo;
import db.repository.UserRepo;
import db.requestmodel.CustomerRequest;
import db.requestmodel.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    //public ResponseEntity<Customer> createCustomer(CustomerRequest request) {
    public CustomerDTO createCustomer(UserRequest request) {
        System.out.println("CUSTOMER SERVICE HIT: " + request);
        /*try {
            Customer newCustomer = customerRepo.save(new Customer(customer.getUser().getEmail(), customer.getFirstName(), customer.getLastName()));
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } */
        User user = userRepo.findById(request.getUserId()).get();
        System.out.println("USER id: " + user.getId());
        System.out.println("USER email: " + user.getEmail());
        System.out.println("USER ROLE: " + user.getRoles());
        Customer newCustomer = userRepo.getCustomerByUserId(request.getEmail());
        System.out.println(newCustomer.getFirstName());
        System.out.println(newCustomer.getId());
        System.out.println(newCustomer.getUser().getPassword());
        CustomerDTO customerDTO = new CustomerDTO(newCustomer.getUser().getId(), newCustomer.getId(), newCustomer.getUser().getEmail(), newCustomer.getUser().getPhone(), newCustomer.getFirstName(), newCustomer.getLastName());
        return customerDTO;
    }

    @Override
    public CustomerDTO getCustomerById(int id) throws Exception {
        Customer customer = customerRepo.findById(id).get();
        return new CustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }

}
