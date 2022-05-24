package db.services;

import db.dto.AddressDTO;
import db.dto.CustomerDTO;
import db.dto.UserDTO;
import db.entity.Customer;
import db.entity.User;
import db.interfaces.CustomerService;
import db.repository.CustomerRepo;
import db.repository.UserRepo;
import db.requestmodel.CustomerRequest;
import db.requestmodel.UserRequest;
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
    public CustomerDTO createCustomer(UserRequest request) {
        System.out.println("CUSTOMER SERVICE HIT: " + request);
        /*try {
            Customer newCustomer = customerRepo.save(new Customer(customer.getUser().getEmail(), customer.getFirstName(), customer.getLastName()));
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } */
        // create user return user id
        // find user by id
        User user = userRepo.findById(request.getUserId()).get();
        System.out.println("USER id: " + user.getId());
        System.out.println("USER email: " + user.getEmail());
        System.out.println("USER ROLE: " + user.getRoles());

        Customer newCustomer = userRepo.getCustomerByUserId(request.getEmail());
        System.out.println(newCustomer.getFirstName());
        System.out.println(newCustomer.getId());
        System.out.println(newCustomer.getUser().getPassword());
        CustomerDTO customerDTO = new CustomerDTO(newCustomer.getUser().getId(), newCustomer.getId(), newCustomer.getUser().getEmail(), newCustomer.getUser().getPhone(), newCustomer.getFirstName(), newCustomer.getLastName());
       // Customer(String firstName, String lastName)
       // CustomerDTO(int userId, int customerId, String email, String phone, String firstName, String lastName)
        //Customer newCustomer = new Customer(request.)
        //User userId = userRepo.findById(request.getUserId()).get();
        //Customer customerId = customerRepo.findById(user.getId()).get();
        // set user id on request (this customer) (a whole user on a customer)
       // request.setUserId(userId.getId());
        // use this request to customer service to create customer
        //int userId, int customerId, String email, String phone, String firstName, String lastName, AddressDTO address
      //  CustomerDTO customerDTO = new CustomerDTO(user.getId(), customerId.getId(), user.getEmail(), user.getPhone(), customerId.getFirstName(), customerId.getLastName());

        // Now i have customer id for making new customer
        //createCustomer(new CustomerRequest(customer.getUser().getEmail(), customer.getUser().getPassword(), customer.getUser().getPhone(), customer.getUser().getAddress().getId(), customer.getFirstName(), customer.getLastName()));
        return customerDTO;
    }

}
