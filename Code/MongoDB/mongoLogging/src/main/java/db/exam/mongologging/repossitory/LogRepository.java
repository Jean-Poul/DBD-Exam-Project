package db.exam.mongologging.repossitory;

import db.exam.mongologging.model.Logs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Logs, String> {
}