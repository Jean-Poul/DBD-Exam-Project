package db.rest;

//import db.services.OrderPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/sampledata")
public class SampleDataController {

//    @Autowired
//    private OrderPopulator orderPopulator;

    @GetMapping("geturl")
    public String get() {

//        orderPopulator.populateOrders(10);
        return "SAmple orders created";
    }

    @PostMapping("posturl")
    public String post(@RequestBody String msg) {
        return "That was a post request with body: " + msg;
    }


}
