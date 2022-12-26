package de.htwberlin.webtech.web.persistence;

import de.htwberlin.webtech.service.IdeaService;
import de.htwberlin.webtech.web.api.Idea;
import de.htwberlin.webtech.web.api.IdeaManipulationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


     @ExtendWith(MockitoExtension.class)
    class IdeaRestControllerTest {

        @Mock
        private IdeaService ideaService;

        @InjectMocks
        private IdeaRestController controller;

        @Test
        @DisplayName("should return score")
        void testFetchIdea() {
            List<Idea> expectedIdea = List.of(
                    new Idea(1L, "Momo", "mhh.hammouri@gmail.com", "test1"),
                    new Idea(2L, "Momo2", "mhh.hammouri@gmail.com", "test2")
            );

            when(ideaService.findAll()).thenReturn(expectedIdea);
            ResponseEntity<List<Idea>> response = controller.fetchIdea();

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(expectedIdea, response.getBody());

            assertAll("ideas",
                    () -> assertEquals(1L, response.getBody().get(0).getId()),
                    () -> assertEquals("Momo", response.getBody().get(0).getName()),
                    () -> assertEquals("mhh.hammouri@gmail.com", response.getBody().get(0).getEmail()),
                    () -> assertEquals("test1", response.getBody().get(0).getIdea()),
                    () -> assertEquals(2L, response.getBody().get(1).getId()),
                    () -> assertEquals("Momo2", response.getBody().get(1).getName()),
                    () -> assertEquals("mhh.hammouri@gmail.com", response.getBody().get(1).getEmail()),
                    () -> assertEquals("test2", response.getBody().get(1).getIdea()));
        }

        @Test
        @DisplayName("create Method works and the location header is set correctly")
        void createidea() throws URISyntaxException {
            IdeaManipulationRequest request = new IdeaManipulationRequest(1L, "Momo", "mhh.hammouri@gmail.com", "test1");

            Idea expectedIdea = new Idea(1L, "Momo", "mhh.hammouri@gmail.com", "test1");
            when(ideaService.create(request)).thenReturn(expectedIdea);

            ResponseEntity<Void> response = controller.createIdea(request);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(new URI("/api/idea/1"), response.getHeaders().getLocation());
        }
    }
