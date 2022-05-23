package db.interfaces;

import db.requestmodel.UserRequest;

public interface UserService {

    int createUser(UserRequest request);

}
