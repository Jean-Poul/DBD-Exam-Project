package cph.db.neo4jservice.repository;

import cph.db.neo4jservice.entities.MovieEntity;
import cph.db.neo4jservice.entities.PersonEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends ReactiveNeo4jRepository<PersonEntity, String> {
    Mono<PersonEntity> findOneByName(String name);
}

