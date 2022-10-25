package de.htwberlin.webtech.web;

import de.htwberlin.webtech.web.api.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonalRestController {

    private List<Person> persons;

    public PersonalRestController() {
        persons = new ArrayList<>();
        persons.add(new Person(1, "Max", "Mustermann"));
        persons.add(new Person(2, "Erika", "Mustermann"));
    }

    @GetMapping("/api/person")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Person> fetchPersons() {
        return persons;
    }
}
