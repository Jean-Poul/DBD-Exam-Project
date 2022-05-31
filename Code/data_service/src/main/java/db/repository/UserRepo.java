package db.repository;

import db.entity.Customer;
import db.entity.Role;
import db.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User getUserByUserEmail(String userEmail);

    @Query("SELECT r FROM Role r WHERE r.roleName = ?1")
    Role getRole(String rolaName);
}
