package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Person;
import de.htwberlin.webtech.web.api.PersonManipulationRequest;
import de.htwberlin.webtech.web.persistence.PersonEntity;
import de.htwberlin.webtech.web.persistence.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonTransformer personTransformer;

    public PersonService(PersonRepository personRepository, PersonTransformer personTransformer) {
        this.personRepository = personRepository;
        this.personTransformer = personTransformer;
    }

    public List<Person> findAll() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream().map(personTransformer::transformEntity).collect(Collectors.toList());
    }

    public Person findById(Long id) {
        var personEntity = personRepository.findById(id);
        return personEntity.map(personTransformer::transformEntity).orElse(null);
    }

    public Person create(PersonManipulationRequest request) {
        var personEntity = new PersonEntity(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPasswort());
        personEntity = personRepository.save(personEntity);
        return personTransformer.transformEntity(personEntity);
    }

    public Person update(Long id, PersonManipulationRequest request) {
        var personEntityOptional = personRepository.findById(id);
        if (personEntityOptional.isEmpty()) {
            return null;
        }
        var personEntity = personEntityOptional.get();
        personEntity.setFirstname(request.getFirstName());
        personEntity.setLastname(request.getLastName());
        personEntity.setEmail(request.getEmail());
        personEntity.setPasswort(request.getPasswort());
        personEntity = personRepository.save(personEntity);

        return personTransformer.transformEntity(personEntity);

    }

    public boolean deleteById(Long id) {
        if (!personRepository.existsById(id)) {
            return false;
        }
        personRepository.deleteById(id);
        return true;

    }
}
