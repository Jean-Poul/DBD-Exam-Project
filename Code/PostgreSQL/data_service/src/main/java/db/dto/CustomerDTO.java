package db.dto;

import db.entity.Customer;

public class CustomerDTO extends UserDTO {

    private int customerId;
    private String firstName;
    private String lastName;

    public CustomerDTO(Customer customer) {
        this.setEmail(customer.getUser().getEmail());
        this.setPhone(customer.getUser().getPhone());
        this.setAddress(new AddressDTO(customer.getUser().getAddress()));
        this.customerId = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
