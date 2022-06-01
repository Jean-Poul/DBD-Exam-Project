package db.requestmodel;

public class UserRequest {
    private String email;
    private String password;
    private String phone;
    private int addressId;

    public UserRequest() {
    }

    public UserRequest(String email, String password, String phone, int addressId) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.addressId = addressId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public int getAddressId() {
        return addressId;
    }


}
