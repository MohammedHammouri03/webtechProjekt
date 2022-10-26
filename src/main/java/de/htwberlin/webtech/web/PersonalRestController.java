package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.PersonService;
import de.htwberlin.webtech.web.api.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonalRestController {

    private final PersonService personService;

    public PersonalRestController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(path = "/api/persons")
    public ResponseEntity<List<Person>> fetchPersons() {
        var persons = personService.findAll();
        return ResponseEntity.ok(persons);
    }
}