package db.services;

import db.connectors.DataConnectorImpl;
import db.entities.Customer;
import db.entities.CustomerRequest;
import db.entities.User;
import db.entities.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    DataConnectorImpl connector;

    @Override
    public User login(UserRequest request) throws URISyntaxException {
        return connector.login(request);
    }

    @Override
    public Customer createCustomer(CustomerRequest request) throws URISyntaxException {
        return connector.createCustomer(request);
    }
}
