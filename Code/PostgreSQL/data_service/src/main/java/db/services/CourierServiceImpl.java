package db.services;

import db.dto.CustomerDTO;
import db.repository.CourierRepo;
import db.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CourierServiceImpl {

    @Autowired
    CourierRepo courierRepo;



}
