package de.htwberlin.webtech.web.persistence;

import de.htwberlin.webtech.service.IdeaService;
import de.htwberlin.webtech.web.api.Idea;
import de.htwberlin.webtech.web.api.IdeaManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class IdeaRestController {

    private final IdeaService ideaService;

    public IdeaRestController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }
    @GetMapping(path = "/api/idea")
    public ResponseEntity<List<Idea>> fetchIdea() {
        return ResponseEntity.ok(ideaService.findAll());
    }
    @PostMapping(path = "/api/idea")
    public ResponseEntity<Void> createIdea(@RequestBody IdeaManipulationRequest request) throws URISyntaxException {
        var idea = ideaService.create(request);
        URI uri = new URI("/api/idea/" + idea.getId());
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(path = "/api/idea/{id}")
    public ResponseEntity<Void> deleteIdea(@PathVariable Long id) {
        boolean sucessfull = ideaService.deleteById(id);
        return sucessfull? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
