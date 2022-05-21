package db.services;
import com.google.gson.Gson;
import db.entity.Restaurant;
import db.repository.RestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ResServ {

    @Autowired
    private static RestRepo restRepo;
    private static final Gson GSON =new Gson();

    public Restaurant getRstById
            (String email) {
        Restaurant r = restRepo.findById(2).orElseThrow(() -> new NoSuchElementException("NOTHING FOUND"));
        System.out.println(GSON.toJson(r));
        return r;
    }
}
