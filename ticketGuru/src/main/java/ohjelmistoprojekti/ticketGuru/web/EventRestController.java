package ohjelmistoprojekti.ticketGuru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.domain.Event;
import ohjelmistoprojekti.ticketGuru.domain.EventRepository;

@RestController
public class EventRestController {

    @Autowired
    private EventRepository eventrepository;

    // Kaikki tiedot JSON-muodossa

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> EventListRest() {
        return (List<Event>) eventrepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietystä tapahtumasta

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    public Optional<Event> findEventRest(@PathVariable("id") Long eventid) {
        return eventrepository.findById(eventid);
    }

    // Tapahtuman lisääminen Postmanissa

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Event addEvent(@Valid @RequestBody Event event) {
        return eventrepository.save(event);

    }

    // Tapahtuman poisto ID:llä Postmanissa

    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long eventid) {
        Optional<Event> event = eventrepository.findById(eventid);
        if (event.isPresent()) {
            eventrepository.deleteById(eventid);
            return new ResponseEntity<>("Event with ID " + event + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Event with ID " + event + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    // Tapahtuman muokkaaminen PUT-metodilla
    @RequestMapping(value = "/event/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateEvent(@PathVariable("id") Long eventId, @RequestBody Event updatedEvent) {
        Optional<Event> event = eventrepository.findById(eventId);
        if (event.isPresent()) {
            // Update the event data
            updatedEvent.setId(eventId); // Make sure the ID is set correctly
            eventrepository.save(updatedEvent);
            return ResponseEntity.ok("Event with ID " + eventId + " has been updated.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
