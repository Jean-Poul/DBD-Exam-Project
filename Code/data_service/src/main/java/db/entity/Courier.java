package db.entity;

import javax.persistence.*;

@Entity(name = "Courier")
@Table(name = "couriers")
public class Courier {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private double x;
    private double y;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Courier() {
    }

    public Courier(String firstName, String lastName, double x, double y) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.x = x;
        this.y = y;
    }

    public User getUser() {
        return user;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double[] getLocation() {
        return new double[]{x, y};
    }

    public void setLocation(double[] loc) {
        this.x = loc[0];
        this.y = loc[1];
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
