package db.dto;

public class CustomerDTO {
    private int userId;
    private int customerId;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private AddressDTO address;

    public CustomerDTO(int userId, int customerId, String email, String phone, String firstName, String lastName, AddressDTO address) {
        this.userId = userId;
        this.customerId = customerId;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
