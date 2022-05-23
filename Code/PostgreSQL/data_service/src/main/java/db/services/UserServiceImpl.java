package db.services;

import db.entity.Address;
import db.entity.User;
import db.interfaces.UserService;
import db.repository.AddressRepo;
import db.repository.RestaurantRepo;
import db.repository.UserRepo;
import db.requestmodel.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AddressRepo addressRepo;

    @Override
    public int createUser(UserRequest request) {
        //String street, String buildingIdentifier, String localIdentifier, int zipcode, double x, double y
        Address address = addressRepo.findById(request.getAddressId()).get();
        User user = new User(request.getEmail(), request.getPassword(), request.getPhone(), address);
        userRepo.save(user);
        int userRespone = user.getId();
        return userRespone;
    }
}
