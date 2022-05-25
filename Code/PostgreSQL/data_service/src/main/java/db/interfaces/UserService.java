package db.interfaces;

import db.dto.CustomerDTO;
import db.entity.User;
import db.requestmodel.CustomerRequest;

public interface UserService {

    User createUser(String email, String password, String phone, int addressId);

    CustomerDTO createCustomer(CustomerRequest request);

}
