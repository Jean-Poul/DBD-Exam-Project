package db.dto;

import db.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private String email;
    private String phone;
    //private Set<Role> roles = new HashSet();
    AddressDTO address;

    public UserDTO(String email, String phone, AddressDTO address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public UserDTO() {
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
