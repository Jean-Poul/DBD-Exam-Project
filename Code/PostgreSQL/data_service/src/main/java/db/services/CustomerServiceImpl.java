package db.services;

import db.dto.CustomerDTO;
import db.entity.Customer;
import db.interfaces.CustomerService;
import db.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    PasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public ResponseEntity<Customer> createCustomer(Customer customer) {
    /*    try {
            Customer newCustomer = customerRepo.save(new Customer(customer.getUser().getEmail(), customer.getFirstName(), customer.getLastName()));
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
        return null;
    }

    @Override
    public Customer registerUser(Customer user) {
        passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUser().getPassword());
        user.getUser().setPassword(encodedPassword);
        return customerRepo.save(user);
    }


}
