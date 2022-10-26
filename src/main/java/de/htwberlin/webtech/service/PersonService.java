package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Person;
import de.htwberlin.webtech.web.persistence.PersonEntity;
import de.htwberlin.webtech.web.persistence.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream().map(personEntity -> new Person(personEntity.getId(), personEntity.getFirstname(), personEntity.getLastname())).collect(Collectors.toList());
    }

}
