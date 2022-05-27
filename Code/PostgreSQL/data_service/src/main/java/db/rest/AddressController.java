package db.rest;

import db.dto.AddressDTO;
import db.dto.RestaurantDTO;
import db.entity.Address;
import db.services.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressServiceImpl;

    @GetMapping("addressById")
    public AddressDTO get(@RequestParam("id") int id) throws Exception {
        return addressServiceImpl.getRestaurantCoordinatesById(id);
    }
}
