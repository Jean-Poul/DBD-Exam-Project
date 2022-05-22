package db.repository;

import db.entity.Role;
import db.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepo extends CrudRepository<User, Integer> {

}
