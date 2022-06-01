package db.services;

import db.dto.AddressDTO;
import db.dto.CustomerDTO;
import db.dto.CustomersDTO;
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

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public CustomerDTO getCustomerById(int id) throws Exception {
        Customer customer = customerRepo.findById(id).get();
        return new CustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers = new ArrayList<>();
        for (Customer c : customerRepo.getAllCustomers()) {
            customers.add(new CustomerDTO(c));
        }
        return customers;
    }

}
