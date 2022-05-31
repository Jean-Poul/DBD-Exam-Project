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
import db.repository.UserRepo;
import db.requestmodel.CustomerRequest;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Array;

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

    @Override
    public UserDTO verifyUser(String userEmail, String password) throws AuthenticationException {
        User user = userRepo.getUserByUserEmail(userEmail);
        Address address = new Address(user.getAddress().getStreet(), user.getAddress().getBuildingIdentifier(), user.getAddress().getLocalIdentifier(), user.getAddress().getZipcode(), user.getAddress().getX(), user.getAddress().getY());
        AddressDTO addressDTO = new AddressDTO(address);
        if (user.verifyPassword(password) && user.getEmail() != null) {
            return new UserDTO(user.getEmail(), user.getPhone(), addressDTO);
        } else {
            throw new AuthenticationException("Verification failed");
        }
    }
}
