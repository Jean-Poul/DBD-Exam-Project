package db.requestmodel;

import db.entity.User;

public class CustomerRequest extends UserRequest {
    private String firstName;
    private String lastName;

    public CustomerRequest(String email, String password, String phone, int addressId, String firstName, String lastName) {
        super(email, password, phone, addressId);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
