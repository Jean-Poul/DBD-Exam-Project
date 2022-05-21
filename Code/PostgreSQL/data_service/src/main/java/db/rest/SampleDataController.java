package db.rest;

//import db.services.OrderPopulator;
import db.services.OrderPopulator;
import db.services.ResServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/testdata")
public class SampleDataController {

    @Autowired
    private OrderPopulator orderPopulator;
@Autowired
    ResServ resServ;
    @GetMapping("orders")
    public String get() {
        System.out.println("GET testdata");
        orderPopulator.populateOrders(2);
        return "SAmple orders created";
    }

    @PostMapping("posturl")
    public String post(@RequestBody String msg) {
        return "That was a post request with body: " + msg;
    }


}
