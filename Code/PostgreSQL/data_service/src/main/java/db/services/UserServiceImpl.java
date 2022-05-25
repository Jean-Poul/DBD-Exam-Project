package db.services;

import db.dto.AddressDTO;
import db.dto.CustomerDTO;
import db.entity.Address;
import db.entity.Customer;
import db.entity.Role;
import db.entity.User;
import db.interfaces.UserService;
import db.repository.AddressRepo;
import db.repository.CustomerRepo;
import db.repository.UserRepo;
import db.requestmodel.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AddressRepo addressRepo;

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
