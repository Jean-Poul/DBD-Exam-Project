package db.interfaces;

import db.entity.User;
import db.requestmodel.CustomerRequest;
import db.requestmodel.UserRequest;

public interface UserService {

    int createUser(UserRequest request);

}
