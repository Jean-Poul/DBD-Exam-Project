package db.dto;

import db.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private String email;
    private String password;
    private String phone;
    //private Set<Role> roles = new HashSet();
    AddressDTO address;

    public UserDTO(String email, String password, String phone, AddressDTO address) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
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

    public AddressDTO getAddress() {
        return address;
    }
}
