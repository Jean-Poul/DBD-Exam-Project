package db.dto;

import db.entity.Courier;
import db.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class CourierDTO {

    private String firstName;
    private String lastName;
    private double[] location;
    private String email;
    private Set<Role> roles = new HashSet();

    public CourierDTO(Courier courier) {
        this.firstName = courier.getFirstName();
        this.lastName = courier.getLastName();
        this.location = courier.getLocation();
        this.email = courier.getUser().getEmail();
        this.roles = courier.getUser().getRoles();
    }
}
