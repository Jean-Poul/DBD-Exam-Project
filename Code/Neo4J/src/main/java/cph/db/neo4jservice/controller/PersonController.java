package cph.db.neo4jservice.controller;

import cph.db.neo4jservice.entities.PersonEntity;
import cph.db.neo4jservice.repository.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PutMapping
    Mono<PersonEntity> createOrUpdatePerson(@RequestBody PersonEntity newPerson) {
        return personRepository.save(newPerson);
    }
    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<PersonEntity> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/by-title")
    Mono<PersonEntity> byTitle(@RequestParam String title) {
        return personRepository.findOneByName(title);
    }
    /*@DeleteMapping("/\{id\}")
    Mono<Void> delete(@PathVariable String id) {
        return movieRepository.deleteById(id);
    }*/
}