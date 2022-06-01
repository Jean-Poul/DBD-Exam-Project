package db.entity;

import javax.persistence.*;

@Entity(name="OpeningHours")
@Table(name="opening_hours")
public class OpeningHours {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String weekDay;
    private String openFrom;
    private String openTo;

    public OpeningHours() {
    }

    public OpeningHours(String weekDay, String openFrom, String openTo) {
        this.weekDay = weekDay;
        this.openFrom = openFrom;
        this.openTo = openTo;
    }

    public Integer getId() {
        return id;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public String getOpenFrom() {
        return openFrom;
    }

    public String getOpenTo() {
        return openTo;
    }

    @Override
    public String toString() {
        return weekDay + " from " + openFrom + " to " + openTo;
    }
}
