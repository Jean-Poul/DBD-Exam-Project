package db.services;

import db.dto.CourierDTO;
import db.entity.Courier;
import db.interfaces.CourierService;
import db.repository.CourierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    CourierRepo courierRepo;


    @Override
    public List<CourierDTO> getAllCouriers() {
        List<CourierDTO> list = new ArrayList<>();
        for (Courier c : courierRepo.getAllCouriers()) {
            list.add(new CourierDTO(c));
        }
        return list;
    }

    @Override
    public CourierDTO getCourierById(int id) throws Exception {
        return new CourierDTO(courierRepo.findById(id).get());
    }
}
