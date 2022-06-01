package db.dto;

import db.entity.Courier;
import db.entity.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourierDTO {

    private String firstName;
    private String lastName;
    // private double[] locationList;
    private String email;
    // private Set<Role> roles = new HashSet();

    public CourierDTO(Courier courier) {
        this.firstName = courier.getFirstName();
        this.lastName = courier.getLastName();
        //this.locationList = courier.getLocation();
       // this.email = courier.getUser().getEmail();
        //  this.roles = courier.getUser().getRoles();
    }

    public CourierDTO() {
    }
}
