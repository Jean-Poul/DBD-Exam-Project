package db.entity;

import javax.persistence.*;

@Entity
public class OpeningHours {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private String weekDay;
    private String openFrom;
    private String openTo;

    public OpeningHours() {
    }

    public long getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public String getFrom() {
        return openFrom;
    }

    public String getTo() {
        return openTo;
    }

}
