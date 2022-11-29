package de.htwberlin.webtech.web.persistence;

import de.htwberlin.webtech.service.VocabulariesService;
import de.htwberlin.webtech.web.api.Vocabularies;
import de.htwberlin.webtech.web.api.Vocabulariesmanipulationrequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class VocabulariesRestController {

    private final VocabulariesService vocabulariesService;

    public VocabulariesRestController(VocabulariesService vocabulariesService) {
        this.vocabulariesService = vocabulariesService;
    }

    @GetMapping(path = "/api/vocabularies")
    public ResponseEntity<List<Vocabularies>> fetchVocabularies() {
        return ResponseEntity.ok(vocabulariesService.findAll());
    }

    @PostMapping(path = "/api/vocabularies/")
    public ResponseEntity<Void> createVocabularies(@RequestBody Vocabulariesmanipulationrequest request) throws URISyntaxException {
        var vocabularies = vocabulariesService.create(request);
        URI uri = new URI("/api/vocabularies/" + vocabularies.getId());
        return ResponseEntity.created(uri).build();
    }
}
