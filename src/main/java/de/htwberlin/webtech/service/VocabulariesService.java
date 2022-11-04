package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Vocabularies;
import de.htwberlin.webtech.web.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VocabulariesService {

    private final VocabulariesRepository vocabulariesRepository;
    private final PersonTransformer personTransformer;
    private final PersonRepository personRepository;
    private de.htwberlin.webtech.web.persistence.PersonEntity PersonEntity;

    public VocabulariesService(VocabulariesRepository vocabulariesRepository, PersonRepository personRepository, PersonTransformer personTransformer) {
        this.vocabulariesRepository = vocabulariesRepository;
        this.personRepository = personRepository;
        this.personTransformer = personTransformer;
    }
    public List<Vocabularies> findAll() {
        List<VocabulariesEntity> vocabularies = vocabulariesRepository.findAll();
        return vocabularies.stream().map(this::transformEntity).collect(Collectors.toList());
    }
    public Vocabularies create(Vocabulariesmanipulationrequest request) {
        var vocabulariesEntity = new VocabulariesEntity(request.getWord(), PersonEntity);
        vocabulariesEntity = vocabulariesRepository.save(vocabulariesEntity);
        return transformEntity(vocabulariesEntity);
    }
    private Vocabularies transformEntity(VocabulariesEntity vocabulariesEntity) {
        return new Vocabularies(vocabulariesEntity.getId(), vocabulariesEntity.getWord(), personTransformer.transformEntity(vocabulariesEntity.getPerson()));

    }
}

