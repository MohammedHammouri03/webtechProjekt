package de.htwberlin.webtech.web.persistence;

import de.htwberlin.webtech.service.WebsiteService;
import de.htwberlin.webtech.web.api.Website;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WebsiteRestControllerTest {

    @Mock
    private WebsiteService websiteService;

    @InjectMocks
    private WebsiteRestController controller;

    @Test
    @DisplayName("should return vocabulary")
    void fetchVocabulary() {
        List<Website> expectedWebsites = List.of(
                new Website(1L, "afternoon", "Nachmittag", true),
                new Website(2L, "breakfast", "Frühstück", false)
        );
        when(websiteService.findAll()).thenReturn(expectedWebsites);

        ResponseEntity<List<Website>> response = controller.fetchVokabel();

        assertEquals (HttpStatus.OK, response.getStatusCode());
        assertEquals (expectedWebsites, response.getBody());

        assertEquals(1L, response.getBody().get(0).getId());
        assertEquals("afternoon", response.getBody().get(0).getWord());
        assertEquals("Nachmittag", response.getBody().get(0).getTranslation());
        assertEquals(true, response.getBody().get(0).isFavorite());
        assertEquals(2L, response.getBody().get(1).getId());
        assertEquals("breakfast", response.getBody().get(1).getWord());
        assertEquals("Frühstück", response.getBody().get(1).getTranslation());
        assertEquals(false, response.getBody().get(1).isFavorite());
    }
}
