package db.rest;

import db.dto.CustomerDTO;
import db.services.CourierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    CourierServiceImpl courierServiceImpl;

    @GetMapping(path = "/allcouriers")
    public List<CustomerDTO> getAllCouriers() {
        return courierServiceImpl.getAllCouriers();
    }
}
