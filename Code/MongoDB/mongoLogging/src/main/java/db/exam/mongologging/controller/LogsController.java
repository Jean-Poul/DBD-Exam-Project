package db.exam.mongologging.controller;

import db.exam.mongologging.model.Logs;
import db.exam.mongologging.repossitory.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/log")
public class LogsController {

    @Autowired
    LogRepository logRepository;
    Logger LOGGER = LoggerFactory.getLogger(LogsController.class);



    @PostMapping("/log")
    @ResponseStatus(HttpStatus.OK)
    public void saveLog(@RequestBody Logs log) {
        logRepository.save(log);
        System.out.println(log);
    }

    @GetMapping(value = { "", "/" })
    List<Logs> getRestaurants() {
        return logRepository.findAll();
    }
}
