package ohjelmistoprojekti.ticketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.domain.Event;
import ohjelmistoprojekti.ticketGuru.domain.EventRepository;
import ohjelmistoprojekti.ticketGuru.domain.TicketType;
import ohjelmistoprojekti.ticketGuru.domain.TicketTypeRepository;
@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    // Listanäkymä

    @RequestMapping("/eventlist")
    public String eventList(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "eventList";
    }

    // Tapahtuman lisäys

    @GetMapping("/events/add")
    public String addEvent(Model model) {
        model.addAttribute("event", new Event());
        return "addEvent";
    }

    // Tapahtuman tallennus H2:een (vaihtuu oikeaan tietokantaan myöhemmin)

    @PostMapping("/events/save")
    public String saveEvent(@Valid @ModelAttribute Event event, Model model) {
        
        eventRepository.save(event);
        return "redirect:/eventlist";
    }

    // Tapahtuman poisto

    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "redirect:/eventlist";
    }

    // Tapahtuman muokkaus

    @GetMapping("/events/edit/{id}")
    public String editEvent(@PathVariable("id") Long event_id, Model model) {

        Event existingEvent = eventRepository.findById(event_id).orElse(null);

        if (existingEvent != null) {
            model.addAttribute("event", existingEvent);
            return "editEvent";
        } else {
            return "error";
        }
    }

    // Muokatun tapahtuman tallennus

    @PostMapping("/events/edit/{id}")
    public String updateEvent(@PathVariable("id") Long event_id, @ModelAttribute Event updatedEvent) {
        Event existingEvent = eventRepository.findById(event_id).orElse(null);

        if (existingEvent != null) {
            existingEvent.setEventname(updatedEvent.getEventname());
            existingEvent.setAddress(updatedEvent.getAddress());
            existingEvent.setShowtime(updatedEvent.getShowtime());
            existingEvent.setDescription(updatedEvent.getDescription());
            existingEvent.setMaxtickets(updatedEvent.getMaxtickets());
            existingEvent.setDuration(updatedEvent.getDuration());

            eventRepository.save(existingEvent);
        }
        return "redirect:/eventlist";
    }

	//Lipputyypin lisääminen

	@GetMapping("/events/{event_id}/addTicketType")
	public String addTicketType(@PathVariable Long event_id, Model model) {
    	model.addAttribute("event_id", event_id);
        model.addAttribute("ticketType", new TicketType());
        return "addTicketType";
}
	//Lipputyypin tallentaminen
	
	
	@PostMapping("/events/{event_id}/saveTicketType")
	public String saveTicketType(@PathVariable Long event_id, @ModelAttribute TicketType ticketType) {
	    Event event = eventRepository.findById(event_id).orElse(null);
	    if (event != null) {
	        ticketType.setEvent(event);
	        ticketTypeRepository.save(ticketType);
	        event.getTicketTypes().add(ticketType); 
	        eventRepository.save(event);
	    }
	    return "redirect:/eventlist";
	}





}
