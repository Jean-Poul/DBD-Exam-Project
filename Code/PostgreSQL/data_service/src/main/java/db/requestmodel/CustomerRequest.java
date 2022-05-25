package db.requestmodel;

import db.entity.User;

public class CustomerRequest extends UserRequest {
    private String firstName;
    private String lastName;

    public CustomerRequest() {
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
