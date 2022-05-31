package db.dto;

import db.entity.Courier;
import db.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CouriersDTO {
    List<CourierDTO> all = new ArrayList();

    public CouriersDTO(List<Courier> courierEntities) {
        courierEntities.forEach((courier) -> {
            all.add(new CourierDTO(courier));
        });
    }
}
