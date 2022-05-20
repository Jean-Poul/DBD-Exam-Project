package db.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)


@MappedSuperclass

public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String email;
    private String password;
    private String phone;
    private Integer addressId;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet();


    public User() {
    }

    public User(String email, String password, String phone, Integer addressId, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.addressId = addressId;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }
}
