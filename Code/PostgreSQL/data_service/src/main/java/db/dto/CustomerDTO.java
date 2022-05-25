package db.dto;

import db.entity.Customer;

public class CustomerDTO extends UserDTO {

    private int customerId;
    private String firstName;
    private String lastName;

    public CustomerDTO(String email, String phone, AddressDTO address, int customerId, String firstName, String lastName) {
        super(email, phone, address);
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerDTO(Customer customer) {
        this.setEmail(customer.getUser().getEmail());
        this.setPhone(customer.getUser().getPhone());
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
