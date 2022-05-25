package db.repository;

import db.entity.Customer;
import db.entity.Role;
import db.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

    @Query("SELECT r FROM Customer r JOIN r.user i WHERE r.user.email = ?1")
    Customer getCustomerByUserId(String userId);

    @Query("SELECT r FROM Role r WHERE r.roleName = ?1")
    Role getRole(String rolaName);
}
