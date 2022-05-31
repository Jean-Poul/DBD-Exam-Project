package db.interfaces;

import db.dto.CourierDTO;
import db.dto.CustomerDTO;

import java.util.List;

public interface CourierService {
    List<CourierDTO> getAllCouriers();
    CourierDTO getCourierById(int id) throws Exception;
}
