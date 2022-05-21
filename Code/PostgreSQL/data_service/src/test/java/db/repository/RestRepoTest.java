package db.repository;

import db.entity.Restaurant;
import db.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:testapp.properties"})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class RestRepoTest {

    @Autowired
    RestRepo sut;

    @BeforeEach
    void setUp() {


    }

    @Test
    void getCount(){

        System.out.println(sut.count());
      //  System.out.println(sut.findById(2).get().getMenu().size());
                //findById(2).get().getMenu().size());
       //int size = (sut.getTEST(2).size());
       // System.out.println(size);

       Restaurant res =  sut.findById(2).orElseThrow(() -> new NoSuchElementException("NOTHING FOUND"));
        System.out.println(res.getMenu().size());

        System.out.println(sut.getMenu(2).size());
    }

    @AfterEach
    void tearDown() {

    }
}