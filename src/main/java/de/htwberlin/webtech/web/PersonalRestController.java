package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.PersonService;
import de.htwberlin.webtech.web.api.Person;
import de.htwberlin.webtech.web.api.PersonCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PersonalRestController {

    private final PersonService personService;

    public PersonalRestController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(path = "/api/persons")
    public ResponseEntity<List<Person>> fetchPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping(path = "/api/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonCreateRequest request) throws URISyntaxException {
        var person = personService.create(request);
        URI uri = new URI("/api/persons/" + person.getId());
        return ResponseEntity.created(uri).build();
    }
}