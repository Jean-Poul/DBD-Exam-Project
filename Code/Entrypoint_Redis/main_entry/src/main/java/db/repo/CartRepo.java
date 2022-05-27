package db.repo;

import db.entities.OrderRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends CrudRepository<OrderRequest, Integer> {
}

