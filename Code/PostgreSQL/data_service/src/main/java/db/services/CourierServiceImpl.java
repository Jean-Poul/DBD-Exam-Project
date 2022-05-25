package db.services;

import db.dto.CourierDTO;
import db.dto.CustomerDTO;
import db.entity.Courier;
import db.interfaces.CourierService;
import db.repository.CourierRepo;
import db.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    CourierRepo courierRepo;


    @Override
    public List<CourierDTO> getAllCouriers() {
        return courierRepo.getAllCouriers();
    }

    @Override
    public CourierDTO getCourierById(int id) throws Exception {
        return courierRepo.getCourierById(id);
    }
}
