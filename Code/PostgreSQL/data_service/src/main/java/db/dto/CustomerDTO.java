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

    // TODO DELETE CONSTRUCTOR WHEN WORKING
    public CustomerDTO(int userId, int customerId, String email, String phone, String firstName, String lastName) {
        this.userId = userId;
        this.customerId = customerId;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressDTO getAddress() {
        return address;
    }
}
