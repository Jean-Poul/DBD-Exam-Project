package db.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "OpeningHours", timeToLive = 5)
public class OpeningHours implements Serializable {

    private static final long serialVersionUID = -7792341923197594840L;
    private String weekDay;
    private String openFrom;
    private String openTo;


    @Override
    public String toString() {
        return weekDay + " from " + openFrom + " to " + openTo;
    }
}
