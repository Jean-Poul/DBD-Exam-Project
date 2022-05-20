package db.repository;

import db.entity.Item;
import db.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Set;

@Repository
public interface RestRepo extends CrudRepository<Restaurant, Integer> {
//    @Query("SELECT i FROM Restaurant r JOIN r.menu i WHERE r.id = ?1")
//    public Set<Item> getTEST(int id);

}
