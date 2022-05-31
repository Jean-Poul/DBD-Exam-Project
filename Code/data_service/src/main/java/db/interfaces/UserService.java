package db.interfaces;

import db.dto.CustomerDTO;
import db.dto.UserDTO;
import db.entity.User;
import db.requestmodel.CustomerRequest;
import org.apache.tomcat.websocket.AuthenticationException;

public interface UserService {

    User createUser(String email, String password, String phone, int addressId);

    CustomerDTO createCustomer(CustomerRequest request);

    UserDTO verifyUser(String userEmail, String password) throws AuthenticationException;

}
