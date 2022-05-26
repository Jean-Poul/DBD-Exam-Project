package db.entities;


import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("OpeningHours")
public class OpeningHours implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

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

    public String getId() {
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
