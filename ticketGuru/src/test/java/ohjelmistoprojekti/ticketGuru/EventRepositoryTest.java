package ohjelmistoprojekti.ticketGuru;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ohjelmistoprojekti.ticketGuru.domain.Event;
import ohjelmistoprojekti.ticketGuru.domain.EventRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EventRepositoryTest {

    @Autowired
    private EventRepository repository;

    @Test
    public void testFindByEventname() {
        List<Event> events = repository.findByEventname("Ankkarock");
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getAddress()).isEqualTo("Lintukatu 1");
    }

    @Test
    public void createNewEvent() {
        Event event = new Event();
        repository.save(event);
        assertThat(event.getId()).isNotNull();
    }

    @Test
    public void deleteNewEvent() {
        List<Event> events = repository.findByEventname("Ankkarock");
        Event event = events.get(0);
        repository.delete(event);
        List<Event> newEvents = repository.findByEventname("Ankkarock");
        assertThat(newEvents).hasSize(0);
    }

}
