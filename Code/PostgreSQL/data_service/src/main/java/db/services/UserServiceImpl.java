package db.services;

import db.dto.AddressDTO;
import db.dto.CustomerDTO;
import db.dto.UserDTO;
import db.entity.Address;
import db.entity.Customer;
import db.entity.Role;
import db.entity.User;
import db.interfaces.UserService;
import db.repository.AddressRepo;
import db.repository.CustomerRepo;
import db.repository.RestaurantRepo;
import db.repository.UserRepo;
import db.requestmodel.CustomerRequest;
import db.requestmodel.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AddressRepo addressRepo;


    public int _createUser(CustomerRequest request) {
        // TODO : remove this  when done String street, String buildingIdentifier, String localIdentifier, int zipcode, double x, double y
        //user:  String email, String password, String phone, Address address
        System.out.println("USER SERVICE HIT: " + request);
        //Customer newCustomer = new Customer(request.getFirstName(), request.getLastName());
        //customerRepo.save(newCustomer);
        //User user = userRepo.findById()
        // UserRequest userRequest = new UserRequest(request.getEmail(), request.getPassword(), request.getPhone(), request.getAddressId());
        // System.out.println("USER REQUEST: " + userRequest.getAddressId());
        // Address address = addressRepo.findAddressById(request.getEmail());
        // Address address = addressRepo.findById(userRequest.getAddressId()).get();
        User user = new User(request.getEmail(), request.getPassword(), request.getPhone());
        userRepo.save(user);
        System.out.println("USER SAVED");
        Customer newCustomer = new Customer(request.getFirstName(), request.getLastName());
        newCustomer.setUser(user);
        Role role = new Role("Customer");
        newCustomer.getUser().addRole(role);
        //newCustomer.getUser().setAddress(address);
        customerRepo.save(newCustomer);
        System.out.println("CUSTOMER SAVED");
        User userResponse = userRepo.findById(user.getId()).get();
        Address test = addressRepo.findAddressById(userResponse.getEmail());
        // System.out.println("TEST ID: " + test.getId());
        System.out.println("USER id: " + userResponse.getId());
        //System.out.println("USER ADDR: " + userResponse.getAddress());
        return userResponse.getId();
    }

    @Override
    public User createUser(String email, String password, String phone, int addressId) {
        Address address = addressRepo.findById(addressId).get();
        return userRepo.save(new User(email, password, phone, address));
    }

    @Override
    public CustomerDTO createCustomer(CustomerRequest request) {
        User user = createUser(request.getEmail(), request.getPassword(), request.getPhone(), request.getAddressId());
        Role role = userRepo.getRole("Customer");
        user.addRole(role);
        CustomerDTO created = new CustomerDTO(customerRepo.save(new Customer(request.getFirstName(), request.getLastName(), user)));
        created.setAddress(new AddressDTO(user.getAddress()));
        return created;
    }

}
