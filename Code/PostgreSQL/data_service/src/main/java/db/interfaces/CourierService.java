package db.interfaces;

import db.dto.CustomerDTO;

import java.util.List;

public interface CourierService {
    List<CourierDTO> getAllCouriers();
}
