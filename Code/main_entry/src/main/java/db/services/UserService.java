package db.services;

import db.entities.Customer;
import db.entities.CustomerRequest;
import db.entities.User;
import db.entities.UserRequest;

import java.net.URISyntaxException;

public interface UserService {

    User login(UserRequest request) throws URISyntaxException;
    Customer createCustomer(CustomerRequest request) throws URISyntaxException;

}
