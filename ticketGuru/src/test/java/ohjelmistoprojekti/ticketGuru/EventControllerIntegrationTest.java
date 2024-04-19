package ohjelmistoprojekti.ticketGuru;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ohjelmistoprojekti.ticketGuru.domain.Event;
import ohjelmistoprojekti.ticketGuru.domain.EventRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EventRepository eventRepository;

    @LocalServerPort
    private int port;

    @Test
    public void testCreateEvent() {
        Event event = new Event("Test Event", "Test Address", LocalDateTime.now(), "Test Description", 100, 120);

        ResponseEntity<Event> response = restTemplate.withBasicAuth("mikko", "admin").postForEntity("/events", event, Event.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        @SuppressWarnings("null")
        Optional<Event> savedEvent = eventRepository.findById(response.getBody().getId());
        assertTrue(savedEvent.isPresent());
        assertEquals("Test Event", savedEvent.get().getEventname());
    }
}
