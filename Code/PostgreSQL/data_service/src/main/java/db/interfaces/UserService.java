package db.interfaces;

import db.entity.Customer;
import db.requestmodel.CustomerRequest;
import db.requestmodel.UserRequest;

public interface UserService {

    int createUser(CustomerRequest request);

}
