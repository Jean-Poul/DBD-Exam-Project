package db.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet();


    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public User() {
    }

    public User(String email, String password, String phone, Address address) {
        this.email = email;
        encodePassword(password);
        this.phone = phone;
        this.address = address;
    }

    // TODO DELETE THIS CONSTRUCTOR
    public User(String email, String password, String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    private void encodePassword(String password) {
        PasswordEncoder passwordEncoder;
        passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public boolean verifyPassword(String password) {
        PasswordEncoder passwordEncoder;
        passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, this.password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public Address getAddress() {
        return address;
    }
}
