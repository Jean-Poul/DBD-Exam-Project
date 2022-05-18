package db.rest;


import db.dto.RestaurantDTO;
import db.services.OrderPopulator;
import db.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;

  // localhost:9081/restaurant/getrestaurant?id=9
    @GetMapping("getrestaurant")
    public String get(@RequestParam("id") int id) throws Exception {
       restaurantServiceImpl.getRestaurantById(id);
       return "blablabla";
    }

    @GetMapping("getallrestaurant")
    public String get() {
        //restaurantServiceImpl.getAllRestaurants(list);
        return "PING? PONG!";
    }

  /*  @PostMapping
    public ProjectDTO uploadFileToCleardox(@RequestHeader("user") String userId,
                                           @RequestHeader("x_top_session_id") String itgSession,
                                           @RequestBody Foid foid) {
        return userUtils.uploadNewProject(userId, itgSession, foid);
    } */


}
