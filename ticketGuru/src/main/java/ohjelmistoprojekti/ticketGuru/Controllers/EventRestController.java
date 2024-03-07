package ohjelmistoprojekti.ticketGuru.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.ticketGuru.Classes.Event;
import ohjelmistoprojekti.ticketGuru.Classes.EventRepository;


@RestController
public class EventRestController {
	
	@Autowired
    private EventRepository eventrepository;

	
//Kaikki tiedot JSON-muodossa
	
	
    @RequestMapping(value="/events", method = RequestMethod.GET)
    public List<Event> EventListRest() {	
        return (List<Event>) eventrepository.findAll();
    }    

//ID:n avulla haettavat tiedot tietystä tapahtumasta
    
    @RequestMapping(value="/event/{id}", method = RequestMethod.GET)
    public Optional<Event> findEventRest(@PathVariable("id") Long eventid) {	
    	return eventrepository.findById(eventid);
    }
    
//Tapahtuman lisääminen Postmanissa
    
    @RequestMapping (value= "/events", method = RequestMethod.POST)
    public Event addEvent(@RequestBody Event event) {
         return eventrepository.save(event);
            
}
    
//Tapahtuman poisto ID:llä Postmanissa
    
    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long eventid) {
        Optional<Event> event = eventrepository.findById(eventid);
        if (event.isPresent()) {
            eventrepository.deleteById(eventid);
            return new ResponseEntity<>("Event with ID " + event + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Event with ID " + event + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
