package de.htwberlin.webtech.web.persistence;

import de.htwberlin.webtech.service.WebsiteService;
import de.htwberlin.webtech.web.api.Website;
import de.htwberlin.webtech.web.api.Websitemanipulationrequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class WebsiteRestController {

    private final WebsiteService websiteService;

    public WebsiteRestController(WebsiteService websiteService) {
        this.websiteService = websiteService;
    }

    @GetMapping(path = "/api/vokabel")
    public ResponseEntity<List<Website>> fetchVokabel() {
        return ResponseEntity.ok(websiteService.findAll());
    }

    @PostMapping(path = "/api/voakbel")
    public ResponseEntity<Void> createVokabel(@RequestBody Websitemanipulationrequest request) throws URISyntaxException {
        var website = websiteService.create(request);
        URI uri = new URI("/api/vokabel/" + website.getId());
        return ResponseEntity.created(uri).build();
    }
    @PostMapping(path = "/api/vokabel")
    public ResponseEntity<Void> createPerson(@RequestBody Websitemanipulationrequest request) throws URISyntaxException {
        var website = websiteService.create(request);
        URI uri = new URI("/api/persons/" + website.getId());
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(path = "/api/vokabel/{id}")
    public ResponseEntity<Void> deleteVokabel(@PathVariable Long id) {
        boolean sucessfull = websiteService.deleteById(id);
        return sucessfull? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
