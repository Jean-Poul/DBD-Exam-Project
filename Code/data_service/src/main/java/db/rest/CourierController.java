package db.rest;

import db.dto.CourierDTO;
import db.dto.CustomerDTO;
import db.services.CourierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    CourierServiceImpl courierServiceImpl;

    @GetMapping(path = "/allcouriers")
    public List<CourierDTO> getAllCouriers() {
        return courierServiceImpl.getAllCouriers();
    }

    @GetMapping(path = "/courierbyid")
    public CourierDTO getCourier(@RequestParam("id") int id) throws Exception {
        return courierServiceImpl.getCourierById(id);
    }
}
