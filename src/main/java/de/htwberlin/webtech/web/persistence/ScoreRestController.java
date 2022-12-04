package de.htwberlin.webtech.web.persistence;

import de.htwberlin.webtech.service.ScoreService;
import de.htwberlin.webtech.web.api.Score;
import de.htwberlin.webtech.web.api.Scoremanipulationrequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ScoreRestController {

    private final ScoreService scoreService;

    public ScoreRestController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping(path = "/api/score")
    public ResponseEntity<List<Score>> fetchScore() {
        return ResponseEntity.ok(scoreService.findAll());
    }

    @PostMapping(path = "/api/score")
    public ResponseEntity<Void> createscore(@RequestBody Scoremanipulationrequest request) throws URISyntaxException {
        var score = scoreService.create(request);
        URI uri = new URI("/api/score/" + score.getId());
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(path = "/api/score/{id}")
    public ResponseEntity<Void> deletescore(@PathVariable Long id) {
        boolean sucessfull = scoreService.deleteById(id);
        return sucessfull? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
