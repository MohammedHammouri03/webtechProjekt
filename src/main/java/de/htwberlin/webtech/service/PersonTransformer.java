package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Person;
import de.htwberlin.webtech.web.persistence.PersonEntity;
import de.htwberlin.webtech.web.persistence.VocabulariesEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonTransformer {

    public Person transformEntity(PersonEntity personEntity) {
        var vocabulariesid = personEntity.getVocabularies().stream().map(VocabulariesEntity::getId).collect(Collectors.toList());
        return new Person(personEntity.getId(), personEntity.getFirstname(), personEntity.getLastname(), personEntity.getEmail(), vocabulariesid);
    }
}
