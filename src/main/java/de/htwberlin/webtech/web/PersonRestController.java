package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.PersonService;
import de.htwberlin.webtech.web.api.Person;
import de.htwberlin.webtech.web.api.PersonManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(path = "/api/persons")
    public ResponseEntity<List<Person>> fetchPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping(path = "/api/persons/{id}")
    public ResponseEntity<Person> fetchPersonsById(@PathVariable Long id) {
        var person = personService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonManipulationRequest request) throws URISyntaxException {
        var person = personService.create(request);
        URI uri = new URI("/api/persons/" + person.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody PersonManipulationRequest request) {
        var person = personService.update(id, request);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }
    @DeleteMapping(path = "/api/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean sucessfull = personService.deleteById(id);
        return sucessfull? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
