package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Person;
import de.htwberlin.webtech.web.persistence.PersonEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonTransformer {

    public static Person transformEntity(PersonEntity personEntity) {
        var vocabularies = personEntity.getVocabularies().stream().map(v -> v.getId()).collect(Collectors.toList());
        return new Person(personEntity.getId(), personEntity.getFirstname(), personEntity.getLastname(), personEntity.getEmail(), vocabularies);
    }
}


