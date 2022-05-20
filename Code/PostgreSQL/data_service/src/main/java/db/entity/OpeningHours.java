package db.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class OpeningHours {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    private Integer restaurantId;
    @Column(nullable = false)
    private String weekDay;
    @Column(nullable = false)
    private String openFrom;
    @Column(nullable = false)
    private String openTo;

    public OpeningHours() {
    }

    public long getId() {
        return id;
    }

    @Column(name = "restaurant_id")
    public int getRestaurantId() {
        return restaurantId;
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

    public OpeningHours(int restaurantId, String weekDay, String openFrom, String openTo) {
        this.restaurantId = restaurantId;
        this.weekDay = weekDay;
        this.openFrom = openFrom;
        this.openTo = openTo;
    }
}










//package db.entity;
//
//import javax.persistence.*;
//
//@Entity
//public class OpeningHours {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "restaurant_id")
//    private Restaurant restaurant;
//    private String weekDay;
//    private String openFrom;
//    private String openTo;
//
//    public OpeningHours() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public String getWeekDay() {
//        return weekDay;
//    }
//
//    public String getFrom() {
//        return openFrom;
//    }
//
//    public String getTo() {
//        return openTo;
//    }
//
//}
